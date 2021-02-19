package com.bigbang.member.vo;

public class MemberVO {
	private String name;
	private String id;
	private String pw;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;
	private int no;
	private int groupcode;
	


	public MemberVO() {
	}
	
	


	public MemberVO(String id) {
		super();
		this.id = id;
	}




	public MemberVO(String name, String pw, String phone1, String phone2, String phone3, String gender,String id ) {
		super();
		this.name = name;
		this.pw = pw;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.gender = gender;
		this.id = id;
	}




	public MemberVO(int no) {
		super();
		this.no = no;
	}




	public MemberVO(String id, int no) {
		super();
		this.id = id;
		this.no = no;
	}


	public MemberVO( String phone1, String phone2, String phone3,int groupcode, int no,String name ) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.groupcode = groupcode;
		this.no = no;
		this.name = name;
	}

	


	public MemberVO(String id, String name, String phone1, String phone2, String phone3, int groupcode) {
		super();
		this.id = id;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.groupcode = groupcode;
	}




	public MemberVO(String id, int no, String name,  String phone1, String phone2, String phone3, int groupcode) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.groupcode = groupcode;
	}




	public MemberVO(int no, String name, String phone1, String phone2, String phone3,  int groupcode) {
		super();
		this.no = no;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.groupcode = groupcode;
	}

	
	
	public MemberVO(String name, String id, int no) {
		super();
		this.name = name;
		this.id = id;
		this.no = no;
	}



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




	public String getPhone1() {
		return phone1;
	}




	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}




	public String getPhone2() {
		return phone2;
	}




	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}




	public String getPhone3() {
		return phone3;
	}




	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public int getNo() {
		return no;
	}




	public void setNo(int no) {
		this.no = no;
	}




	public int getGroupcode() {
		return groupcode;
	}




	public void setGroupcode(int groupcode) {
		this.groupcode = groupcode;
	}












	



	
	
}
