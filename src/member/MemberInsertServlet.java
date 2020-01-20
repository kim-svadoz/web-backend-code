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
@WebServlet(description = "memInsert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//1. 요청정보 추출
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String deptno = request.getParameter("deptno");
		String grade = (request.getParameter("grade"));
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDTO mem = new MemberDTO(id, pass, name, addr, deptno, grade, point);
		//System.out.println("부서번호:"+deptNo+", 부서명:"+deptName+", 부서위치:"+loc+", 전화번호:"+tel+", 관리자:"+mgr);
		//2. 비즈니스 메소드
		MemberDAOImpl memImpl = new MemberDAOImpl();
		int result = memImpl.insert(mem);
		
		//3. 데이터 공유
		request.setAttribute("insertResult", result);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member/insertResult.jsp");
		rd.forward(request, response);
	}
}
