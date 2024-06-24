package com.techvum.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techvum.login.model.Otp;

@Repository
public interface OtpRepo extends JpaRepository<Otp, Long> {
	Otp findByEmailAndUserName(String email, String userName);

	Otp findByEmail(String email);
}