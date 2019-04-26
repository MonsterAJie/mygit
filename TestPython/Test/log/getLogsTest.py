'''
Created on 2019年4月24日

@author: Jie
'''
import time
import os
import mysql.connector
import re
import requests
import json
import datetime
from Test.log.MYSQL import MSSQLUtil
import sys
import configparser
import MYSQL
import threading
from enum import Enum

sys.path.append(r'H:\gitspace\TestPython\Test\log')                         #配置文件路径设置

db = MSSQLUtil()                                                            #调用数据库工具类
 
#从文件系统读取配置文件
cf = configparser.ConfigParser()
cf.read("mycnf.txt", encoding="utf-8-sig")                                  #读取配置文件

nowDate = time.strftime("%Y-%m-%d", time.localtime())                       #程序运行首日期
tomcatcount = cf.get("tomcatFileVar", "filecount")                          #得到监控tomcat的数量

# fileTop = cf.get("tomcatFileVar", "fileTop")                                #配置文件中获取文件基本信息
# fileEnd = cf.get("tomcatFileVar", "fileEnd")
readType = cf.get("tomcatFileVar", "readType")
encode = cf.get("tomcatFileVar", "encode")

tomcatSql1 = cf.get("sql", "tomcatSql1")                                    #拿到配置文件中的sql模板语句
nginxSql = cf.get("sql", "nginxSql")

tomcatFlag = cf.get("manager", "tomcatFlag")                                #是否启动log收集标识，0不启动，1启动
nginxFlag = cf.get("manager", "nginxFlag")      

nginxlogpath = cf.get("nginxFileVar", "nginxpath")                                       #读取配置文件中的nginxlog路径

# print(fileTop, nginxlogpath)
# tomcatlogfile = open(fileTop + nowDate + fileEnd, readType, encoding=encode)      #读取的文件路径    r以文本形式读取    字符编码为utf-8
# nginxlogfile = open(nginxlogpath, encoding=encode)                                           #读取的文件路径    r以文本形式读取    字符编码为utf-8

class logsTable(object):                                                    #临时存储用户信息
    pass

class logType(Enum):
    TOMCAT  = 0
    NGINX   = 1

def get_file_info(type, i):                                                       #参数i表示第几个监控文件type 表示文件类型
    if type == logType.TOMCAT:
        fileTop = cf.get("tomcatFileVar", "fileTop" + str(i))                                #配置文件中获取文件基本信息
        fileEnd = cf.get("tomcatFileVar", "fileEnd" + str(i))
        filename = fileTop + "{0}" + fileEnd                                    #{0}用于文件替换
        return open(fileTop + nowDate + fileEnd, readType, encoding=encode), filename
    elif type == logType.NGINX:
        filename = nginxlogpath
        return open(nginxlogpath, encoding=encode), filename


def get_ip_info(temp):                                                      #获取国家省市信息
    
    url = "http://ip.taobao.com/service/getIpInfo.php?ip=%s" % temp.ipAddr
    a = requests.get(url=url)
    try:
        info = json.loads(a.text)
    #     print(info, type(info))
    #     print("IP:%s" % info["data"]["ip"])
    #     print("国家:%s" % info["data"]['country'])
    #     print("城市:%s" % info["data"]["city"])
    #     print("地区:%s" % info["data"]["county"])
    #     print("运营商:%s" % info["data"]["isp"])
    #     print("运营商id:%s" % info["data"]["isp_id"])
        temp.country = info["data"]['country']
        temp.city = info["data"]['city']
        temp.county = info["data"]['county']
        temp.isp = info["data"]['isp']
    #     return temp
    except BaseException as e:
        print('except:', e)
        temp.country = '默认'
        temp.city = '默认'
        temp.county = '默认'
        temp.isp = '默认'

def getLogInfo(str):
    table = logsTable()
    strList = re.split(' ', str)
#     print(strList[0])                         
    table.ipAddr = strList[0]                                               #得到用户的ip地址
#     dateTime = strList[3] + ' ' + strList[4]
#     print(dateTime[1:-1])                               
    dd = datetime.datetime.strptime(strList[3][1:],'%d/%b/%Y:%H:%M:%S')
    dt = dd.strftime('%Y-%m-%d %H:%M:%S')
