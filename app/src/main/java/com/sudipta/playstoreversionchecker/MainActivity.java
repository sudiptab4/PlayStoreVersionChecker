package com.sudipta.playstoreversionchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sudipta.versionchecker.PlayStoreVersionChecker;


public class MainActivity extends AppCompatActivity {
    PlayStoreVersionChecker playStoreVersionChecker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playStoreVersionChecker=new PlayStoreVersionChecker(MainActivity.this);
        playStoreVersionChecker.VersionChecker("SUDIPTA");

    }
}
