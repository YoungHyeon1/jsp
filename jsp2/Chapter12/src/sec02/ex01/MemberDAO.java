package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/postgres");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers(MemberVO memberVO) {
		List<MemberVO> membersList = new ArrayList();
		String _name = memberVO.getName();
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from t_member";
			
			if((_name!=null && _name.length()!=0)){
				 query+=" where name=?";
				 pstmt = con.prepareStatement(query);
				 pstmt.setString(1, _name);
			}else {
				pstmt = con.prepareStatement(query);	
			}
			
			//쿼리문을 작성하는 구간입니다.
			System.out.println("prepareStatememt : " + query);
			ResultSet rs = pstmt.executeQuery();
			// Result되는 값을 메모리상에서 next()를 사용하여 한줄씩. 그리고 next가 null이 될 경우 while구문이 끝나도록 작성되었습니다.
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				membersList.add(vo);
			}
			// Query의 결과 값을 읽은 후 Read된 메모리의 사용을 종료하는 부분입니다.
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

}