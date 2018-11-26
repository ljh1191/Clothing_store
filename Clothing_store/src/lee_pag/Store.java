package lee_pag;

public class Store {
	private int num;
	private String name;
	private String owner;
	private String storenum;
	private String addr;
	private String tell;
	private String id;
	private char[] pwd;

	public int getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public char[] getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public String getStorenum() {
		return storenum;
	}

	public String getAddr() {
		return addr;
	}

	public String getTell() {
		return tell;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setStorenum(String string) {
		this.storenum = string;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(char[] cs) {
		this.pwd = cs;
	}
}
