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
		
		System.out.println("���̵� : "+id);
		System.out.println("�̸� : "+name);
		System.out.println("��й�ȣ : "+pass);
		System.out.println("�� : "+gender);
		System.out.println("���� : "+job);
		
		System.out.print("���ɻ� : ");
		for(int i=0; i<item.length; i++) {
			System.out.print(item[i] + " ");
		}
	}
}
