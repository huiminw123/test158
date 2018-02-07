package com.iftest.day04;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class FormTest {
	public static void main(String[] args) throws Exception{
		doPost();
		doGet();
		doPost1();
	}
	public static void doPost() throws Exception{
//		1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try{
//			2.新建一个使用POST请求方法的请求对象,使用接口的请求地址进行初始化
			HttpPost request = new HttpPost("http://192.168.146.133:8080/test158/FormServlet");
			
//			3.新建一个UrlEncodedFormEntity实体对象,使用参数和参数值列表进行初始化
			List<NameValuePair> list = new ArrayList<NameValuePair>();//ArrayList:动态数组
			// ArrayList是实现List接口的动态数组,所谓动态就是它的大小是可变的
			list.add(new BasicNameValuePair("a","1"));
			list.add(new BasicNameValuePair("b","2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
			
			//			4.将实体对对象赋值给请求对象的实体属性
			request.setEntity(entity);//使用set实体
//			5.新建一个响应对象,接收客户端发送请求的响应
			CloseableHttpResponse response = client.execute(request);
			try{
//				6.从响应里面提取时间结果
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
	public static void doGet() throws Exception{
//		1.新建一个客户端对象
		CloseableHttpClient client=HttpClients.createDefault();
		try {
//		    2.新建一个使用GET请求方法的请求对象
			HttpGet request = new HttpGet();
//			3.给请求对象的请求地址属性赋值
			URI uri = new URIBuilder()  				//构造一个请求地址
					.setScheme("https")  				//确定协议
					.setHost("api.weixin.qq.com")    	//确定地址
					.setPath("/cgi-bin/token")          //确定资源地址
					.setParameter("grant_type", "client_credential")   			//参数
					.setParameter("appid", "wxd1d3bd9078dc815a")				//参数
					.setParameter("secret", "cfa868082885e6df5f90bb57ec4bf9d4") //参数
					.build();
			
			request.setURI(uri);
//			4.新建一个响应对象,接收客户端发送请求对象的响应
			CloseableHttpResponse response=client.execute(request);
			try{
//				5.从响应中提取实际结果
				//不对
				HttpEntity responseEntity=response.getEntity();
				String sum =EntityUtils.toString(responseEntity);
				System.out.println(sum);
				JSONObject object = JSONObject.parseObject(sum);
				String sd = object.getString("access_token");
//				6.用实际结果与用例中的预期结果进行比较
			}finally{
				response.close();
			}
	
		}finally{
			client.close();
			
		}
		
	}
	public static void doPost1() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();
	try{
//		2.新建一个使用POST请求方法的请求对象,使用接口的请求地址进行初始化
		HttpPost request = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");
		
//		3.新建一个UrlEncodedFormEntity实体对象,使用参数和参数值类表进行初始化
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("username","qwer123"));
		list.add(new BasicNameValuePair("password","123456"));
		list.add(new BasicNameValuePair("passwordConfirm","123456"));
		list.add(new BasicNameValuePair("firstName",""));
		list.add(new BasicNameValuePair("lastName",""));
		list.add(new BasicNameValuePair("address1",""));
		list.add(new BasicNameValuePair("address2",""));
		list.add(new BasicNameValuePair("register.x","65"));
		list.add(new BasicNameValuePair("register.y","8"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
//		4.将实体对对象赋值给请求对象的实体属性
		request.setEntity(entity);//使用set实体
//		5.新建一个响应对象,接收客户端发送请求的响应
		CloseableHttpResponse response = client.execute(request);
		try{
//			6.从响应里面提取时间结果
			HttpEntity responseEntity = response.getEntity();//响应实体
			String result = EntityUtils.toString(responseEntity);//将EntityUtils类型转换为String类型
			System.out.println(result);
//			7.将实际结果与用例中的预期结果进行比较
		}finally{
			response.close();
		}

	}finally{
		client.close();
	}

	
}

}