package com.carControle.carMobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrintDevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);

        // Instantiate RecyclerView
        RecyclerView recyclerView = findViewById(R.id.deviceList);

        // Initialize Bluetooth adapter
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Fetch the list from Android device's cache
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        List<Object> deviceList = new ArrayList<>();
        for (BluetoothDevice device : pairedDevices){
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress();
            DeviceInfo deviceInfo = new DeviceInfo(deviceName,deviceHardwareAddress);
            deviceList.add(deviceInfo);
        }

        // Setting Up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Connecting to Data Source and Content Layout
        // Data source is the list of Bluetooth devices that are paired with Android Device
       Bundle bd = getIntent().getExtras();
        ListAdapter listAdapter = new ListAdapter(this,deviceList);
        ListAdapter.name_user=bd.getString("user_name").toString();
        recyclerView.setAdapter(listAdapter);


    }
}