package pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pm.dao.ProductDao;
import pm.entity.Product;

public class ListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset= utf-8");
		//1. 读取数据库
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAll();
		//2.把商品显示到浏览器上
		PrintWriter writer = response.getWriter();
		String html = "";
		
		html +="<html>";
		html +="<head>";
		html +="<title>显示商品列表</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='1' align='center' width='600px'>";
		html +="<tr>";
		html += "<th>编号</th><th>商品名称</th><th>商品型号</th><th>商品价格</th>";
		html +="</tr>";
		//遍历商品
		if(list!=null){
			for(Product p:list){
				html +="<tr>";
				html += "<td>"+p.getId()+"</td><td><a href='"+request.getContextPath()+"/DetailServlet?id="+p.getId()+"'>"+p.getProName()+"</a></td><td>"+p.getProType()+"</td><td>"+p.getPrice()+"</td>";
				html +="</tr>";
			}
		}
		html +="</table>";
		/**
		 * 显示浏览过的商品
		 */
		html +="最近浏览过的商品：<br/>";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("proHist")){
					String proHist = cookie.getValue();
					String[] ids = proHist.split(",");
					for (String id : ids) {
						//查数据库
						Product product = dao.findById(id);
						//显示到浏览器
						html +=""+product.getId()+"&nbsp;"+""+product.getProName()+"&nbsp;"+product.getPrice()+"<br/>";
					}
				}
			}
		}
		html +="</body>";
		html +="</html>";
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
