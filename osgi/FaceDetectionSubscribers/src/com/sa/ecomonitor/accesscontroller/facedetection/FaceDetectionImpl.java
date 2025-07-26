package com.sa.ecomonitor.accesscontroller.facedetection;

import java.util.Scanner;

import com.sa.ecomonitor.accesscontroller.empdetection.DetectionServiceImpl;

public class FaceDetectionImpl{
	

	
	public void sendDetails() {
		
		//Scanner object
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter the Employee ID: ");
		String empID = sc.next();
		
		System.out.println("Enter the Password: ");
		String password = sc.next();
				
		System.out.println("Enter the Locatin: ");
		String location = sc.next();
		
		
		boolean isValid = FaceDetectionActivator.checkEmpValidity.checkValidity(empID, password);
	    if (isValid) {
	    	
	        System.out.println("Credentials are valid.");
	        //Send notification
	        FaceDetectionActivator.notifyEmp.SendNotification(location);
	        //Open door
	    	FaceDetectionActivator.controllAutoDoor.doorUnlock(location);
	    } else {
	    	
	        System.out.println("Credentials are invalid.");
	    }

			
	}
	

	
}
