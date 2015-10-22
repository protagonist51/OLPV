package org.itc.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status{
	private int statusId;
	private String status;
//	private Set<UserDetails> userdetails = new HashSet<UserDetails>(0);
	
	
	
	
	public Status() {
		
	}
	
	    public Status(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	//	this.userdetails = userdetails;
	}
	
	
	
	    @Id
	    @Column(name = "statusId")
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	@Column(name = "status") 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
	public Set<UserDetails> getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(Set<UserDetails> userdetails) {
		this.userdetails = userdetails;
	}*/
	
	
}
