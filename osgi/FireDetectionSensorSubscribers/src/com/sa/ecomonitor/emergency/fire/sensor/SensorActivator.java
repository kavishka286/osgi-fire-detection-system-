package com.sa.ecomonitor.emergency.fire.sensor;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.ecomonitor.emergency.service.EmergServiceInterface;



public class SensorActivator implements BundleActivator {

    ServiceReference serviceReference;
    Scanner sc = new Scanner(System.in);

    public void start(BundleContext context) throws Exception {
        
        // Get the service reference from the OSGi context
        serviceReference = context.getServiceReference(EmergServiceInterface.class.getName());
        
        // Get the actual service from the reference
        EmergServiceInterface emergencyServices = (EmergServiceInterface) context.getService(serviceReference);
        
        // Print startup message
        System.out.println("Fire Detection Sensor is Online!");
        
        // Run test case for emergency
        runTest(emergencyServices);
    }

    public void runTest(EmergServiceInterface emergencyServices) {
        
        // Variables
        String emrgType = "fire";
        String userInput;
        String location;
        
        // Scanner object for user input
        System.out.println("Fire detection sensor is now online...!! \n Running Emergency Test cases now..." );
        
        // Get user input to initiate the test case
        do {
            System.out.println("Initiate test run (Y/N): ");
            userInput = sc.next();
            
            if (userInput.equals("Y") || userInput.equals("y")) {
                // Proceed with test if user inputs 'Y' or 'y'
                System.out.println("Fire location: ");
                location = sc.next();
                
                emergencyServices.sendNotification(emrgType);  // Send emergency notification
                emergencyServices.activateEmergencyProtocol(location);  // Activate emergency protocol
                break;  // Exit loop after successful test
            } else if (userInput.equals("N") || userInput.equals("n")) {
                // Exit test if user inputs 'N' or 'n'
                System.out.println("Test run declined!");
                break;
            } else {
                // Handle invalid input
                System.out.println("Unrecognizable character. Please Enter again.");
            }
        } while (true);
        
        System.out.println("Test run is completed!!!");
    }

    public void stop(BundleContext context) throws Exception {
        // When the bundle is stopped
        System.out.println("Fire detection sensor is now offline...!!");
        
        // Release the service reference
        context.ungetService(serviceReference);
        
        // Close the Scanner object to avoid resource leaks
        if (sc != null) {
            sc.close();
        }
    }
}
