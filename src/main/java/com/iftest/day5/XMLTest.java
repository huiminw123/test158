package com.iftest.day5;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.security.ntlm.Client;

public class XMLTest {
	public static void main(String[] args) throws Exception {
		doPost();
		doGet();
	}

	public static void doPost() throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"    //xml����
					+ "<root>"
				    + "<a>3</a>" 
					+ "<b>4</b>" 
				    + "</root>";    //xml����
		// 1.�½�һ���ͻ��˶���
		CloseableHttpClient client = HttpClients.createDefault();
		try {

			// 2.�½�һ��POST�������,ʹ�ýӿڵ�ַ���г�ʼ��
			HttpPost request = new HttpPost("http://192.168.146.133:8080/test158/XMLServlet");
			// 3.�½�һ��StringEntityʵ�����,ʹ��xml���г�ʼ��
			StringEntity entity = new StringEntity(xml, "utf-8");
			// 4.��ʵ�����ֵ����������ʵ������
			request.setEntity(entity);
			// 5.�½�һ����Ӧ����,���տͻ��˷�����������Ӧ
			CloseableHttpResponse response = client.execute(request);
			try {
				// 6.����Ӧ����ȡʵ�ʽ��
				HttpEntity responseEntity = response.getEntity();
//				 String result = EntityUtils.toString(responseEntity);
//				 System.out.println(result);
				InputStream is = responseEntity.getContent();
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(is);

				Element root = doc.getDocumentElement();
				NodeList nl = root.getElementsByTagName("sum");
				String sum = nl.item(0).getTextContent();
				System.out.println(sum);
				// 7.��ʵ�ʽ���������е�Ԥ�ڽ�����бȶ�
			} finally {
				response.close();
			}

		} finally {
			client.close();
		}
	}

	public static void doGet() throws Exception{
				
		String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">"

				+"<soapenv:Header/>"
				+"<soapenv:Body>"
				+"<web:getTVstationString>"
				+"<web:theAreaID>4</web:theAreaID>"
				+"</web:getTVstationString>"
				+"</soapenv:Body>"
				+"</soapenv:Envelope>";
		CloseableHttpClient client =  HttpClients.createDefault();
		try {
		HttpPost request=new HttpPost("http://www.webxml.com.cn/webservices/ChinaTVprogramWebService.asmx");
		StringEntity entity = new StringEntity(xml,"utf-8");
		request.setEntity(entity);
		request.setHeader("Content-Type","text/xml;charset=UTF-8");
		CloseableHttpResponse response = client.execute(request);
	    try{
	    	HttpEntity responseEntity = response.getEntity();
	    	InputStream is = responseEntity.getContent();
	    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder db = dbf.newDocumentBuilder();
	    	Document doc = db.parse(is);
	    	
	    	Element root = doc.getDocumentElement();
	    	NodeList nl =root.getElementsByTagName("getTVstationStringResult");
			String result = nl.item(0).getTextContent();
			System.out.println(result);
	    }finally{
	    	response.close();
	    }
		
		}finally{
			client.close();
		}

}
}
