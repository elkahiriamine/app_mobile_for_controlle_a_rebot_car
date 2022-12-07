package com.carControle.carMobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryData extends AppCompatActivity {
    private ArrayAdapter arrayAdapter;
    private ArrayList<String> arrayList;
    private Datahistory datahistory;
    private  static String username;
    private static ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_data);
        Bundle bd = getIntent().getExtras();
        username =bd.getString("user_name").toString();
        listView = findViewById(R.id.list);
        datahistory = new Datahistory(getApplicationContext());
        arrayList = new ArrayList<>();

        Cursor cursor = datahistory.output_data(username);
        if(cursor.getCount() == 0){
              Toast.makeText(getApplicationContext(), "No data exist !", Toast.LENGTH_LONG).show();
          }

        while (cursor.moveToNext()){
                arrayList.add(adapter(cursor.getString(1)));
          }
        arrayAdapter = new ArrayAdapter<>(this , android.R.layout.test_list_item,arrayList);
            listView.setAdapter(arrayAdapter);
        }

        private String adapter(String str){
        String[] strAd = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("user name " + strAd[1]);
        stringBuffer.append(" \t time start :"+strAd[2] );
        stringBuffer.append("\t time finished : "+ strAd[3]);
        stringBuffer.append("\n action1 : "+strAd[4]);
        stringBuffer.append("\t action2 : "+strAd[5]);
        stringBuffer.append("\t action3 : "+strAd[6]);
        stringBuffer.append("\t action4 : "+strAd[7]);
        return stringBuffer.toString();
        }

    }
