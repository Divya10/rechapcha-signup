package org.details;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class staff1 {
	public String staffname;
	@Id
	public String staffemail;
	public String staffpass;
	public String staffpass1;
	
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getStaffemail() {
		return staffemail;
	}
	public void setStaffemail(String staffemail) {
		this.staffemail = staffemail;
	}
	public String getStaffpass() {
		return staffpass;
	}
	public void setStaffpass(String staffpass) {
		this.staffpass = staffpass;
	}
	
	public String getStaffpass1() {
		return staffpass1;
	}
	public void setStaffpass1(String staffpass1) {
		this.staffpass1 = staffpass1;
	}

}
