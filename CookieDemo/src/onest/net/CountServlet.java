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
		//�ж��Ƿ��ǵ�һ�η���
		Cookie[] cookies=request.getCookies();
		if(null == cookies) {
			out.print("first visite");
			//����ǵ�һ�η��ʣ�����cookie(1.�û���2.����)
			Cookie cookie =new Cookie("date",new Date().toString());
			cookie.setMaxAge(24*60*60);//��Ч��һ��
			//��cookie������ӵ�response����
			response.addCookie(cookie);
			//(��ȡcookie�������飬�������Ϊnull�����ʾ��һ�η���)
			Cookie count = new Cookie("count","1");
			cookie.setMaxAge(24*60*60);//��Ч��һ��
			//��cookie������ӵ�response����
			response.addCookie(count);
		}else {
			//������ǵ�һ�η��ʣ�����+1(��ȡ����cookie value+1��cookie������ӵ�)
			for(int i = 1;i<cookies.length;i++) {
				if(cookies[i].getName().equals("date")) {
					out.print("��һ�η���"+cookies[i].getValue());
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
		//���������ӡ����
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
