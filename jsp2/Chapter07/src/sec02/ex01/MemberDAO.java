package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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

	private Statement stmt;
	private DataSource dataFactory;
	
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
		    stmt = con.createStatement();
			String query = "select * from t_member;";
			System.out.println(query);
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
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
			stmt.close();
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
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
