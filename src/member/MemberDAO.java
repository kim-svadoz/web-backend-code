package member;

import java.util.ArrayList;

public interface MemberDAO {
	public int insert(MemberDTO mem);
	public ArrayList<MemberDTO> getMemList();
	public int delete(String id);
	public MemberDTO read(String id);
}
