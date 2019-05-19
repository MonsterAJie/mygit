package com.land.rest.dao;

/**
 * 
 * @ClassName:  JedisClient   
 * @Description:TODO(访问数据库接口)   
 * @author: AJie
 * @date:   2019年5月19日 下午3:22:44   
 *     
 * @Copyright: 2019 https://github.com/MonsterAJie/mygit
 *
 */
public interface JedisClient {

	String get(String key);
	
	String set(String key, String value);
	
	String hget(String hkey, String key);
	
	long hset(String hkey, String key, String value);
	
	long incr(String key);
	
	long expire(String key, int second);
	
	long ttl(String key);
	
	long del(String key);
	
	long hdel(String hkey, String key);
	
}
