package none.none.all_sensors;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

//import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {

    Sensor accel;
    SensorManager accel_sm;
    TextView accel_text;

    Sensor light;
    SensorManager light_sm;
    TextView light_text;

    Sensor prox;
    SensorManager prox_sm;
    TextView prox_text;

    //TextView sensor_list;
    //SensorManager sensor_sm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accel_sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = accel_sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accel_sm.registerListener(this, accel, SensorManager.SENSOR_DELAY_UI);
        accel_text = (TextView) findViewById(R.id.accel);

        light_sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = light_sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        light_sm.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
        light_text = (TextView) findViewById(R.id.light);

        prox_sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        prox = prox_sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        prox_sm.registerListener(this, prox, SensorManager.SENSOR_DELAY_NORMAL);
        prox_text = (TextView) findViewById(R.id.prox_data);
/*
        sensor_list = (TextView) findViewById(R.id.sensor_ui);
        sensor_list.setVisibility(View.GONE);
        sensor_sm = (SensorManager) getSystemService(SENSOR_SERVICE);
*/

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //List<Sensor> mList = sensor_sm.getSensorList(Sensor.TYPE_ALL);
        accel_text.setText("Accelerometer" +
                "\nX:" + event.values[0] +
                "\nY:" + event.values[1] +
                "\nZ:" + event.values[2]);

        light_text.setText("Light sensor: " + (-100 * event.values[0]));

        prox_text.setText("Proximity sensor: " + (100 * event.values[0]));
/*
        //for (int i = 0; i < mList.size(); i++) {
            sensor_list.setVisibility(View.VISIBLE);
            sensor_list.setText("\n" + "Available sensors:"
                    + "\n" + mList.get(0).getName()
                    + "\n" + mList.get(1).getName()
                    + "\n" + mList.get(2).getName());
        //}
        */
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }


