package notificationservice.services;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationServices{

	@Override
	public void sendNotification(String message) {
		System.out.println("Sending email notification: "+message);
	}
	
	
	//@Service annotations mark these classes as Spring-managed beans.
}