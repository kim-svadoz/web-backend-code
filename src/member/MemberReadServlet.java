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
		System.out.println("서블릿요청");
		//1.요청정보추출 - 클라이언트가 직접 폼태그에 입력한 데이터 필요에 의해서 넘긴 파라미터 추출
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("id");
		//System.out.println(memberNo);
		
		//2.비지니스메소드 호출 - DeptDAO클레스에 메소드 추가 하고 호출하기 
		MemberDAOImpl daoImpl = new MemberDAOImpl();
		MemberDTO readlist = daoImpl.read(id);
		
		//System.out.println(readlist.getId());
		
		//3. jsp로 넘겨 줄 데이터 공유하기
		request.setAttribute("readList", readlist);
		
		//4. 요청재지정(forward) - 응답합 jsp요청하기
		RequestDispatcher rd = request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);
	}
}
