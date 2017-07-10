package com.exam.test.common;

public class CommonDTO {
	private String credate;
	private String cretime;
	private String creuser;
	private String lmotime;
	private String lmodate;
	private String lmouser;
	private String updatcnt;
	private DateUtil du;
	
	public CommonDTO(){
		du = new DateUtil("yyyymmdd", "HHmmss");
				
	}
	
	public String getCredate() {
		if(credate==null){
			credate = du.getDate();
		}
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}
	public String getCretime() {
		if(cretime==null){
			cretime = du.getTime();
		}
		return cretime;
	}
	public void setCretime(String cretime) {
		this.cretime = cretime;
	}
	public String getCreuser() {
		return creuser;
	}
	public void setCreuser(String creuser) {
		this.creuser = creuser;
	}
	public String getLmotime() {
		if(lmotime==null){
			lmotime = du.getTime();
		}
		return lmotime;
	}
	public void setLmotime(String lmotime) {
		this.lmotime = lmotime;
	}
	public String getLmodate() {
		if(lmodate==null){
			lmodate = du.getDate();
		}
		return lmodate;
	}
	public void setLmodate(String lmodate) {
		this.lmodate = lmodate;
	}
	public String getLmouser() {
		return lmouser;
	}
	public void setLmouser(String lmouser) {
		this.lmouser = lmouser;
	}
	public String getUpdatcnt() {
		if(updatcnt==null){
			updatcnt = "0";
		}
		return updatcnt;
	}
	public void setUpdatcnt(String updatcnt) {
		this.updatcnt = updatcnt;
	}
}
