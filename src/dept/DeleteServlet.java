package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "delete", urlPatterns = { "/dept/delete.do" })
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		//1. ��û���� ����
		String deptNo = request.getParameter("deptno");
		
		//2. �����Ͻ��޼ҵ� ȣ��
		DeptDAOImpl daoImpl = new DeptDAOImpl();
		int result ;
		result = daoImpl.delete(deptNo);
		
		//3. ��û ������
		response.sendRedirect("/serverweb/dept/list.do");
		
		if(result==1) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
	}

}
