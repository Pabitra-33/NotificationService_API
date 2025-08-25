package notificationservice.services;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationServices{

	@Override
	public void sendNotification(String message) {
		System.out.println("Sending SMS notification: "+message);
	}
	
	//@Service annotations mark these classes as Spring-managed beans.
}