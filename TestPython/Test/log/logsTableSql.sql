CREATE TABLE `logs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `log_type` char(20) DEFAULT NULL COMMENT '日志类型',
  `log_context` text COMMENT '日志内容',
  `access_ip` char(20) DEFAULT NULL COMMENT '访问者ip地址',
  `access_country` char(20) DEFAULT NULL COMMENT '访问者国家',
  `access_city` char(20) DEFAULT NULL COMMENT '访问者省份',
  `access_county` char(20) DEFAULT NULL COMMENT '访问者省份',
  `access_pid` char(20) DEFAULT NULL COMMENT '访问者所占用进程',
  `isp` char(20) DEFAULT NULL COMMENT '网络提供商',
  `access_type` date DEFAULT NULL COMMENT '访问方式',
  `access_status` date DEFAULT NULL COMMENT '访问状态',
  `access_date` date DEFAULT NULL COMMENT '访问日期',
  `access_time` time DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
