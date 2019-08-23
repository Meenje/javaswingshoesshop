package shoesshop;

public class BasketDTO {
	String cid;
	int pid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "BasketDTO [cid=" + cid + ", pid=" + pid + "]";
	}

}
