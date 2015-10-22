package org.itc.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="service")
public class ServiceType{
	private int serviceId;
	private String serviceName;

	
	public ServiceType() {
		
	}
	
	    public ServiceType(int serviceId, String serviceName) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
	
	}
	
	
	    @Id
	    @Column(name = "serviceId")
	public int getserviceId() {
		return serviceId;
	}
	public void setserviceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	@Column(name = "serviceName") 
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
