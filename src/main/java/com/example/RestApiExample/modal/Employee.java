package com.example.RestApiExample.modal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="Employee")
public class Employee {
	
	public Employee() {}
    
	@Id
	private Long eid;
	private String Ename;
	private String esal;
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	
	
}
