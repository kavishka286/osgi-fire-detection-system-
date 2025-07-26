package com.sa.ecomonitor.weather.lightcontrolsensorsubscriber;

public interface LightControlSensorService {
    void turnOnLights(String[] areas);
    void turnOffLights(String[] areas);
    int getTotalLightsOn();
}
