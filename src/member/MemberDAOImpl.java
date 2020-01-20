package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberDTO;
import fw.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	// �μ� ���
	public int insert(MemberDTO mem) {
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, mem.getId());
			ptmt.setString(2, mem.getPass());
			ptmt.setString(3, mem.getName());
			ptmt.setString(4, mem.getAddr());
			ptmt.setString(5, mem.getDeptno());
			ptmt.setString(6, mem.getGrade());
			ptmt.setInt(7, mem.getPoint());
			
			//System.out.println(mem.getMemberNo() + " " + mem.getPass() +" " + mem.getMemberName() +""+mem.getAddr() +" "+mem.getDeptNo() + " "+ mem.getRate() + " "+mem.getPoint() );
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ü ��� ���
	public ArrayList<MemberDTO> getMemList() {
		String sql = "SELECT * FROM member";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				MemberDTO mem = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				memlist.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memlist;
	}

	// ȸ�� ����
	public int delete(String MemberNo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		String sql = "delete from member where id =?";
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, MemberNo);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	// ȸ�� �� ��ȸ
	public MemberDTO read(String id) {
		System.out.println("mem�� readȣ��");
		String sql = "SELECT * FROM member WHERE id = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		MemberDTO memlist = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery(); // select ����
			
			//System.out.println("????????" + rs.next());
			// �������� �ڹٰ�ü�� ��ȯ
			// - ���ڵ尡 ������ : DTO�� ���ڵ带 ��ȯ�ϰ� ArrayList�� add
			// - ���ڵ尡 �� �� : DTO�� ���ڵ� ��ȯ
			if (rs.next()) { // �ϳ��� üũ�ϴ°� if�� �۾�
				memlist = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				//System.out.println(memlist.getDeptNo()+" "+memlist.getPass()+" "+memlist.getMemberName()+" "+memlist.getPass()+" "+memlist.getAddr());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memlist;
	}

}
