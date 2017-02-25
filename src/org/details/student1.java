package org.details;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student1 {
	public String stname;
	@Id
	public String stemail;
	public String stpass;
	public String stpass1;
	
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStemail() {
		return stemail;
	}
	public void setStemail(String stemail) {
		this.stemail = stemail;
	}
	public String getStpass() {
		return stpass;
	}
	public void setStpass(String stpass) {
		this.stpass = stpass;
	}
	public String getStpass1() {
		return stpass1;
	}
	public void setStpass1(String stpass1) {
		this.stpass1 = stpass1;
	}
	
}
