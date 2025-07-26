package com.sa.ecomonitor.weather.lightcontrolsensorsubscriber;

public class LightControlSensorServiceImpl implements LightControlSensorService {

    @Override
    public void turnOnLights(String[] areas) {
        // Simulate turning on lights for the areas
        for (String area : areas) {
            System.out.println("Turning on lights in " + area);
        }
    }

    @Override
    public void turnOffLights(String[] areas) {
        // Simulate turning off lights for the areas
        for (String area : areas) {
            System.out.println("Turning off lights in " + area);
        }
    }

    @Override
    public int getTotalLightsOn() {
        // Simulate returning the number of lights currently on
        int totalLightsOn = 70;  // Example value, you can modify this as needed
        return totalLightsOn;
    }
}
