package shoesshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	private int maxid;

	public void insert(ProductDTO dto) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");


		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String maxpid = "select coalesce(max(pid), 0) from product";
		PreparedStatement check = con.prepareStatement(maxpid);
		ResultSet rs = check.executeQuery();

		if (rs.next()) {
			maxid = Integer.parseInt(rs.getString(1));
		}


		String sql = "insert into product values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (maxid + 1));
		ps.setString(2, dto.getPname());
		ps.setString(3, dto.getPicture());
		ps.setInt(4, dto.getPrice());
		ps.setString(5, dto.getPcontent());


		// 4. SQL문 전송 요청
		ps.executeUpdate();

		ps.close();
		con.close();
	}
	
	public ArrayList<ProductDTO> getAllDb() throws Exception {
		
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String picture = "select * from product order by pid DESC";
		PreparedStatement ps = con.prepareStatement(picture);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPid(rs.getInt(1));
			dto.setPname(rs.getString(2));
			dto.setPicture(rs.getString(3));
			dto.setPrice(rs.getInt(4));
			dto.setPcontent(rs.getString(5));
			list.add(dto);
		}
		
		return list;
		
	}
	
	public void delete(ProductDTO dto) throws Exception {

		// 1. connector 설정
		Class.forName("com.mysql.jdbc.Driver");


		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		// 2. DB연결
		Connection con = DriverManager.getConnection(url, user, password);

		// 3. SQL문 결정
		String sql = "delete from product where pid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getPid());

		// 4. SQL문 전송 요청
		ps.executeUpdate();

		ps.close();
		con.close();
	}
	
public ArrayList<ProductDTO> search(String productname) throws Exception {
		
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/shoesshop?characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from product where pname like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,"%" + productname + "%");
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPid(rs.getInt(1));
			dto.setPname(rs.getString(2));
			dto.setPicture(rs.getString(3));
			dto.setPrice(rs.getInt(4));
			dto.setPcontent(rs.getString(5));
			list.add(dto);
		}
		
		return list;
		
	}
}
