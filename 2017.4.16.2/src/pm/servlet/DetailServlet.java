package pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pm.dao.ProductDao;
import pm.entity.Product;
/**
 * 显示商品的详细
 * @author JiZhongkai
 *
 */
public class DetailServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset= utf-8");
		//1.获取编号
		String id = request.getParameter("id");
		//2.到数据库中查询商品
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);
		
		//3.显示到浏览器上
		PrintWriter writer = response.getWriter();
		String html = "";
		html +="<html>";
		html +="<head>";
		html +="<title>显示商品详细</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='1' align='center' width='600px'>";
		html +="<tr><th>编号：</th><td>"+product.getId()+"</td></tr>";
		html +="<tr><th>商品名称：</th><td>"+product.getProName()+"</td></tr>";
		html +="<tr><th>商品类型：</th><td>"+product.getProType()+"</td></tr>";
		html +="<tr><th>商品价格：</th><td>"+product.getPrice()+"</td></tr>";
		html +="</table>";
		html +="<center><a href = '"+request.getContextPath()+"/ListServlet'>返回列表</a></center>";
		html +="</body>";
		html +="</html>";
		writer.write(html);
	
		/**
		 * 创建一个cookie 并发送
		 */
		Cookie cookie = new Cookie("proHist",createValue(request,id));
		cookie.setMaxAge(1*30*24*60*60);
		response.addCookie(cookie);
	}
	
	/**
	 * 生成cookie值
	 * @return
	 */
	private String createValue(HttpServletRequest request,String id) {
		Cookie[] cookies = request.getCookies();
		String proHist = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("proHist")){
					proHist = cookie.getValue();
				}
			}
		}
		if(cookies==null || proHist == null){
			return id;
		}
		//string - string[] - collection - LinkedList
		String[] ids = proHist.split(",");
		Collection colls = Arrays.asList(ids);
		//LinkedList方便集合的增删改
		LinkedList list = new LinkedList(colls);
		
		if(list.size()<3){
			//id重复
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.addFirst(id);
			}
		}else{
			//id重复
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else{
				list.removeLast();
				list.addFirst(id);
			}
		}
		//LinkedList - StringBuffer - String
		StringBuffer buffer = new StringBuffer();
		for (Object object : list) {
			buffer.append(object+",");
		}
		String result = buffer.toString();
		result.substring(0, result.length()-1);
		return result;
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