#     print(dt)
    dt = re.split(' ', dt)
    print(dt)
    table.date = dt[0]                                                      #得到用户访问的日期
    table.time = dt[1]                                                      #得到用户访问的时间
#     logsTable. = strList[0]
#     print(strList[5][1:])
    table.access_type = strList[5][1:]                                      #得到用户访问方式
#     print(strList[6][:])
    table.context = strList[6][:]                                           #用户访问资源
#     print(strList[7][:-1])
    table.status = strList[8]                                               #用户访问结果状态
#     print(strList[8])
    table.pid = strList[9]                                                  #用户占用pid
#     print(strList[9])
    return table

def dataSave(tableData, type):                                                    #将数据保存数据库
    if type == logType.TOMCAT:
        sql = tomcatSql1.format(tableData.context, tableData.ipAddr, tableData.country, tableData.city, tableData.county, tableData.pid, tableData.isp, tableData.access_type, tableData.status, tableData.date, tableData.time)
    elif type == logType.NGINX:
        sql = nginxSql.format(tableData.context, tableData.ipAddr, tableData.country, tableData.city, tableData.county, tableData.pid, tableData.isp, tableData.access_type, tableData.status, tableData.date, tableData.time)
    print(sql)
    db.ExecNonQuery(sql)

def follow(thefile, nowDate, type):
    thefile.seek(0)                                           #从文件开头开始移动
    while True:
        newDate = time.strftime("%Y-%m-%d", time.localtime())   #程序运行时日期
        if newDate in nowDate:                                  #日期相同继续当前文件log信息读取
            line = thefile.readline()                           #读取文件中的一行数据
            if not line:                                        
                time.sleep(0.1)
                continue
#             print(line)
            yield line                                          #返回读取的一行数据
        else:                                                   #日期不同更改为当天的log文件,继续读取信息
            if type == logType.TOMCAT:
                nowDate = newDate                                   #日期不相同的情况下更换日期为最新的
                thread = threading.current_thread()
                threadName = thread.getName()                   #根据线程名得到文件名模板
                newfilename = threadName.format(nowDate)        #根据线程名和日期得到新的文件名
#                 print(thread.getName())
                thefile = open(newfilename, readType, encoding=encode)  #打开新log文件进行统计
                thefile.seek(0)                               #从文件开头开始移动

def logsDataBL(str, type):                                            #处理读取的数据，保存到数据库
    tableTemp = getLogInfo(str)                           #获取用户访问基本信息
    get_ip_info(tableTemp)                                      #获取访问者国家省份城市等信息
    dataSave(tableTemp, type)

def tomcatLogManager(file):
    loglines = follow(file, nowDate, logType.TOMCAT)                         #得到读取的一行数据
    for line in loglines:                                       #返回的数据类中取值
        if line.strip('\n'):                                    #去除读取的换行符
            logsDataBL(line, logType.TOMCAT)                                    #数据保存到数据库函数


def nginxLogManager(file):
    loglines = follow(file, nowDate, logType.TOMCAT)                         #得到读取的一行数据
    for line in loglines:                                       #返回的数据类中取值
        if line.strip('\n'):                                    #去除读取的换行符
            logsDataBL(line, logType.NGINX)                                    #数据保存到数据库函数

def main():
    if tomcatFlag == '1':
        for i in range(int(tomcatcount)):                                            #监控几个tomcat启动几个线程
            print('tomcat' + str(i) + '日志收集设置启动')
            tomcatfile, filename = get_file_info(logType.TOMCAT, i)
            tomcatThread = threading.Thread(target = tomcatLogManager, args=(tomcatfile,))
            tomcatThread.setName(filename)                      #设置线程名，一般为文件名，用于文件替换
            tomcatThread.start()
    else:
        print('tomcat日志收集设置不启动')
    if nginxFlag == '1':    
        print('nginx日志收集设置启动')
        nginxfile, filename = get_file_info(logType.NGINX, i)
        nginxThread = threading.Thread(target = nginxLogManager, args=(nginxfile,))
        nginxThread.setName(filename)
        nginxThread.start()
    else:
        print('nginx日志收集设置不启动')
#     tomcatLogManager()

if __name__ == '__main__':
    print('启动日志监控脚本')
    main()
        
        
        
        
        
        