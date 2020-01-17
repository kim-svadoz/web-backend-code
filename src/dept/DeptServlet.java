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
		System.out.println("서블릿");
		//1. 요청정보 추출
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		System.out.println("부서번호:"+deptNo+", 부서명:"+deptName+", 부서위치:"+loc+", 전화번호:"+tel+", 관리자:"+mgr);
		//2. 비즈니스 메소드
		DeptDAOImpl daoImpl = new DeptDAOImpl();
		int result = daoImpl.insert(dept);
		
		//3. 데이터 공유
		request.setAttribute("insertResult", result);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd = request.getRequestDispatcher("/dept/insertResult.jsp");
		rd.forward(request, response);
		
		
		
		//response.sendRedirect("/serverweb/dept/insertResult.html");
		/*
		//3. 응답화면 생성
		if(result==1) {
			System.out.println("INSERT success!");
		}else {
			System.out.println("INSERT fail...");
		}*/
		
	}

	
	
}
