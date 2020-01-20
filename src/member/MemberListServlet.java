package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAOImpl;
import dept.DeptDTO;

@WebServlet(description = "memlist", urlPatterns = { "/member/list.do" })
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		MemberDAOImpl daoImpl = new MemberDAOImpl();
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		memlist = daoImpl.getMemList();
		
		// 데이터 공유
		request.setAttribute("memList", memlist);
		
		// 응답화면으로 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
	}

}
