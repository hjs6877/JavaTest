package com.soom.pattern.observerpattern;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-06-22 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class WeatherData {

    public void measurementsChanged(){
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();


    }

    private float getPressure() {
        return 0;
    }

    private float getHumidity() {
        return 0;
    }

    private float getTemperature() {
        return 0;
    }


}
