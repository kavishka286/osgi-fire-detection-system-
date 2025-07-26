package com.sa.ecomonitor.accesscontroller.notificationsystem;

public class NotificationSystemImpl implements NotificationSystem{

	@Override
	public void SendNotification(String location) {
		
		System.out.println("Opening Door at " + location);
		
	}

	

}
