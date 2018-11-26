package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDBA {
	String url, user, pwd;

	// DB셋팅
	public SignUpDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 드라이버연결
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";// 유저아이디
			pwd = "TIGER";// 유저비번
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public void SignUp(Store s) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into store values(store_seq.nextval,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getOwner());
			ps.setString(3, s.getStorenum());
			ps.setString(4, s.getAddr());
			ps.setString(5, s.getTell());
			ps.setString(6, s.getId());
			ps.setString(7, String.valueOf(s.getPwd()));
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean check(String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			String sql = "select * from customer where id = '" + str + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("id").equals(str)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
