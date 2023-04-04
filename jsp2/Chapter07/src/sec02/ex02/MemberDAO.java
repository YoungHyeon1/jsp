package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
//	private static final String driver = "org.postgresql.Driver";
//
//	private static final String url = "jdbc:postgresql://crawler-database-develop.c8sxn7u8vc1p.ap-northeast-1.rds.amazonaws.com:5432/silla";
//
//	private static final String user = "scott";
//
//	private static final String pwd = "tiger";

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
	public List<MemberVO> listMembers()
	{
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookupLink("java:comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/postgres");

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
//			connDB();
			con=dataFactory.getConnection();
			String query = "select * from t_member;";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String id =rs.getString("id");
				String pwd =rs.getString("pwd");
				String name =rs.getString("name");
				String email =rs.getString("email");
				Date joinDate =rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setjoinDate(joinDate);
				list.add(vo);

			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	

	// 추가
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";			
			System.out.println("prepareStatememt: " + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//	private void connDB()
//	{
//		try {
//			Class.forName(driver);
//			
//			System.out.println("Driver load");
//			
//			con = DriverManager.getConnection(url,user,pwd);
//			
//			System.out.println("acccess");
//			
//			stmt = con.createStatement();
//			System.out.println("create success");
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	

}
