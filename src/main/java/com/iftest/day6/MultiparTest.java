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
		// 1.新建一个客户端对象
		CloseableHttpClient client = HttpClients.createDefault();
		try{
			// 2.新建一个POST请求类型对象，使用接口地址进行初始化
			HttpPost request = new HttpPost("http://192.168.146.133:8080/sample/UploadHandleServlet");
			// 3.新建StringBody对象，使用要发送的文本内容进行初始化
			// 有多少个文本输入参数就建多少个StringBody对象
			StringBody sb = new StringBody("ede",ContentType.TEXT_PLAIN);
			// 4.新建FileBody对象，使用要发送的文件的文件对象进行初始化
			// 有多少文件参数就建多少个FileBody对象
			FileBody fb1 = new FileBody(new File("D:\\1.txt"));//第一个\是转译,第二个\是文件的一部分
			FileBody fb2 = new FileBody(new File("D:\\2.txt"));
			
			// 5.新建一个HttpEntity实体，将StringBody和FileBody对象添加到实体中
			HttpEntity entity = MultipartEntityBuilder.create()
					.addPart("Username", sb)
					.addPart("file1", fb1)
					.addPart("file2", fb2)
					.build();
			// 6.将实体对象赋值给请求对象的实体属性
			request.setEntity(entity);
			// 7.新建一个响应对象，接收客户端发送请求的响应
			CloseableHttpResponse response = client.execute(request);
			try{
				// 8.从响应中提取实际结果
				HttpEntity responseEntity = response.getEntity();
				String result = EntityUtils.toString(responseEntity);
				System.out.println(result);
				// 9.将实际结果与用例中的预期结果进行对比
			}finally{
				response.close();
			}
			
		}finally{
			client.close();
		}

	}
}
