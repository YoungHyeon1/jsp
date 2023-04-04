package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "org.postgresql.Driver";

	private static final String url = "jdbc:postgresql://crawler-database-develop.c8sxn7u8vc1p.ap-northeast-1.rds.amazonaws.com:5432/silla";

	private static final String user = "scott";

	private static final String pwd = "tiger";

	private Connection con;

	private Statement stmt;
	
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_member";
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

	private void connDB()
	{
		try {
			Class.forName(driver);
			
			System.out.println("Driver load");
			
			con = DriverManager.getConnection(url,user,pwd);
			
			System.out.println("acccess");
			
			stmt = con.createStatement();
			System.out.println("create success");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
