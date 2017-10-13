package pm.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LifeDemo extends HttpServlet {
	/**
	 * 1.构造方法 当创建一个servlet对象时调用，默认情况下
	 */
	public LifeDemo() {
		System.out.println("1.servlet对象被创建了");
	}
	/**
	 * 2. init方法   当创建完一个servlet对象时调用
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println();
	}
	/**
	 * 3.service方法  每次发出请求时调用
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println();
	}
	/**
	 * 4.destroy方法 停止服务器或重新部署服务器时调用
	 */
	@Override
	public void destroy() {
		System.out.println();
	}
}
