package com.howdy.vehiclesearch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by jiteshdugar on 14/02/16.
 */
public class SMSManager extends BroadcastReceiver {
    private String TAG = SMSManager.class.getSimpleName();

    public SMSManager() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the data (SMS data) bound to intent
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;

        String str = "";

        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            // For every SMS message received
            for (int i=0; i < msgs.length; i++) {
                // Convert Object array
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                // Sender's phone number
                Log.d("source",msgs[i].getOriginatingAddress());
                if(msgs[i].getOriginatingAddress().equals("DM-VAAHAN")) {
                    str += "SMS from " + msgs[i].getOriginatingAddress() + " : ";
                    // Fetch the text message
                    str += msgs[i].getMessageBody().toString();
                    // Newline <img src="http://codetheory.in/wp-includes/images/smilies/simple-smile.png" alt=":-)" class="wp-smiley" style="height: 1em; max-height: 1em;">
                    str += "\n";
                    Log.d("SmsReceiver", str);
                    try {
                        VehicleDetails.getInstace().updateTheTextView(str);
                    } catch (Exception e) {

                    }
                }
            }

            // Display the entire SMS Message
            //Log.d(TAG, str);
        }
    }
}
