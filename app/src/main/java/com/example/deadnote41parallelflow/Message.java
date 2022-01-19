package com.example.deadnote41parallelflow;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
    private String smsMessage;
    private String[] messageArray;



    public Message() {

    }


    public Message(String smsMessage, String[] messageArray) {
        this.smsMessage = smsMessage;
        this.messageArray = messageArray;
    }

    protected Message(Parcel in) {
        smsMessage = in.readString();
        messageArray = in.createStringArray();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(smsMessage);
        parcel.writeStringArray(messageArray);
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String[] getMessageArray() {
        return messageArray;
    }

    public void setMessageArray(String[] messageArray) {
        this.messageArray = messageArray;
    }
}
