package com.badbadcode.application.service;


public interface IEmailService {

	public boolean sendEmail(String toEmail, String body);
}
