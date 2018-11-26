package lee_pag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDBA {
	String url, user, pwd;

	// DB셋팅

	public CustomerDBA() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "lee";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 중복검사
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
				if (rs.getString("id").equals(str)) {// 아이디가 있으면
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

	// 추가
	public void CustomerInsert(Customer_s c) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into customer values(customer_seq.nextval,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getBirth());
			ps.setString(3, c.getGender());
			ps.setString(4, c.getAddr());
			ps.setString(5, c.getPhone());
			ps.setString(6, c.getId());
			ps.setString(7, String.valueOf(c.getPwd()));
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

	// 수정
	public void CustomerUpdate(Customer_s ct, String id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update customer set name = ?, birth = ?, gender = ?, addr = ?, phone = ? where id = '" + id
					+ "'";
			ps = con.prepareStatement(sql);
			ps.setString(1, ct.getName());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 보기
	public ArrayList<Customer_s> CustomerView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Customer_s> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from customer";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Customer_s ct = new Customer_s();
				ct.setCustid(rs.getInt("custid"));
				ct.setId(rs.getString("id"));
				ct.setName(rs.getString("name"));
				ct.setBirth(rs.getString("birth"));
				ct.setGender(rs.getString("gender"));
				ct.setAddr(rs.getString("addr"));
				ct.setPhone(rs.getString("phone"));
				arr.add(ct);
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

	// 삭제
	public void CustomerDelete(String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from customer where id ='" + id + "'";
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

	// 검색
	public ArrayList<Customer_s> CustomerSearch(String key, String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Customer_s> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from customer where " + key + " like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer_s ct = new Customer_s();
				ct.setCustid(rs.getInt("custid"));
				ct.setId(rs.getString("id"));
				ct.setName(rs.getString("name"));
				ct.setBirth(rs.getString("birth"));
				ct.setGender("gender");
				ct.setAddr("addr");
				ct.setPhone("phone");
				arr.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	// 고객 성별분석
	public ArrayList<Customer_s> CustomerGenderAnalysis() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Customer_s> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT GENDER, COUNT(GENDER)count , ROUND(RATIO_TO_REPORT(COUNT(GENDER)) OVER(), 2) ratio "
					+ "FROM CUSTOMER " + "GROUP BY GENDER";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Customer_s ct = new Customer_s();
				ct.setGender(rs.getString("gender"));
				ct.setCount(rs.getInt("count"));
				ct.setRatio(rs.getDouble("ratio"));
				arr.add(ct);
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

	// 고객 연령대별 분석
	public ArrayList<Customer_s> CustomerAgeAnalysis() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Customer_s> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT AGE,COUNT(AGE) COUNT, ROUND(RATIO_TO_REPORT(COUNT(AGE)) OVER(),2)RATIO "
					+ "FROM (SELECT SUBSTR((TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTH,'YYYY'))+1,1,1) AGE "
					+ "FROM CUSTOMER) " + "GROUP BY AGE";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Customer_s ct = new Customer_s();
				ct.setAge(rs.getInt("age"));
				ct.setCount(rs.getInt("count"));
				ct.setRatio(rs.getDouble("ratio"));
				arr.add(ct);
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

	// 고객 거주지별 분석
	public ArrayList<Customer_s> CustomerAddrAnalysis() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Customer_s> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT addr,count(addr)count,ROUND(RATIO_TO_REPORT(COUNT(ADDR)) OVER(),2) RATIO "
					+ "FROM CUSTOMER " + "GROUP BY ADDR";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				Customer_s ct = new Customer_s();
				ct.setAddr(rs.getString("addr"));
				ct.setCount(rs.getInt("count"));
				ct.setRatio(rs.getDouble("ratio"));
				arr.add(ct);
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
