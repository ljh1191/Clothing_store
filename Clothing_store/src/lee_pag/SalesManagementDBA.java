package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalesManagementDBA {
	String url, user, pwd;

	// DB¼ÂÆÃ
	public SalesManagementDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Sales> SalesViewDay() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Sales> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select kind, sum(cost*sales_ea)cost, avg(salesprice)salesprice,sum(salesprice*sales_ea) sales "
					+ "from sales " + "where substr(s_day,-2,2) = '20' and substr(s_day,4,2) = '11' " + "group by kind";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Sales sl = new Sales();
				sl.setKind(rs.getString("kind"));
				sl.setCost(rs.getInt("cost"));
				sl.setSalesprice(rs.getInt("salesprice"));
				sl.setSales_m(rs.getInt("sales"));
				arr.add(sl);
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

	public ArrayList<Sales> SalesViewWeek() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Sales> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select kind, sum(cost*sales_ea)cost, avg(salesprice)salesprice,sum(salesprice*sales_ea) sales "
					+ "from sales " + "where to_char(to_date(s_day),'iw') = '47' " + "group by kind";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Sales sl = new Sales();
				sl.setKind(rs.getString("kind"));
				sl.setCost(rs.getInt("cost"));
				sl.setSalesprice(rs.getInt("salesprice"));
				sl.setSales_m(rs.getInt("sales"));
				arr.add(sl);
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

	public ArrayList<Sales> SalesViewMonth() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Sales> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select kind, sum(cost*sales_ea)cost, avg(salesprice)salesprice,sum(salesprice*sales_ea) sales "
					+ "from sales " + "where substr(s_day,4,2) = '11' " + "group by kind";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Sales sl = new Sales();
				sl.setKind(rs.getString("kind"));
				sl.setCost(rs.getInt("cost"));
				sl.setSalesprice(rs.getInt("salesprice"));
				sl.setSales_m(rs.getInt("sales"));
				arr.add(sl);
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

	public ArrayList<Sales> SalesViewMonth_g() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Sales> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select substr(s_day,4,2) month, sum(sales_ea) sales_ea " + "from sales "
					+ "group by substr(s_day,4,2) order by month";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Sales sl = new Sales();
				sl.setMonth(rs.getString("month"));
				sl.setSales_ea(rs.getInt("sales_ea"));
				arr.add(sl);
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
}
