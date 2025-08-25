package notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import notificationservice.services.EmailNotificationService;
import notificationservice.services.SmsNotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	private final EmailNotificationService emailNotificationService;
	private final SmsNotificationService smsNotificationService;
	
	//constructor injection
	@Autowired
	public NotificationController(EmailNotificationService emailNotificationService, SmsNotificationService smsNotificationService) {
		this.emailNotificationService = emailNotificationService;
		this.smsNotificationService = smsNotificationService;
	}
	
	//sending the email notification
	
	@GetMapping("/sendEmail")
	public String sendEmail(@RequestParam String message) {
		emailNotificationService.sendNotification(message);
		return "Email notification sent!";
	}
	
	//sending the SMS notification
	
	@GetMapping("/sendSMS")
	public String sendSMS(@RequestParam String message) {
		smsNotificationService.sendNotification(message);
		return "SMS notification sent!";
	}
	
	
	//NotificationController depends on EmailNotificationService and SmsNotificationService.
	//Spring’s IoC container injects these services into the controller through the constructor,
	//ensuring that the correct implementations are used.
	//The @GetMapping annotations map HTTP requests to the respective notification service.
}