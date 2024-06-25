package com.techvum.login.model;

public class GlobalInput {

	public static class CheckOtp {

		private String email;
		private String otp;
		private String newPass;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		public String getNewPass() {
			return newPass;
		}
		public void setNewPass(String newPass) {
			this.newPass = newPass;
		}
		
	}
	
	
	
	
	public class Messg {
		private String fail ;

		public String getFail() {
			return fail;
		}

		public void setFail(String fail) {
			this.fail = fail;
		}

		public Messg(String fail) {
			super();
			this.fail = fail;
		}

		@Override
		public String toString() {
			return "Messg [fail=" + fail + "]";
		}

		public Messg() {
			super();
			}
	}
	
	public class UserPass {
		private String email;
		private String newPass;
		
		public UserPass(String email, String pass) {
			super();
			this.email = email;
			this.newPass = pass;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNewPass() {
			return newPass;
		}
		public void setNewPass(String pass) {
			this.newPass = pass;
		}
		
		@Override
		public String toString() {
			return "UserPass [email=" + email + ", pass=" + newPass + "]";
		}
		
		public UserPass() {
			super();
		}
	}
	
	
}
