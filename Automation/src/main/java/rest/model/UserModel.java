package rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private int id;
	private String email;
	private String username;
}