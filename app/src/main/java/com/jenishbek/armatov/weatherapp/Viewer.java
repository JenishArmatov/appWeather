package com.jenishbek.armatov.weatherapp;


    import android.support.v7.widget.Toolbar;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.widget.ImageView;
    import android.widget.TextView;

    import com.jenishbek.armatov.weatherapp.R;

public class Viewer extends AppCompatActivity {

    private Controller controller;
    TextView cityField;

    TextView date1;
    TextView date2;
    TextView date3;
    TextView date4;
    TextView date5;

    ImageView currentIcon;
    ImageView icon1;
    ImageView icon2;
    ImageView icon3;
    ImageView icon4;
    ImageView icon5;

    TextView detailsField;
    TextView detailsField1;
    TextView detailsField2;
    TextView detailsField3;
    TextView detailsField4;
    TextView detailsField5;

    TextView currentTemperatureField;
    TextView currentTemperatureField1;
    TextView currentTemperatureField2;
    TextView currentTemperatureField3;
    TextView currentTemperatureField4;
    TextView currentTemperatureField5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        initToolbar();
        initToday();
        initDay1();
        initDay2();
        initDay3();
        initDay4();
        initDay5();
        controller = new Controller(this);
        controller.updateWeatherData(this);
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initToday() {
        cityField = (TextView)findViewById(R.id.city_field);
        currentIcon = (ImageView)findViewById(R.id.current_icon) ;
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
    }
    private void initDay1() {
        date1 = findViewById(R.id.date1);
        icon1 = findViewById(R.id.icon1);
        detailsField1 = findViewById(R.id.details_field1);
        currentTemperatureField1 = findViewById(R.id.current_temperature_field1);
    }

    private void initDay2() {
        date2 = findViewById(R.id.date2);
        icon2 = findViewById(R.id.icon2);
        detailsField2 = findViewById(R.id.details_field2);
        currentTemperatureField2 = findViewById(R.id.current_temperature_field2);
    }

    private void initDay3() {
        date3 = findViewById(R.id.date3);
        icon3 = findViewById(R.id.icon3);
        detailsField3 = findViewById(R.id.details_field3);
        currentTemperatureField3 = findViewById(R.id.current_temperature_field3);
    }

    private void initDay4() {
        date4 = findViewById(R.id.date4);
        icon4 = findViewById(R.id.icon4);
        detailsField4 = findViewById(R.id.details_field4);
        currentTemperatureField4 = findViewById(R.id.current_temperature_field4);
    }
    private void initDay5() {
        date5 = findViewById(R.id.date5);
        icon5 = findViewById(R.id.icon5);
        detailsField5 = findViewById(R.id.details_field5);
        currentTemperatureField5 = findViewById(R.id.current_temperature_field5);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_viewer, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.change_city){
            controller.showDialog();
        }
        return false;
    }


}

