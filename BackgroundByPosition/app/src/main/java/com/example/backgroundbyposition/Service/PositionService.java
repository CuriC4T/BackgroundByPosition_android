package com.example.backgroundbyposition.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.backgroundbyposition.R;

public class PositionService extends Service {
    private Location location;
    private double latitude;
    private double longitude;
    private LocationManager locationManager;

    public PositionService(){}
    public PositionService(Context context) {
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent ==null){
            Log.d("asdasd","asdddddddddd");

            //return START_STICKY;
        }else{

        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void getPosition(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
