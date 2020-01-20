package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAOImpl implements DeptDAO{
	//부서 등록
	public int insert(DeptDTO dept) {
		String sql = "INSERT INTO mydept VALUES(?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dept.getDeptNo());
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			result = ptmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
		//전체 목록 출력
		public ArrayList<DeptDTO> getDeptList(){
			String sql = "SELECT * FROM MYDEPT";
			Connection con = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
			try {
				con = DBUtil.getConnect();
				ptmt = con.prepareStatement(sql);
				rs = ptmt.executeQuery();
				while(rs.next()) {
					DeptDTO dept = new DeptDTO(rs.getString(1), rs.getString(2), 
							rs.getString(3), rs.getString(4), rs.getString(5));
					deptlist.add(dept);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(rs, ptmt, con);
			}
			return deptlist;
		}
		//부서 삭제
		public int delete(String deptNo) {
			Connection con = null;
			PreparedStatement ptmt = null;
			String sql = "delete from mydept where deptNo =?";
			int result = 0;
			try {
				con = DBUtil.getConnect();
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, deptNo);
				result = ptmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(null, ptmt, con);
			}
			return result;
		}
		
		public DeptDTO read(String deptNo) {
			System.out.println("dao의 read호출");
			String sql = "SELECT * FROM MYDEPT WHERE deptNo = ?";
			Connection con = null;
			PreparedStatement ptmt = null;
			ResultSet rs = null;
			DeptDTO readlist = null;
			try {
				con = DBUtil.getConnect();
				ptmt = con.prepareStatement(sql);
				ptmt.setString(1, deptNo);
				rs = ptmt.executeQuery(); //select 실행
				//실행결과를 자바객체로 변환
				// - 레코드가 여러개 : DTO로 레코드를 변환하고 ArrayList에 add
				// - 레코드가 한 개 : DTO로 레코드 변환
				if(rs.next()) { // 하나만 체크하는건 if로 작업
				readlist = new DeptDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(rs, ptmt, con);
			}
			return readlist;
		}
}
