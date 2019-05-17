package com.jenishbek.armatov.weatherapp;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteFetch {

    public static int currentConditionTemp = 0;
    public static String weatherText = "";
    public static int wetherIcon = 1;
    private static final String OPEN_WEATHER_MAP_API =
            "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";
    private static final String FIND_CITY =
            "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=";
    private static final String CURREND_CONDITION =
            "http://dataservice.accuweather.com/currentconditions/v1/";

    public static JSONArray getJsonCityKey(Context context, String city){

        try {
            URL url = new URL(String.format(FIND_CITY +
                    context.getString(R.string.open_weather_maps_app_id)+ "&q=" + city));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();


            Log.d(String.valueOf(connection.getURL()), "create");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            Log.d("buffered", "create");

            StringBuffer json = new StringBuffer();
            String tmp="";
            while((tmp=reader.readLine())!=null) {
                json.append(tmp).append("\n");
            }
            reader.close();

            JSONArray data = new JSONArray(json.toString());
            Log.d("city", "create");

            return data;
        }catch(Exception e){
            Log.d("not create", city);

            return null;
        }
    }
    public static JSONArray getCurrentCondition(Context context, String city){
        JSONArray jsonArray = getJsonCityKey(context,city);


        try {
            JSONObject jsonCityKey = jsonArray.getJSONObject(0);
            String cityKey = jsonCityKey.getString("Key");

            URL url = new URL(String.format(CURREND_CONDITION + cityKey + "?apikey=" +
                    context.getString(R.string.open_weather_maps_app_id) + "&language=ru"));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            Log.d("buffered", "create");

            StringBuffer json = new StringBuffer();
            String tmp="";
            while((tmp=reader.readLine())!=null) {
                json.append(tmp).append("\n");
            }
            reader.close();

            JSONArray data = new JSONArray(json.toString());
            Log.d("getCurrentCondition", "create");

            return data;
        }catch(Exception e){
            Log.d("not create", city);

            return null;
        }
    }
    public static JSONObject getJSON(Context context, String city){
        JSONArray jsonArray = getJsonCityKey(context,city);
        JSONArray jsonArrayCC = getCurrentCondition(context,city);

        try {
            JSONObject jsonCityKey = jsonArray.getJSONObject(0);
            String cityKey = jsonCityKey.getString("Key");

            JSONObject jsonCurrentCondition = jsonArrayCC.getJSONObject(0);
            weatherText = jsonCurrentCondition.getString("WeatherText");
            wetherIcon = jsonCurrentCondition.getInt("WeatherIcon");
            currentConditionTemp = jsonCurrentCondition.getJSONObject("Temperature")
                    .getJSONObject("Metric")
                    .getInt("Value");
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API + cityKey + "?apikey=" +
                    context.getString(R.string.open_weather_maps_app_id)  + "&language=ru&metric=true"));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer();
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());


            return data;
        }catch(Exception e){
            return null;
        }
    }


}
