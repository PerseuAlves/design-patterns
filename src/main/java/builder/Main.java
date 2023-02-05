package builder;

import java.time.LocalDate;

import builder.entity.Address;
import builder.entity.User;
import builder.entity.dto.UserDTO;
import builder.entity.dto.UserDTOBuilder;

public class Main {

	public static void main(String[] args) {
		User user = createUser();
		
		// Client has to provide director with concrete builder
		UserDTO dto = directBuild(UserDTO.getBuilder(), user);
		
		// Final result
		System.out.println(dto);
	}

	/**
	 * This method serves the role of director in builder pattern.
	 */
	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
		return builder
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress())
				.build();
	}

	/**
	 * Returns a sample user.
	 */
	public static User createUser() {
		Address address = new Address();
		
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		
		User user = new User();
		
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		user.setAddress(address);
		
		return user;
	}
}
