package com.example.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // System sensor manager instance.
    private SensorManager mSensorManager;

    // Proximity and light sensors, as retrieved from the sensor manager.
    private Sensor mSensorProximity;
    private Sensor mSensorLight;
    private Sensor mSensorSuhu;
    private Sensor mSensorBarometer;
    private Sensor mSensorAccelerometer;
    private Sensor mSensorGyroscope;
    private Sensor mSensorMagnetometer;


    // TextViews to display current sensor values.
    private TextView mTextSensorLight;
    private TextView mTextSensorProximity;
    private TextView mTextSensorSuhu;
    private TextView mTextSensorBarometer;
    private TextView mTextSensorAccelerometer;
    private TextView mTextSensorGyroscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSensorLight = (TextView) findViewById(R.id.label_light);
        mTextSensorProximity = (TextView) findViewById(R.id.label_proximity);
        mTextSensorSuhu = (TextView) findViewById(R.id.label_suhu);
        mTextSensorBarometer = (TextView) findViewById(R.id.label_barometer);
        mTextSensorAccelerometer = (TextView) findViewById(R.id.label_accelerometer);
        mTextSensorGyroscope = (TextView) findViewById(R.id.label_gyroshope);

        mSensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);

        mSensorProximity = mSensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorSuhu = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorBarometer = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        String sensor_error = getResources().getString(R.string.error_no_sensor);

        if (mSensorLight == null) { mTextSensorLight.setText(sensor_error); }
        if (mSensorProximity == null) { mTextSensorProximity.setText(sensor_error); }
        if (mSensorSuhu == null) { mTextSensorSuhu.setText(sensor_error); }
        if (mSensorBarometer == null) { mTextSensorBarometer.setText(sensor_error); }
        if (mSensorAccelerometer == null) { mTextSensorAccelerometer.setText(sensor_error); }
        if (mSensorGyroscope == null) { mTextSensorGyroscope.setText(sensor_error); }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mSensorProximity != null) {
            mSensorManager.registerListener(this, mSensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorLight != null) {
            mSensorManager.registerListener(this, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorSuhu != null) {
            mSensorManager.registerListener(this, mSensorSuhu,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorBarometer != null) {
            mSensorManager.registerListener(this, mSensorBarometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorAccelerometer != null) {
            mSensorManager.registerListener(this, mSensorAccelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorGyroscope != null) {
            mSensorManager.registerListener(this, mSensorGyroscope,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorMagnetometer != null) {
            mSensorManager.registerListener(this, mSensorMagnetometer,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        int sensorType = sensorEvent.sensor.getType();

        float currentValue = sensorEvent.values[0];

        switch (sensorType) {

            case Sensor.TYPE_LIGHT:

                mTextSensorLight.setText(getResources().getString(
                        R.string.label_light, currentValue));
                break;
            case Sensor.TYPE_PROXIMITY:

                mTextSensorProximity.setText(getResources().getString(
                        R.string.label_proximity, currentValue));
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:

                mTextSensorSuhu.setText(getResources().getString(
                        R.string.label_suhu, currentValue));
                break;
            case Sensor.TYPE_PRESSURE:

                mTextSensorBarometer.setText(getResources().getString(
                        R.string.label_barometer, currentValue));
                break;
            case Sensor.TYPE_ACCELEROMETER:

                mTextSensorAccelerometer.setText(getResources().getString(
                        R.string.label_accelerometer, currentValue));
                break;
            case Sensor.TYPE_GYROSCOPE:

                mTextSensorGyroscope.setText(getResources().getString(
                        R.string.label_gyroscope, currentValue));
                break;
            default:

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}