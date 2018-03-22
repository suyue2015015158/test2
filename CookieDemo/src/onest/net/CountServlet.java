package onest.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void yue(){
        system.out.println("11111222223333");
}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		//判断是否是第一次访问
		Cookie[] cookies=request.getCookies();
		if(null == cookies) {
			out.print("first visite");
			//如果是第一次访问，创建cookie(1.用户，2.次数)
			Cookie cookie =new Cookie("date",new Date().toString());
			cookie.setMaxAge(24*60*60);//有效期一天
			//把cookie对象添加到response当中
			response.addCookie(cookie);
			//(获取cookie对象数组，如果数组为null，则表示第一次访问)
			Cookie count = new Cookie("count","1");
			cookie.setMaxAge(24*60*60);//有效期一天
			//把cookie对象添加到response当中
			response.addCookie(count);
		}else {
			//如果不是第一次访问，次数+1(获取次数cookie value+1，cookie重新添加到)
			for(int i = 1;i<cookies.length;i++) {
				if(cookies[i].getName().equals("date")) {
					out.print("第一次访问"+cookies[i].getValue());
				}else {
					String strNum = cookies[i].getValue();
					int count = Integer.parseInt(strNum)+1;
				    Cookie 	countNew = new Cookie("count",String.valueOf(count));
				    countNew.setMaxAge(24*60*60);
				    response.addCookie(countNew);
				    out.write("<P>times"+count+"</p>");
				}
			}
		}
		//向浏览器打印数据
	}

	private HttpServletRequest setCharacterEncoding(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
