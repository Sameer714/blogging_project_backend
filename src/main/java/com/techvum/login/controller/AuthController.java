package com.techvum.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvum.login.model.JwtRequest;
import com.techvum.login.model.JwtResponse;
import com.techvum.login.model.User;
import com.techvum.login.repository.UserRepo;
import com.techvum.login.security.JwtHelper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
	private String token;

	public AuthController() {
	}

	public AuthController(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		JwtResponse response = new JwtResponse();

		User user = userRepo.findByEmail(request.getGmail());
		if (user != null) {
//			if (passwordEncoder.matches(request.getPassw(), user.getPassword())) {
			if (user.getPassword().equals(request.getPassw())) {

				JwtHelper jwtHelper = new JwtHelper();
				token = jwtHelper.generateToken(user);

				response.setJwtoken(token);
				response.setUsernm(user.getUsername());
				response.setRole(user.getRole());
				response.setId(user.getId());
			} else {
				response.setUsernm(user.getUsername());
			}
		} else {
			response.setUsernm(request.getGmail());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}