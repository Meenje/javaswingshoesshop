package shoesshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BasketDAO {
	public void insert(CustomerDTO cdto, ProductDTO pdto) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String checkdup = "select * from basket where cid = ? and pid = ?;";
		PreparedStatement check = con.prepareStatement(checkdup);
		check.setString(1, cdto.getId());
		check.setInt(2, pdto.getPid());
		ResultSet rs = check.executeQuery();

		if (!rs.next()) {
			String sql = "insert into basket values (?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cdto.getId());
			ps.setInt(2, pdto.getPid());

			// 4. SQL문 전송 요청
			ps.executeUpdate();

			ps.close();
			con.close();
		} else {
			JOptionPane.showMessageDialog(null, "이미 장바구니에 있습니다.");
			con.close();
		}

	}

	public ArrayList<ProductDTO> getProduct(CustomerDTO cdto) throws Exception {
		ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String s = "select * from product join basket on product.pid = basket.pid where basket.cid = ?";
		PreparedStatement ps = con.prepareStatement(s);
		ps.setString(1, cdto.getId());
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProductDTO pdto = new ProductDTO();
			pdto.setPid(rs.getInt(1));
			pdto.setPname(rs.getString(2));
			pdto.setPicture(rs.getString(3));
			pdto.setPrice(rs.getInt(4));
			pdto.setPcontent(rs.getString(5));
			plist.add(pdto);
		}

		// 4. SQL문 전송 요청
		ps.close();
		con.close();

		return plist;
	}

	public void deleteProduct(String pname, String cid) throws Exception {
		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String search = "select pid from product where pname = ?";
		PreparedStatement yesterday = con.prepareStatement(search);
		yesterday.setString(1, pname);
		ResultSet row = yesterday.executeQuery();
		int pid;
		if (row.next()) {
			pid = row.getInt(1);
			String s = "delete from basket where pid = ? and cid = ?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, pid);
			ps.setString(2, cid);
			
			// 4. SQL문 전송 요청
			ps.executeUpdate();
			ps.close();
		}
		
		
		con.close();

	}
	
	public void erase(ProductDTO dto) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String sql = "delete from basket where pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getPid());

		// 4. SQL문 전송 요청
		ps.executeUpdate();

		ps.close();
		con.close();
	}
}
