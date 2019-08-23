package shoesshop;

public class CustomerDTO {
	String name;
	String id;
	String pw;
	String tel;
	String Address1;
	String Address2;
	String pwhint;
	int admin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getPwhint() {
		return pwhint;
	}
	public void setPwhint(String pwhint) {
		this.pwhint = pwhint;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", id=" + id + ", pw=" + pw + ", tel=" + tel + ", Address1=" + Address1
				+ ", Address2=" + Address2 + ", pwhint=" + pwhint + ", admin=" + admin + "]";
	}
	
	
}
