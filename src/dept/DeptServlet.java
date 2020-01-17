package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("����");
		//1. ��û���� ����
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		System.out.println("�μ���ȣ:"+deptNo+", �μ���:"+deptName+", �μ���ġ:"+loc+", ��ȭ��ȣ:"+tel+", ������:"+mgr);
		//2. ����Ͻ� �޼ҵ�
		DeptDAOImpl daoImpl = new DeptDAOImpl();
		int result = daoImpl.insert(dept);
		
		//3. ������ ����
		request.setAttribute("insertResult", result);
		
		//4. ����ȭ������ ��û ������
		RequestDispatcher rd = request.getRequestDispatcher("/dept/insertResult.jsp");
		rd.forward(request, response);
		
		
		
		//response.sendRedirect("/serverweb/dept/insertResult.html");
		/*
		//3. ����ȭ�� ����
		if(result==1) {
			System.out.println("INSERT success!");
		}else {
			System.out.println("INSERT fail...");
		}*/
		
	}

	
	
}
