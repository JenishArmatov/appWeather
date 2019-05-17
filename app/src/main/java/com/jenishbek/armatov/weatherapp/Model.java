package com.jenishbek.armatov.weatherapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class Model {
    private Viewer viewer;
    private Handler handler;


    Model(Viewer viewer) {
        this.viewer = viewer;
        handler = new Handler();


    }
    public void updateWeatherData(final String city) {
        viewer.cityField.setText(city.toUpperCase(Locale.ENGLISH));
        if (isOnline(viewer)) {
            new Thread() {
                public void run() {
                    final JSONObject json = RemoteFetch.getJSON(viewer.getApplicationContext(), city);
                    if (json == null) {
                        handler.post(new Runnable() {
                            public void run() {
                                Toast.makeText(viewer.getApplicationContext(),
                                        viewer.getApplicationContext().getString(R.string.place_not_found),
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            public void run() {
                                renderWeather(json);
                            }
                        });
                    }
                }
            }.start();
        }else {Toast.makeText(viewer.getApplicationContext(),
                viewer.getApplicationContext().getString(R.string.chek_internet),
                Toast.LENGTH_LONG).show();}
    }
    private void renderWeather(JSONObject json){

        try {
            int[] tempsMin = new int[5];
            int[] tempsMax = new int[5];
            for(int i = 0; i < 5; i++){
                tempsMin[i] = json.getJSONArray("DailyForecasts")
                        .getJSONObject(i).getJSONObject("Temperature")
                        .getJSONObject("Minimum").getInt("Value");
                tempsMax[i] = json.getJSONArray("DailyForecasts")
                        .getJSONObject(i).getJSONObject("Temperature")
                        .getJSONObject("Maximum").getInt("Value");
            }

            viewer.currentTemperatureField1.setText(tempsMax[0] + " °C"
                    + "/" + tempsMin[0] + " °C");
            viewer.currentTemperatureField2.setText(tempsMax[1] + " °C"
                    + "/" + tempsMin[1] + " °C");
            viewer.currentTemperatureField3.setText(tempsMax[2] + " °C"
                    + "/" + tempsMin[2] + " °C");
            viewer.currentTemperatureField4.setText(tempsMax[3] + " °C"
                    + "/" + tempsMin[3] + " °C");
            viewer.currentTemperatureField5.setText(tempsMax[4] + " °C"
                    + "/" + tempsMin[4] + " °C");

            viewer.currentTemperatureField.setText(RemoteFetch.currentConditionTemp + " °C");
            viewer.detailsField.setText(RemoteFetch.weatherText);
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }

        viewer.currentIcon.setImageBitmap(new Icons().getImage(RemoteFetch.wetherIcon,viewer));
        setDetailsField(json);
    }



    private void setDetailsField(JSONObject jsonObject){
        try {
            viewer.detailsField1.setText(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(0).getJSONObject("Day").getString("IconPhrase"));
            viewer.detailsField2.setText(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(1).getJSONObject("Day").getString("IconPhrase"));
            viewer.detailsField3.setText(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(2).getJSONObject("Day").getString("IconPhrase"));
            viewer.detailsField4.setText(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(3).getJSONObject("Day").getString("IconPhrase"));
            viewer.detailsField5.setText(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(4).getJSONObject("Day").getString("IconPhrase"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setIcon(jsonObject);

    }
    private void setIcon(JSONObject jsonObject){
        try {
            viewer.icon1.setImageBitmap(new Icons().getImage(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(0).getJSONObject("Day").getInt("Icon"),viewer));
            viewer.icon2.setImageBitmap(new Icons().getImage(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(1).getJSONObject("Day").getInt("Icon"),viewer));
            viewer.icon3.setImageBitmap(new Icons().getImage(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(2).getJSONObject("Day").getInt("Icon"),viewer));
            viewer.icon4.setImageBitmap(new Icons().getImage(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(3).getJSONObject("Day").getInt("Icon"),viewer));
            viewer.icon5.setImageBitmap(new Icons().getImage(jsonObject.getJSONArray("DailyForecasts")
                    .getJSONObject(4).getJSONObject("Day").getInt("Icon"),viewer));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void setDate(){

        int[] days = new int[5];
        for(int i = 0; i < 5; i++){
            days[i] = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + i;
            if(days[i] > 7) days[i] = days[i] - 7;
        }
        viewer.date1.setText(new DateFormatSymbols().getShortWeekdays()[days[0]]);
        viewer.date2.setText(new DateFormatSymbols().getShortWeekdays()[days[1]]);
        viewer.date3.setText(new DateFormatSymbols().getShortWeekdays()[days[2]]);
        viewer.date4.setText(new DateFormatSymbols().getShortWeekdays()[days[3]]);
        viewer.date5.setText(new DateFormatSymbols().getShortWeekdays()[days[4]]);
    }
    public void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(viewer);
        builder.setTitle("Введите имя города " +"\n" +
                "используя английский алфавит");
        final EditText input = new EditText(viewer);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Найти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }
    private void changeCity(String city){
        new CityPreference(viewer).setCity(city);
        updateWeatherData(city);
    }
    private boolean isOnline(Context context)
    {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        return false;
    }
}
