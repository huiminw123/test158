package com.iftest.day5;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class XMLServlet
 */
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从请求对象中获取客户端发送过来的输入流
		InputStream is =request.getInputStream();
	
		//将获取的输入流转换为Document对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {
			db = dbf.newDocumentBuilder();
		    doc = db.parse(is);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取xmlDOM对象的根节点
		Element root = doc.getDocumentElement();
		//根据参数名称获取参数节点
		NodeList nla = root.getElementsByTagName("a");
		NodeList nlb = root.getElementsByTagName("b");
		
		//从节点列表中获取节点值
		String a = nla.item(0).getTextContent();
		String b = nlb.item(0).getTextContent();
		
		//转换类型并运算
		int int_a = Integer.parseInt(a);
		int int_b = Integer.parseInt(b);
		
		int sum = int_a+int_b;
		
		//将运算结果添加到响应xml中
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<root>"
				+"<a>" + a + "</a>"
				+"<b>" + b + "</b>"
				+"<sum>" + sum + "</sum>"
				+"</root>";
				response.getWriter().append(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
