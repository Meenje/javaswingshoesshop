package shoesshop;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class CustomerDAO {
	public ArrayList<String> checkID() throws Exception {
		ArrayList<String> idlist = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select id from customer";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			idlist.add(rs.getString(1));
		}

		return idlist;

	}
	
	
	public CustomerDTO Iogin(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from customer where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		CustomerDTO dto = new CustomerDTO();
		
		if (rs.next()) {
			dto.setName(rs.getString(1));
			dto.setId(rs.getString(2));
			dto.setPw(rs.getString(3));
			dto.setTel(rs.getString(4));
			dto.setAddress1(rs.getString(5));
			dto.setAddress2(rs.getString(6));
			dto.setPwhint(rs.getString(7));
			dto.setAdmin(rs.getInt(8));
		}
		return dto;
	}

	public void insert(CustomerDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "insert into customer values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getId());
		ps.setString(3, dto.getPw());
		ps.setString(4, dto.getTel());
		ps.setString(5, dto.getAddress1());
		ps.setString(6, dto.getAddress2());
		ps.setString(7, dto.getPwhint());
		ps.setInt(8, 0);

		ps.executeUpdate();

	}
	
	public void update(CustomerDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "update customer set tel = ?, address1 = ?,address2 = ?,pwhint = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getTel());
		ps.setString(2, dto.getAddress1());
		ps.setString(3, dto.getAddress2());
		ps.setString(4, dto.getPwhint());
		ps.setString(5, dto.getId());

		ps.executeUpdate();

		}
	
	public void pwupdate(CustomerDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "update customer set pw = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getPw());
		ps.setString(2, dto.getId());

		ps.executeUpdate();
		}
	
	public CustomerDTO FindId(String name, String tel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from customer where name = ? and tel = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, tel);
		ResultSet rs = ps.executeQuery();
		CustomerDTO dto = new CustomerDTO();
		
		if (rs.next()) {
			dto.setName(rs.getString(1));
			dto.setId(rs.getString(2));
			dto.setPw(rs.getString(3));
			dto.setTel(rs.getString(4));
			dto.setAddress1(rs.getString(5));
			dto.setAddress2(rs.getString(6));
			dto.setPwhint(rs.getString(7));
			dto.setAdmin(rs.getInt(8));
		} else {
			dto = null;
		}
		return dto;
	}

}
