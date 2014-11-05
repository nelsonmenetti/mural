package br.com.mural.entity;

public class Address {

	private String id;
	private String streetAddress;
	private String extraAddressInfo;
	private String neighborhood ;
	private String addressNumber;
	private String zipcode;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getExtraAddressInfo() {
		return extraAddressInfo;
	}
	public void setExtraAddressInfo(String extraAddressInfo) {
		this.extraAddressInfo = extraAddressInfo;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressNumber == null) ? 0 : addressNumber.hashCode());
		result = prime
				* result
				+ ((extraAddressInfo == null) ? 0 : extraAddressInfo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((neighborhood == null) ? 0 : neighborhood.hashCode());
		result = prime * result
				+ ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressNumber == null) {
			if (other.addressNumber != null)
				return false;
		} else if (!addressNumber.equals(other.addressNumber))
			return false;
		if (extraAddressInfo == null) {
			if (other.extraAddressInfo != null)
				return false;
		} else if (!extraAddressInfo.equals(other.extraAddressInfo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (neighborhood == null) {
			if (other.neighborhood != null)
				return false;
		} else if (!neighborhood.equals(other.neighborhood))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress
				+ ", extraAddressInfo=" + extraAddressInfo + ", neighborhood="
				+ neighborhood + ", addressNumber=" + addressNumber
				+ ", zipcode=" + zipcode + "]";
	}
	
}
