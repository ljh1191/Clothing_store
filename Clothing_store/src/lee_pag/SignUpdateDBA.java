package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SignUpdateDBA {
	String url, user, pwd;

	// DB셋팅

	public SignUpdateDBA() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 보기

	public ArrayList<Store> StignView(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<Store> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from store where id = '" + id + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();

			while (rs.next()) {
				Store s = new Store();
				s.setNum(rs.getInt("num"));
				s.setName(rs.getString("name"));
				s.setOwner(rs.getString("owner"));
				s.setStorenum(rs.getString("storenum"));
				s.setAddr(rs.getString("addr"));
				s.setTell(rs.getString("tell"));
//				s.setId(rs.getString("id"));
//				s.setPassword(rs.getString("password"));
				arr.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	// 수정

	public void SignUpdate(Store s, String id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update store set name = ?, owner = ?, storenum = ?, addr = ?, tell = ? where id = '" + id
					+ "'";
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getOwner());
			ps.setString(3, s.getStorenum());
			ps.setString(4, s.getAddr());
			ps.setString(5, s.getTell());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 삭제
	public void SignDelete(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from store where id ='" + id + "'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
