package com.sa.ecomonitor.emergency.service;

public interface EmergServiceInterface {
	public void sendNotification(String emrgType);
	public void activateEmergencyProtocol(String location);
	public void switchOffEmergencySystem();
	
}
