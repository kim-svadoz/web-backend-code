package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAOImpl;

@WebServlet(description = "memDel", urlPatterns = { "/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//1. 요청정보 추출
		String id = request.getParameter("id");
		
		//2. 비지니스메소드 호출
		MemberDAOImpl daoImpl = new MemberDAOImpl();
		int result ;
		result = daoImpl.delete(id);
		
		System.out.println(result);
		
		//3. 요청 재지정
		response.sendRedirect("/serverweb/member/list.do");
		
		if(result==1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
	}

}
