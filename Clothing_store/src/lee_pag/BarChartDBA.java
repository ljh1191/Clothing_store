package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BarChartDBA {
	String url, user, pwd;

	// DB¼ÂÆÃ

	public BarChartDBA() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Sales> BarChartDBA() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Sales> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select kind, sum(wearing_ea) wearing_ea, sum(sales_ea)sales_ea, sum(stock_ea) stock_ea "
					+ "from sales " + "group by kind " + "order by kind";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Sales sl = new Sales();
				sl.setKind(rs.getString("kind"));
				sl.setWearing_ea(rs.getInt("wearing_ea"));
				sl.setSales_ea(rs.getInt("sales_ea"));
				sl.setStock_ea(rs.getInt("stock_ea"));
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
