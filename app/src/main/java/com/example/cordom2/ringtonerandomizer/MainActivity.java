package com.example.cordom2.ringtonerandomizer;

import android.app.Activity;
import android.media.Ringtone;
import android.os.Bundle;
import android.widget.ListView;
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

    }

}
