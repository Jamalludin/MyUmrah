package com.uninet.myumrah.activity.login_aplikasi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uninet.myumrah.MainActivity;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.daftar_umroh.DaftarUmroh;
import com.uninet.myumrah.activity.daftar_umroh.DataPendukung;

public class SplashActivity extends AppCompatActivity {

    private static int timeout = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, Login.class);
                startActivity(intent);
                finish();

            }
        }, timeout);
    }
}
