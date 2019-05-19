import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.land.rest.utils.HttpComponentsClientRestfulHttpRequestFactory;

public class TestController {
	
	@Test
	public void testDept() {
		//Test get info by id
//		String type = "dept/1";
//		String p = "";
		
		//test get all info
//		String type = "dept/all";
//		String p = "";
		
		//test get part info
//		String type = "dept";
//		String p = "{\"countMin\":1,\"countMax\":3}";
//		HttpMethod met = HttpMethod.GET;
		
		//test post info
//		String type = "dept";
//		String p = "{\"deptName\":\"研发部二部\",\"established\":1557849600000,\"empCount\":1,\"coId\":1,\"makeDate\":1557849600000,\"makeBy\":\"jie\",\"updateDate\":1557849600000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null}";
//		HttpMethod met = HttpMethod.POST;
		//test put info
//		String type = "dept";
//		String p = "{\"deptId\":10,\"deptName\":\"研发部二部第一开发部\",\"established\":1557849600000,\"empCount\":2,\"coId\":1,\"makeDate\":1557849600000,\"makeBy\":\"jie\",\"updateDate\":1557849600000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null}";
//		HttpMethod met = HttpMethod.PUT;
		
		//test delete info 
		String type = "dept/10";
		String p = "";
		HttpMethod met = HttpMethod.DELETE;
		
		System.out.println(getResponseBody(type, met, p));
	}
	
	@Test
	public void testCom() {
		//Test get info by id
//		String type = "co/1";
//		String p = "";
		
		//test get all info
//		String type = "co/all";
//		String p = "";
//		HttpMethod met = HttpMethod.GET;
		
		//test post info
//		String type = "co";
//		String p = "{\"parentId\":1,\"corporationNature\":\"股份制企业\",\"coName\":\"阿里巴巴\",\"tel\":\"86-571-88480877\",\"addr\":\"浙江省杭州市滨江区网商路699号\",\"web\":\"www.zoneland.net\",\"established\":1557763200000,\"makeDate\":1557158400000,\"makeBy\":\"jie\",\"updateDate\":1557763200000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null,\"coProfile\":\"阿里巴巴（Alibaba.com）是全球企业间（B2B）电子商务的著名品牌，是全球国际贸易领域内最大、最活跃的网上交易市场和商人社区。\"}";
//		HttpMethod met = HttpMethod.POST;
		
		//test put info
//		String type = "co";
//		String p = "{\"coId\":3,\"parentId\":1,\"corporationNature\":\"股份制企业\",\"coName\":\"阿里巴巴集团\",\"tel\":\"86-571-88480877\",\"addr\":\"浙江省杭州市滨江区网商路699号\",\"web\":\"www.zoneland.net\",\"established\":1557763200000,\"makeDate\":1557158400000,\"makeBy\":\"jie\",\"updateDate\":1557763200000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null,\"coProfile\":\"阿里巴巴（Alibaba.com）是全球企业间（B2B）电子商务的著名品牌，是全球国际贸易领域内最大、最活跃的网上交易市场和商人社区。\"}";
//		HttpMethod met = HttpMethod.PUT;
		//test delete info 
		String type = "co/3";
		String p = "";
		HttpMethod met = HttpMethod.DELETE;
		
		System.out.println(getResponseBody(type, met, p));
	}
	
	@Test
	public void testEmp() {
		//Test get info by id
//		String type = "emp/1";
//		String p = "";
		
		//test get all info
//		String type = "emp/all";
//		String p = "";
		
		//test get part info
//		String type = "emp";
//		String p = "{\"commMin\":2000,\"commMax\":20000}";
//		HttpMethod met = HttpMethod.GET;
		
		//test post info
//		String type = "emp";
//		String p = "{\"emp\":{\"mgrId\":1,\"permission\":\"S\",\"hireDate\":1557849600000,\"sal\":10000.0,\"comm\":20000.0,\"deptId\":1,\"makeDate\":1557849600000,\"makeBy\":\"jie\",\"updateDate\":1557849600000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null},\"empinfo\":{\"name\":\"溧阳\",\"sex\":\"男\",\"cardId\":\"512501197203035172\",\"dob\":1544457600000,\"age\":30,\"degree\":\"本科\",\"makeDate\":1558022400000,\"makeBy\":\"jie\",\"updateDate\":1558022400000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null}}";
//		HttpMethod met = HttpMethod.POST;
		//test put info
//		String type = "emp";
//		String p = "{\"emp\":{\"empId\":20,\"mgrId\":1,\"permission\":\"S\",\"hireDate\":1557849600000,\"sal\":10000.0,\"comm\":20200.0,\"deptId\":1,\"makeDate\":1557849600000,\"makeBy\":\"jie\",\"updateDate\":1557849600000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null},\"empinfo\":{\"empId\":20,\"name\":\"溧阳\",\"sex\":\"男\",\"cardId\":\"512501197203035172\",\"dob\":1544457600000,\"age\":30,\"degree\":\"本科\",\"makeDate\":1558022400000,\"makeBy\":\"jie\",\"updateDate\":1558022400000,\"updateBy\":\"jie\",\"spare1\":null,\"spare2\":null,\"spare3\":null,\"spare4\":null}}";
//		HttpMethod met = HttpMethod.PUT;
		//test delete info 
		String type = "emp/21";
		String p = "";
		HttpMethod met = HttpMethod.DELETE;
		
		System.out.println(getResponseBody(type, met, p));
	}
	
	
	private static String getResponseBody(String type, HttpMethod enums, String parm) {
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setRequestFactory(new HttpComponentsClientRestfulHttpRequestFactory());
        MediaType t = MediaType.parseMediaType("application/json; charset=UTF-8");
	    String url = "http://localhost:8080/" + type;
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(t);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> httpEntity = new HttpEntity<String>(parm, headers);
	    ResponseEntity<String> responseEntity = restTemplate.exchange(url, enums, httpEntity, String.class);
	    String body = responseEntity.getBody();
		return body;
	}
}
