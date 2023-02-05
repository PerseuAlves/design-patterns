package builder.entity.dto;

import java.time.LocalDate;
import java.time.Period;

import builder.entity.Address;

//Product class
public class UserDTO {

	private String name;
	private String address;
	private String age;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	private void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name: " + name + "\n" + 
			   "age: " + age + "\n" + 
			   "address: " + address;
	}
	
	//Get builder instance
	public static UserDTOBuilderImpl getBuilder() {
		return new UserDTOBuilderImpl();
	}
	
	//Builder class
	public static class UserDTOBuilderImpl implements UserDTOBuilder {
		
		private String firstName;
		private String lastName;
		private String age;
		private String address;
		private UserDTO userDTO;
		
		public UserDTOBuilderImpl withFirstName(String fname) {
			this.firstName = fname;
			return this;
		}
		
		public UserDTOBuilderImpl withLastName(String lname) {
			this.lastName = lname;
			return this;
		}
		
		public UserDTOBuilderImpl withBirthday(LocalDate date) {
			age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTOBuilderImpl withAddress(Address address) {
			this.address = address.getHouseNumber() + " " 
						 + address.getStreet() + "\n" 
						 + address.getCity() + ", " 
						 + address.getState() + " " 
						 + address.getZipcode();

			return this;
		}
		
		public UserDTO build() {
			this.userDTO = new UserDTO();
			
			userDTO.setName(firstName + " " + lastName);
			userDTO.setAddress(address);
			userDTO.setAge(age);
			
			return this.userDTO;
		}
		
		public UserDTO getUserDTO() {
			return this.userDTO;
		}
	}
}
