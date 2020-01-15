package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("userId");
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("비밀번호 : "+pass);
		System.out.println("성 : "+gender);
		System.out.println("직업 : "+job);
		
		System.out.print("관심사 : ");
		for(int i=0; i<item.length; i++) {
			System.out.print(item[i] + " ");
		}
	}
}
