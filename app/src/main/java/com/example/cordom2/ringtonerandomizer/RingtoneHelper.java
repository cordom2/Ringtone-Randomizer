package com.example.cordom2.ringtonerandomizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cordom2 on 10/20/2015.
 */
public class RingtoneHelper {

    //fetchAvailableRingtones should find all available ringtones on the device
    //and return a list of ringtone objects
    public static List<Ringtone> fetchAvailableRingtones(Context context){

        List<Ringtone> ringtones = new ArrayList<>();
        RingtoneManager mgr = new RingtoneManager(context);
        mgr.setType(RingtoneManager.TYPE_RINGTONE);

        int n = mgr.getCursor().getCount();
        for(int i=0;i<n;i++){
            ringtones.add(mgr.getRingtone(i));
        }

        return  ringtones;
    }

    //changeRingtone function is what actually changes the device's currently active ringtone
    public static void changeRingtone(Context context) {

        SharedPreferences preferences = context.getSharedPreferences("randomizer", Context.MODE_PRIVATE);
        if (!preferences.getBoolean("active", false))
            return;

    }
}
