package xxsystem.test;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import com.framework.utils.HttpUtils;
import com.framework.utils.MD5Util;
import com.sys.model.SysUserInfo;

/**
 * @describe HttpClient 测试类
 * @author by - 吥悔
 * @date 2017年4月10日 下午10:55:42
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class HttpClientTest {
	/**
	 * 抽取公司的方法
	 */
	public void requestMethod(SysUserInfo userInfo, String requestPath) throws Exception {
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("Content-Type", "application/json; charset=utf-8");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json; charset=utf-8");
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		JSONObject json = (JSONObject) JSONObject.toJSON(userInfo);
		System.out.println(json.toString());
		HttpResponse response = HttpUtils.doPost("http://127.0.0.1:8080", requestPath, "PSOT", headers, querys, json.toString());
		System.out.println(response.toString());
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}
	
	public void addUser() {
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setPhonenumber("15072330003");
		userInfo.setNickname("by-吥悔");
		userInfo.setUsername("miaoZhou");
		userInfo.setIdcardno("42022219900424671X");
		userInfo.setAddress("http://www.javazlm.com/");
		String md5 = MD5Util.generateMD5("admin");
		userInfo.setPassword(md5);
		try {
			this.requestMethod(userInfo, "/xxsystem/m/user/addUser.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login() {
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setPhonenumber("15072330003");
		String md5 = MD5Util.generateMD5("admin");
		userInfo.setPassword(md5);
		try {
			this.requestMethod(userInfo, "/xxsystem/m/user/login.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		HttpClientTest test = new HttpClientTest();
//		test.addUser();
		test.login();
	}
}