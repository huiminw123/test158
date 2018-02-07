package com.iftest.day6;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MultiparTest {
	public static void main(String[] args) throws Exception{
		doPost();
	}
	public static void doPost() throws Exception {
		// 1.�½�һ���ͻ��˶���
		CloseableHttpClient client = HttpClients.createDefault();
		try{
			// 2.�½�һ��POST�������Ͷ���ʹ�ýӿڵ�ַ���г�ʼ��
			HttpPost request = new HttpPost("http://192.168.146.133:8080/sample/UploadHandleServlet");
			// 3.�½�StringBody����ʹ��Ҫ���͵��ı����ݽ��г�ʼ��
			// �ж��ٸ��ı���������ͽ����ٸ�StringBody����
			StringBody sb = new StringBody("ede",ContentType.TEXT_PLAIN);
			// 4.�½�FileBody����ʹ��Ҫ���͵��ļ����ļ�������г�ʼ��
			// �ж����ļ������ͽ����ٸ�FileBody����
			FileBody fb1 = new FileBody(new File("D:\\1.txt"));//��һ��\��ת��,�ڶ���\���ļ���һ����
			FileBody fb2 = new FileBody(new File("D:\\2.txt"));
			
			// 5.�½�һ��HttpEntityʵ�壬��StringBody��FileBody�������ӵ�ʵ����
			HttpEntity entity = MultipartEntityBuilder.create()
					.addPart("Username", sb)
					.addPart("file1", fb1)
					.addPart("file2", fb2)
					.build();
			// 6.��ʵ�����ֵ����������ʵ������
			request.setEntity(entity);
			// 7.�½�һ����Ӧ���󣬽��տͻ��˷����������Ӧ
			CloseableHttpResponse response = client.execute(request);
			try{
				// 8.����Ӧ����ȡʵ�ʽ��
				HttpEntity responseEntity = response.getEntity();
				String result = EntityUtils.toString(responseEntity);
				System.out.println(result);
				// 9.��ʵ�ʽ���������е�Ԥ�ڽ�����жԱ�
			}finally{
				response.close();
			}
			
		}finally{
			client.close();
		}

	}
}