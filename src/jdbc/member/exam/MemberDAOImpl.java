package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0 ;
		String sql = "update member set addr = ? where id = ? ";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 업데이트 성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;

	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from member where id = ?";
		int result = 0 ; //결과값을 저장할 변수
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;

	}

	@Override
	public int insert(MemberDTO user) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql 
		= "insert into member values(?,?,?,?,?,sysdate,0)";
		int result =0;//메소드 실행결과가 저장될 변수
		try {
			con = DBUtil.getConnect();//DBMS연결
			//1. PreparedStatement생성
			stmt = con.prepareStatement(sql);
			//2. ?에 값 전달하기
			stmt.setString(1, user.getId());
			stmt.setString(2,user.getPass());
			stmt.setString(3,user.getName());
			stmt.setString(4,user.getAddr());
			stmt.setString(5,user.getDeptno());
			//3. 실행하기
			result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공");
		}catch(SQLException e) {
			e.printStackTrace();//오류추적
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {//=> 레코드를 조회하기 위해서는
				member = new MemberDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),
						rs.getDate(6),rs.getInt(7));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberlist;
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		String sql = "select * from member where addr like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {//=> 레코드를 조회하기 위해서는
				member = new MemberDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),
						rs.getDate(6),rs.getInt(7));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return memberlist;
	}

	@Override
	public MemberDTO login(String id, String pass) {
		MemberDTO member = null;
		String sql = "select * from member where id=? and pass=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if(rs.next()) {//=> 레코드를 조회하기 위해서는
				member = new MemberDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),
						rs.getDate(6),rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, con);
		}
		return member;
	}

}
