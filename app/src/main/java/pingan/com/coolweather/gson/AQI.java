package pingan.com.coolweather.gson;

/**
 * @author Robin
 * @date 2018/6/6 15:28
 */
public class AQI {
    public AQICity city;
    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
