

import java.util.HashSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JedisTest.class);
	
	/**
	 * 集群版测试
	 * <p>Title: testJedisCluster</p>
	 * <p>Description: </p>
	 */
	@Test
	public void testJedisCluster() {
		LOGGER.debug("调用redisCluster开始");
		HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.32.128", 7001));
		nodes.add(new HostAndPort("192.168.32.128", 7002));
		nodes.add(new HostAndPort("192.168.32.128", 7003));
		nodes.add(new HostAndPort("192.168.32.128", 7004));
		nodes.add(new HostAndPort("192.168.32.128", 7005));
		nodes.add(new HostAndPort("192.168.32.128", 7006));
		LOGGER.info("创建一个JedisCluster对象");
		JedisCluster cluster = new JedisCluster(nodes);
		LOGGER.debug("设置key1的值为1000");
//		cluster.set("REDIS_COM_ID_KEY", "2");
		
		LOGGER.debug("从Redis中取key1的值");
		String string = cluster.get("REDIS_COM_ID_KEY");
//		long incr = cluster.incr("REDIS_DEPT_ID_KEY");
		System.out.println(string);
		cluster.close();
		try {
//			int a = 1/0;
		} catch (Exception e) {
			LOGGER.error("系统发送异常", e);
		}
	}
	
}
