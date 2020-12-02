package models;

public class Address {
	String addressId;
	String street;
	String state;
	String city;
	String zip;
	public Address(String addressId, String street, String city,String state,  String zip) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
	public String getAddressId() {
		return addressId;
	}
	public String getStreet() {
		return street;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	@Override
    public String toString() {
        return ("ID: " + this.addressId +
        			"\t " + this.street +
                    " ,"+ this.city +
                    ", " + this.state + 
                    "  " + this.zip
                    );
    }
}
