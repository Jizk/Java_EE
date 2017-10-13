package pm.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例  用户访问时间
 * @author JiZhongkai
 *
 */
public class HistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		
		//获取系统时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime = dateFormat.format(new Date());
		
		//取得cookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")){
					/**
					 * 第n次访问
					 */
					lastTime = cookie.getValue();
					response.getWriter().write("欢迎回来，上次访问时间为"+lastTime+"当前时间为："+curTime);
					//更新时间
					cookie.setValue(curTime);
					//保存一个月
					cookie.setMaxAge(1*30*24*60*60);
					//发送时间
					response.addCookie(cookie);
					break;
				}
			}
		}
		/**
		 * 第一次访问，没有cookie或者没有名为lastTime的cookie
		 */
		if(cookies==null || lastTime == null){
			response.getWriter().write("你是首次访问，当前时间为："+curTime);
			//创建一个cookie
			Cookie cookie = new Cookie("lastime",curTime);
			//保存一个月
			cookie.setMaxAge(1*30*24*60*60);
			//发送时间
			response.addCookie(cookie);
		}
		
	}

}
