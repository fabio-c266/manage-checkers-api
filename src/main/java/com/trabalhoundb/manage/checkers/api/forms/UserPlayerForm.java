package com.trabalhoundb.manage.checkers.api.forms;

import java.util.Date;

import com.trabalhoundb.manage.checkers.api.entities.UserPlayer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPlayerForm {
	
	@NotNull @NotEmpty
	private String name;
	@NotNull
	private String gender;
	
	@NotNull @NotEmpty
	private String username;
	
	@NotNull @NotEmpty
	private String cpf;
	
	@NotNull @NotEmpty
	private String phone;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	public UserPlayer converter() {
		return new UserPlayer(null, gender, name, username, cpf, phone, email, password, null, null, null, true, new Date(), null);
	}

}
