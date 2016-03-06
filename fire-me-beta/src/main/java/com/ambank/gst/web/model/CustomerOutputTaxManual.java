package com.ambank.gst.web.model;


public class CustomerOutputTaxManual {

	String customerId;
	String customerCIFId;
	String customerName;
	String customerStatus;
	String customerGstNumber;
	String residenceCountryCode;
	String malaysianNonResident;
	String addressLine1;
	String addressLine2;
	String city;
	String postalCode;
	String state;
	String country;
	String mobileNumber;
	String officeNumber;
	String faxNumber;
	String emailAddress;
	String website;
	String error;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCIFId() {
		return customerCIFId;
	}
	public void setCustomerCIFId(String customerCIFId) {
		this.customerCIFId = customerCIFId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCustomerGstNumber() {
		return customerGstNumber;
	}
	public void setCustomerGstNumber(String customerGstNumber) {
		this.customerGstNumber = customerGstNumber;
	}
	public String getResidenceCountryCode() {
		return residenceCountryCode;
	}
	public void setResidenceCountryCode(String residenceCountryCode) {
		this.residenceCountryCode = residenceCountryCode;
	}
	public String getMalaysianNonResident() {
		return malaysianNonResident;
	}
	public void setMalaysianNonResident(String malaysianNonResident) {
		this.malaysianNonResident = malaysianNonResident;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public CustomerOutputTaxManual(String customerId, String customerCIFId,
			String customerName, String customerStatus,
			String customerGstNumber, String residenceCountryCode,
			String malaysianNonResident, String addressLine1,
			String addressLine2, String city, String postalCode, String state,
			String country, String mobileNumber, String officeNumber,
			String faxNumber, String emailAddress, String website, String error) {
		super();
		this.customerId = customerId;
		this.customerCIFId = customerCIFId;
		this.customerName = customerName;
		this.customerStatus = customerStatus;
		this.customerGstNumber = customerGstNumber;
		this.residenceCountryCode = residenceCountryCode;
		this.malaysianNonResident = malaysianNonResident;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.officeNumber = officeNumber;
		this.faxNumber = faxNumber;
		this.emailAddress = emailAddress;
		this.website = website;
		this.error = error;
	}
	
	public CustomerOutputTaxManual() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerOutputTaxManual [customerId=" + customerId
				+ ", customerCIFId=" + customerCIFId + ", customerName="
				+ customerName + ", customerStatus=" + customerStatus
				+ ", customerGstNumber=" + customerGstNumber
				+ ", residenceCountryCode=" + residenceCountryCode
				+ ", malaysianNonResident=" + malaysianNonResident
				+ ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", postalCode="
				+ postalCode + ", state=" + state + ", country=" + country
				+ ", mobileNumber=" + mobileNumber + ", officeNumber="
				+ officeNumber + ", faxNumber=" + faxNumber + ", emailAddress="
				+ emailAddress + ", website=" + website + ", error=" + error +"]";
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
		
}
