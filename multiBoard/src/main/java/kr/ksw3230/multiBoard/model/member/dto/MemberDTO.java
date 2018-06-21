package kr.ksw3230.multiBoard.model.member.dto;

import java.util.Date;

public class MemberDTO {
	
	private String userid;
	private String passwd;
	private String name;
	private String gender;
	private String email;
	private Date join_date;
	private int user_level;
	
	public MemberDTO() {}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + ", join_date=" + join_date + ", user_level=" + user_level + "]";
	}

	
	
	
	
	

}
