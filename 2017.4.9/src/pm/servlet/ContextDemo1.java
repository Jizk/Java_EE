package pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 得到web应用路径
 * @author JiZhongkai
 *
 */
public class ContextDemo1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.得到context对象
		ServletContext servletContext = this.getServletContext();
		/*//2.得到web应用路径
		String contextPath = context.getContextPath();
		*//**
		 * 重定向
		 *//*
		response.sendRedirect(contextPath+"");*/
	}

}
