package com.sudipta.versionchecker;

import android.content.Context;
import android.widget.Toast;

public class PlayStoreVersionChecker {

    Context c;

     public PlayStoreVersionChecker(Context c){
        this.c=c;
    }

    public void VersionChecker(String message){

        Toast.makeText(c,message,Toast.LENGTH_SHORT).show();

    }
}
