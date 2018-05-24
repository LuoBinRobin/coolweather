package pingan.com.coolweather.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pingan.com.coolweather.db.City;
import pingan.com.coolweather.db.County;
import pingan.com.coolweather.db.Province;

/**
 * @author Robin
 * @date 2018/5/24 15:01
 */
public class Utility {
    public static boolean handleProvinceResponse(String response) {
       if (!TextUtils.isEmpty(response)) {
           try {
               JSONArray allProvinces = new JSONArray(response);
               for (int i = 0; i < allProvinces.length(); i++) {
                   JSONObject provinceObject = allProvinces.getJSONObject(i);
                   Province province = new Province();
                   province.setProvinceName(provinceObject.getString("name"));
                   province.setProvinceCode(provinceObject.getInt("id"));
                   province.save();
               }
               return true;
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.setCityCode(cityObject.getInt("id"));
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleContryResponse(String response,int cityId) {
       if (!TextUtils.isEmpty(response)) {
           try {
               JSONArray allCountries = new JSONArray(response);
               for (int i = 0; i < allCountries.length(); i++) {
                   JSONObject countryObject = allCountries.getJSONObject(i);
                   County county = new County();
                   county.setCityId(cityId);
                   county.setCountyName(countryObject.getString("name"));
                   county.setWeatherId(countryObject.getString("weather_id"));
                   county.save();
               }
               return true;
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
        return false;
    }
}
