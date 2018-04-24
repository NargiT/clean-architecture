package fr.nargit.email.api;

public interface EmailService {

	void sendEmail(String email, String subject, String content);
}
