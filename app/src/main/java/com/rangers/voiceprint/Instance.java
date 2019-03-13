package com.rangers.voiceprint;

import android.os.Parcel;
import android.os.Parcelable;

public class Instance implements Parcelable {

    private String precision;
    private String infill;
    private String support;
    private String raft;

    public Instance() {

    }

    public Instance(String precision, String infill, String support, String raft) {
        this.precision = precision;
        this.infill = infill;
        this.support = support;
        this.raft = raft;
    }

    protected Instance(Parcel in) {
        precision = in.readString();
        infill = in.readString();
        support = in.readString();
        raft = in.readString();
    }

    //PARCELABLE------------------------------------------------------------------------------------
    public static final Creator<Instance> CREATOR = new Creator<Instance>() {
        @Override
        public Instance createFromParcel(Parcel in) {
            return new Instance(in);
        }

        @Override
        public Instance[] newArray(int size) {
            return new Instance[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(precision);
        dest.writeString(infill);
        dest.writeString(support);
        dest.writeString(raft);
    }

    //SETTERS---------------------------------------------------------------------------------------
    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public void setInfill(String infill) {
        this.infill = infill;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public void setRaft(String raft) {
        this.raft = raft;
    }

    //GETTERS---------------------------------------------------------------------------------------
    public String getPrecision() {
        return precision;
    }

    public String getInfill() {
        return infill;
    }

    public String getSupport() {
        return support;
    }

    public String getRaft() {
        return raft;
    }


}
