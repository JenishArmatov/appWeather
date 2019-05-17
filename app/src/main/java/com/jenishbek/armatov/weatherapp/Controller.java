package com.jenishbek.armatov.weatherapp;

import android.app.Activity;



public class Controller {

    private Model model;


    Controller(Viewer viewer) {
        model = new Model(viewer);
    }
    public void updateWeatherData(Activity activity){
        CityPreference cityPreference = new CityPreference(activity);
        model.updateWeatherData(cityPreference.getCity());
        model.setDate();

    }

    public void showDialog() {
        model.showInputDialog();
    }
}
