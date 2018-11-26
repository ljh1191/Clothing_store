package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LoginDBA {
	String url, user, pwd;

	// DB셋팅
	public LoginDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 드라이버연결
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";// 유저아이디
			pwd = "TIGER";// 유저비번
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int LogIn(String id, String pw) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from store where id = '" + id + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (id.equals(rs.getString("id")))
					cnt += 1;
				if (pw.equals(rs.getString("password"))) {
					cnt += 2;
				} else {
				}
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
