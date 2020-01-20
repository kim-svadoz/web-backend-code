package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAOImpl;
import dept.DeptDTO;

@WebServlet(description = "memRead", urlPatterns = { "/member/read.do" })
public class MemberReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("������û");
		//1.��û�������� - Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������ �ʿ信 ���ؼ� �ѱ� �Ķ���� ����
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("id");
		//System.out.println(memberNo);
		
		//2.�����Ͻ��޼ҵ� ȣ�� - DeptDAOŬ������ �޼ҵ� �߰� �ϰ� ȣ���ϱ� 
		MemberDAOImpl daoImpl = new MemberDAOImpl();
		MemberDTO readlist = daoImpl.read(id);
		
		//System.out.println(readlist.getId());
		
		//3. jsp�� �Ѱ� �� ������ �����ϱ�
		request.setAttribute("readList", readlist);
		
		//4. ��û������(forward) - ������ jsp��û�ϱ�
		RequestDispatcher rd = request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);
	}
}
