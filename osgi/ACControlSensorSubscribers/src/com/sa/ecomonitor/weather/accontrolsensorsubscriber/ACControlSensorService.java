

package com.sa.ecomonitor.weather.accontrolsensorsubscriber;

public interface ACControlSensorService {
	public void turnOnAC(String[] areas, int temp);
    public void turnOffAC(String[] areas);
    public int[] getTotalAcOn();
}
