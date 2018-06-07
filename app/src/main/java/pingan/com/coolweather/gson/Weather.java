package pingan.com.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Robin
 * @date 2018/6/6 16:41
 */
public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
