package com.akashsoam.sharedpreferences;

//import android.app.Application;
//import android.arch.persistence.room.Room;

import android.app.Application;

import androidx.room.Room;

import com.akashsoam.sharedpreferences.DbUtils.LocalDB;

public class RoomImplementation extends Application {
    private static RoomImplementation mInstance;
    private LocalDB dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        dbInstance = Room.databaseBuilder(getApplicationContext(), LocalDB.class, "LocalDB").build();
    }

    public static RoomImplementation getInstance() {
        return mInstance;
    }
    public LocalDB getDbInstance(){
        return dbInstance;
    }
}
