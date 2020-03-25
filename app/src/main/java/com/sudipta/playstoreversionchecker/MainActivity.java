package com.sudipta.playstoreversionchecker;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;

import com.sudipta.versionchecker.PlayStoreVersionChecker;


public class MainActivity extends AppCompatActivity {
   PlayStoreVersionChecker playStoreVersionChecker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
       playStoreVersionChecker=new PlayStoreVersionChecker(MainActivity.this,getApplicationContext().getPackageName());
       playStoreVersionChecker.VersionChecker();

       getVersionFromPlayStore();

    }

    private void getVersionFromPlayStore() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String verSionCode= playStoreVersionChecker.getPlaystoreVersion();
                if (verSionCode.equals("")){
                    System.out.println("ssssssssss"+verSionCode);
                    getVersionFromPlayStore();
                }
                else {
                    System.out.println("ssssssssss"+verSionCode);
                }
              //  System.out.println("ssssssssss"+verSionCode);
            }
        },2000);
    }

}
