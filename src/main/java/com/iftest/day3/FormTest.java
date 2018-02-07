package com.iftest.day3;

import java.net.URI;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FormTest {
	public static void main(String[] args) throws Exception {
		//调用main方法
		doGet();
		doGet1();
	}
	public static void doGet() throws Exception{
//		1.新建一个客户端对象
		CloseableHttpClient client=HttpClients.createDefault();
		try {
//		    2.新建一个使用GET请求方法的请求对象
			HttpGet request = new HttpGet();
//			3.给请求对象的请求地址属性赋值
			URI uri = new URIBuilder()  				//构造一个请求地址
					.setScheme("http")  				//确定协议
					.setHost("192.168.146.133")    		//确定地址
					.setPort(8080)   				    //确定端口号
					.setPath("/test158/FormServlet")    //确定资源地址
					.setParameter("a", "1")   			//参数
					.setParameter("b", "2")
					.build();
			
			request.setURI(uri);
//			4.新建一个响应对象,接收客户端发送请求对象的响应
			CloseableHttpResponse response=client.execute(request);
			try{
//				5.从响应中提取实际结果
				HttpEntity responseEntity=response.getEntity();
				String sum =EntityUtils.toString(responseEntity);
				System.out.println(sum);
//				6.用实际结果与用例中的预期结果进行比较
			}finally{
				response.close();
			}
	
		}finally{
			client.close();
			
		}
		
	}
	public static void doGet1() throws Exception{
		CloseableHttpClient client=HttpClients.createDefault();
		try{
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("dev-hanzi.lqdzj.cn")
					.setPath("/ajax_stroke_search")
					.setParameter("q", "⿱亠")
					.setParameter("mode", "1")
					.build();
			
			HttpGet request =new HttpGet(uri);
			CloseableHttpResponse response=client.execute(request);
			
				HttpEntity responseEntity=response.getEntity();
				String result =EntityUtils.toString(responseEntity);
				System.out.println(result);
//					
//				JSONObject object = JSONObject.parseObject(result);//把String类型转换为JSONObject
//				JSONArray array = object.getJSONArray("result");
//				for (Object o : array) {
//					System.out.println(o);//打印所有的东西
//					JSONObject obj =JSONObject.parseObject(o.toString());//类型转换
//					String hanzi = obj.getString("hanzi_char");
//					System.out.println(hanzi);
//					}
							
		}finally{
			client.close();
		}

	}
	
}
