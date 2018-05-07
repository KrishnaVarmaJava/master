package mylas.com.erp.demo.dto;

public class Services {

	String ServiceID;
	String ServiceName;
	String ServiceDescription;
	private boolean active = true;
	public String getServiceID() {
		return ServiceID;
	}
	public void setServiceID(String serviceID) {
		ServiceID = serviceID;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getServiceSescription() {
		return ServiceDescription;
	}
	public void setServiceSescription(String serviceSescription) {
		ServiceDescription = serviceSescription;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Services [ServiceID=" + ServiceID + ", ServiceName=" + ServiceName + ", ServiceSescription="
				+ ServiceDescription + ", active=" + active + "]";
	}
	public Services(String serviceID, String serviceName, String serviceSescription, boolean active) {
		super();
		ServiceID = serviceID;
		ServiceName = serviceName;
		ServiceDescription = serviceSescription;
		this.active = active;
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
