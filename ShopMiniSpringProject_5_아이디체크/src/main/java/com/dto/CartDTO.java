package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("CartDTO")
	public class CartDTO {

	private int num;
	private String userid;
	private String gCode;
	private String gName;
	private int gPrice;
	private String gSize;
	private String gColor;
	private int gAmount;
	private String gImage;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(int num, String userid, String gCode, String gName, int gPrice, String gSize, String gColor,
			int gAmount, String gImage) {
		super();
		this.num = num;
		this.userid = userid;
		this.gCode = gCode;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gSize = gSize;
		this.gColor = gColor;
		this.gAmount = gAmount;
		this.gImage = gImage;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int getgPrice() {
		return gPrice;
	}
	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}
	public String getgSize() {
		return gSize;
	}
	public void setgSize(String gSize) {
		this.gSize = gSize;
	}
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	public int getgAmount() {
		return gAmount;
	}
	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}
	public String getgImage() {
		return gImage;
	}
	public void setgImage(String gImage) {
		this.gImage = gImage;
	}
	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", userid=" + userid + ", gCode=" + gCode + ", gName=" + gName + ", gPrice="
				+ gPrice + ", gSize=" + gSize + ", gColor=" + gColor + ", gAmount=" + gAmount + ", gImage=" + gImage
				+ "]";
	}
	
		
	}

