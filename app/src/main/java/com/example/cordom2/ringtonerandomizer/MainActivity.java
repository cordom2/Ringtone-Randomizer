package com.example.cordom2.ringtonerandomizer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by cordom2 on 10/20/2015.
 */
public class MainActivity extends Activity {

    private List<Ringtone> ringtones;
    private ListView listOfRingtones;
    private ToggleButton toggleRandomizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        listOfRingtones = (ListView)findViewById(R.id.list_of_ringtones);
        toggleRandomizer = (ToggleButton)findViewById(R.id.toggle);

        ringtones = RingtoneHelper.fetchAvailableRingtones(this);
        initializeList();
        initializeToggle();

    }

    private void initializeToggle() {
        final SharedPreferences preferences = getSharedPreferences("randomizer", Context.MODE_PRIVATE);
        boolean active = preferences.getBoolean("active", false);
        toggleRandomizer.setChecked(active);

        toggleRandomizer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences.edit().putBoolean("active", isChecked).commit();
            }
        });
    }

    private void initializeList() {
        ArrayAdapter<Ringtone> adapter = new ArrayAdapter<Ringtone>(this,
                android.R.layout.simple_list_item_1, ringtones) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView item = (TextView)super.getView(position, convertView, parent);
                item.setText(ringtones.get(position).getTitle(MainActivity.this));
                return item;
            }
        };

        listOfRingtones.setAdapter(adapter);
    }


}
