package com.iftest.day5;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class JSONTest {
	public static void main(String[] args) throws Exception{
		doPost();
	}
	public static void doPost() throws Exception{
//		1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try{
//			2.新建一个POST请求方法的对象，使用接口地址进行初始化
			HttpPost request = new HttpPost("http://192.168.146.133:8080/test158/JSONServlet");
//			3.新建一个StringEntity实体对象，使用含有参数和参数值的json包进行初始化
			JSONObject obj = new JSONObject();
			obj.put("a", 1);
			obj.put("b", 2);
			StringEntity entity= new StringEntity(obj.toString(),"utf-8");
//			4.将实体对象赋值给请求的实体属性
			request.setEntity(entity);
//			5.新建一个响应对象，接收客户端发送请求的响应
			CloseableHttpResponse response =client.execute(request);
			try{
//				6.从响应中提取实际结果
				HttpEntity responseEntity= response.getEntity();//响应实体
				String result = EntityUtils.toString(responseEntity);//将EntityUtils类型转换为String类型
				System.out.println(result);
//				7.将实际结果与用例中的预期结果进行比较
			

			}finally{
				response.close();
			}

		}finally{
			client.close();
		}

	}

}
