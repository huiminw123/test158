package com.iftest.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从请求中提取发送的实体数据
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));//Buffer:缓冲区
		String str = br.readLine();//将readLine类型转化为String类型
		// 从请求数据中提取参数值
		JSONObject obj = JSONObject.parseObject(str);
		int a = obj.getIntValue("a");
		int b = obj.getIntValue("b");

		// 运算
		int sum = a + b;

		// 构造响应
		JSONObject object = new JSONObject();
		object.put("a", a);
		object.put("b", b);
		object.put("sum", sum);

		response.getWriter().append(object.toString());//append:追加
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
