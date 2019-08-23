package shoesshop;

public class ProductDTO {
	int pid;
	String pname;
	String picture;
	int price;
	String pcontent;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", picture=" + picture + ", price=" + price
				+ ", pcontent=" + pcontent + "]";
	}

}


