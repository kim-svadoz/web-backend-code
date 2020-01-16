package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "list", urlPatterns = { "/dept/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		DeptDAOImpl daoImpl = new DeptDAOImpl();
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		deptlist = daoImpl.getDeptList();
		
		pw.write("<table border='1', width='500px'>");
		pw.print("<h1>부서목록보기</h1>");
		pw.print("<hr/>");
		pw.write("<tr>");
		pw.write("<th>부서 번호</th>");
		pw.write("<th>부서 이름</th>");
		pw.write("<th>부서 위치</th>");
		pw.write("<th>전화 번호</th>");
		pw.write("<th>관리자</th>");
		pw.print("<th>삭제</th>");
		pw.write("</tr>");
		int size = deptlist.size();
		for(int i=0;i<size;i++) {
			pw.write("<tr>");
			pw.write("<td>"+deptlist.get(i).getDeptNo()+"</td>");
			pw.write("<td>"+deptlist.get(i).getDeptName()+"</td>");
			pw.write("<td>"+deptlist.get(i).getLoc()+"</td>");
			pw.write("<td>"+deptlist.get(i).getTel()+"</td>");
			pw.write("<td>"+deptlist.get(i).getMgr()+"</td>");
			pw.print("<td><a href='/serverweb/dept/delete.do?deptno="
			+deptlist.get(i).getDeptNo()+"&info=test'>삭제</a></td>");
			pw.write("</tr>");
		}
		pw.write("</table>");
	}
	
	
}
