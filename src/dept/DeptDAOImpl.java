package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

public class DeptDAOImpl implements DeptDAO{
	//�μ� ���
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
	
		//��ü ��� ���
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
		//�μ� ����
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
}
