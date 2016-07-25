package com.jayjariwala.nightlife.MODEL;

public class NightlifeModel {
	
	
	private String clubid,userid,keyword;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private int count;

	public String getClubid() {
		return clubid;
	}

	public void setClubid(String clubid) {
		this.clubid = clubid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
