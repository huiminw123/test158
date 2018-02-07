package com.iftest.day6;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParamTest extends FeedTest{
	
	@Test(dataProvider="feeder")
	@Source("./data/abd.csv")

	public static  void doGet(String a,String b,String expected) throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		try{
			HttpGet request =  new HttpGet();
			URI  uri = new URIBuilder()
					.setScheme("http")
					.setHost("192.168.146.133")
					.setPort(8080)
					.setPath("/test158/FormServlet")
					.setParameter("a", a)
					.setParameter("b", b)
					.build();
			request.setURI(uri);
			CloseableHttpResponse response = client.execute(request);
			try{
				HttpEntity responseEntity = response.getEntity();
				String actual = EntityUtils.toString(responseEntity);
				System.out.println(actual);
				Assert.assertEquals(actual, expected);
			}finally{
				response.close();
			}
		}finally{
			client.close();
		}
	}

}
