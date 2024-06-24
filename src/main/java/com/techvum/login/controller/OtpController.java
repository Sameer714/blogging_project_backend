package com.techvum.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techvum.login.model.CheckOtp;
import com.techvum.login.model.GlobalInput;
import com.techvum.login.model.SpringMail;
import com.techvum.login.service.OtpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("v1/api/otp")
public class OtpController {

	@Autowired
	private OtpService otpService;


	@PostMapping("/send")
	public ResponseEntity<Object> sendOtp(@RequestBody SpringMail email) {
		return otpService.sendOtp(email.getEmail());
	}
	
	@PostMapping("/check/Otp")
	public ResponseEntity<Object> checkAndValidateOtp(@RequestBody GlobalInput.CheckOtp checkOtp) {
	    return otpService.checkAndValidateOtp(checkOtp);
	}	
}