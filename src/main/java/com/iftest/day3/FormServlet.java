package com.iftest.day3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从请求中获取参数值
		String str_a=request.getParameter("a");
		String str_b=request.getParameter("b");
		
		//将String类型的参数值转换为int类型
		int int_a=Integer.parseInt(str_a);
		int int_b=Integer.parseInt(str_b);
		
		//求和
		int sum=int_a+int_b;
		
		//将运算结果转换为String类型
		String result =String.valueOf(sum);
		
		//将运算结果添加到响应中
		response.getWriter().append(result );
	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
