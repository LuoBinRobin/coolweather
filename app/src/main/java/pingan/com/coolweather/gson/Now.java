package pingan.com.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author Robin
 * @date 2018/6/6 15:30
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More {
        @SerializedName("txt")
        public String info;
    }
}
