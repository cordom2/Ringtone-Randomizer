package com.example.cordom2.ringtonerandomizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

/**
 * Created by cordom2 on 10/24/2015.
 */
public class RingReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String callState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (callState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                RingtoneHelper.changeRingtone(context);
            }
        }
    }
}
