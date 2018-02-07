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
//		1.�½�һ���ͻ��˶���
		CloseableHttpClient client = HttpClients.createDefault();
		try{
//			2.�½�һ��ʹ��POST���󷽷����������,ʹ�ýӿڵ������ַ���г�ʼ��
			HttpPost request = new HttpPost("http://192.168.146.133:8080/test158/FormServlet");
			
//			3.�½�һ��UrlEncodedFormEntityʵ�����,ʹ�ò����Ͳ���ֵ�б���г�ʼ��
			List<NameValuePair> list = new ArrayList<NameValuePair>();//ArrayList:��̬����
			// ArrayList��ʵ��List�ӿڵĶ�̬����,��ν��̬�������Ĵ�С�ǿɱ��
			list.add(new BasicNameValuePair("a","1"));
			list.add(new BasicNameValuePair("b","2"));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
			
			//			4.��ʵ��Զ���ֵ����������ʵ������
			request.setEntity(entity);//ʹ��setʵ��
//			5.�½�һ����Ӧ����,���տͻ��˷����������Ӧ
			CloseableHttpResponse response = client.execute(request);
			try{
//				6.����Ӧ������ȡʱ����
				HttpEntity responseEntity= response.getEntity();//��Ӧʵ��
				String result = EntityUtils.toString(responseEntity);//��EntityUtils����ת��ΪString����
				System.out.println(result);
//				7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�
			}finally{
				response.close();
			}

		}finally{
			client.close();
		}

	}
	public static void doGet() throws Exception{
//		1.�½�һ���ͻ��˶���
		CloseableHttpClient client=HttpClients.createDefault();
		try {
//		    2.�½�һ��ʹ��GET���󷽷����������
			HttpGet request = new HttpGet();
//			3.���������������ַ���Ը�ֵ
			URI uri = new URIBuilder()  				//����һ�������ַ
					.setScheme("https")  				//ȷ��Э��
					.setHost("api.weixin.qq.com")    	//ȷ����ַ
					.setPath("/cgi-bin/token")          //ȷ����Դ��ַ
					.setParameter("grant_type", "client_credential")   			//����
					.setParameter("appid", "wxd1d3bd9078dc815a")				//����
					.setParameter("secret", "cfa868082885e6df5f90bb57ec4bf9d4") //����
					.build();
			
			request.setURI(uri);
//			4.�½�һ����Ӧ����,���տͻ��˷�������������Ӧ
			CloseableHttpResponse response=client.execute(request);
			try{
//				5.����Ӧ����ȡʵ�ʽ��
				//����
				HttpEntity responseEntity=response.getEntity();
				String sum =EntityUtils.toString(responseEntity);
				System.out.println(sum);
				JSONObject object = JSONObject.parseObject(sum);
				String sd = object.getString("access_token");
//				6.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�
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
//		2.�½�һ��ʹ��POST���󷽷����������,ʹ�ýӿڵ������ַ���г�ʼ��
		HttpPost request = new HttpPost("http://172.31.6.178:1080/cgi-bin/login.pl");
		
//		3.�½�һ��UrlEncodedFormEntityʵ�����,ʹ�ò����Ͳ���ֵ�����г�ʼ��
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
//		4.��ʵ��Զ���ֵ����������ʵ������
		request.setEntity(entity);//ʹ��setʵ��
//		5.�½�һ����Ӧ����,���տͻ��˷����������Ӧ
		CloseableHttpResponse response = client.execute(request);
		try{
//			6.����Ӧ������ȡʱ����
			HttpEntity responseEntity = response.getEntity();//��Ӧʵ��
			String result = EntityUtils.toString(responseEntity);//��EntityUtils����ת��ΪString����
			System.out.println(result);
//			7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȽ�
		}finally{
			response.close();
		}

	}finally{
		client.close();
	}

	
}

}