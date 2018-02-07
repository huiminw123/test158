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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;







public class WebTourTest {

	public static void main(String[] args) throws Exception{
		//向服务器发送请求获取session
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet request=new HttpGet();
		URI uri=new URIBuilder()
				.setScheme("http")
				.setHost("172.31.6.178")
				.setPort(1080)
				.setPath("/cgi-bin/nav.pl")
				.setParameter("in", "home")
				.build();
				
		request.setURI(uri);
		CloseableHttpResponse response=client.execute(request);
		
		HttpEntity responseEntity=response.getEntity();
		String result=EntityUtils.toString(responseEntity);
		System.out.println(result);

	//从响应中使用jsoup提取session值
	Document doc=Jsoup.parse(result);
	Elements elements=doc.getElementsByAttributeValue("name", "userSession");
	String session=elements.attr("value");
	System.out.println(session);


	
	HttpPost request1 =new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");
	List<NameValuePair> list = new ArrayList<NameValuePair>();
	list.add(new BasicNameValuePair("userSession",session));
	list.add(new BasicNameValuePair("username","qwer123"));
	list.add(new BasicNameValuePair("password","123456"));
	list.add(new BasicNameValuePair("login.x","58"));
	list.add(new BasicNameValuePair("login.y","12"));
	list.add(new BasicNameValuePair("JSFormSubmit","off"));
	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
	request1.setEntity(entity);
	CloseableHttpResponse response1 = client.execute(request1);
	HttpEntity responseEntity1= response1.getEntity();//响应实体
	String result1 = EntityUtils.toString(responseEntity1);//将EntityUtils类型转换为String类型
	System.out.println(result1);
	//
				
	}
	}
