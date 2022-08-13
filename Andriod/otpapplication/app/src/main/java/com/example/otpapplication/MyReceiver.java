package com.example.otpapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class MyReceiver extends BroadcastReceiver {

    private static EditText editOTP;


    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage smsMessage:smsMessages)
        {
            String messageBody = smsMessage.getMessageBody();
            String  getOTP = messageBody.split(":")[1];
            editOTP.setText(getOTP);
        }
    }
    public void setEditOTP(EditText editText) {MyReceiver.editOTP=editText;}
}