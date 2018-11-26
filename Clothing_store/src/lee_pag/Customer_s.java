package lee_pag;

public class Customer_s {
	private int custid;
	private String name;
	private String birth;
	private String gender;
	private String addr;
	private String phone;
	private String id;
	private char[] pwd;
	private int count;
	private double ratio;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCount() {
		return count;
	}

	public double getRatio() {
		return ratio;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getId() {
		return id;
	}

	public char[] getPwd() {
		return pwd;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(char[] pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCustid() {
		return custid;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getAddr() {
		return addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
