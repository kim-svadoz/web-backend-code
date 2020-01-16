package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		//1. 요청정보 추출
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String method = request.getParameter("method");
		//2. 비지니스 메소드 호출
		CalcLogic logic = new CalcLogic();
		int result= logic.calc(num1, method, num2);
		
		//3. 응답화면 생성
		pw.print("<h1>계산결과("+method+")</h1>");
		pw.print("------------------<br/>");
		pw.print("num1의 "+num1+"과 num2의 "+num2+"을 연산한 결과는 "+result+"입니다.");
	}
}

