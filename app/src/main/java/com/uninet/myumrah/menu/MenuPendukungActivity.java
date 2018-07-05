package com.uninet.myumrah.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.pendukung.DoaUmrohActivity;

public class MenuPendukungActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView shareLokasi;
    private CardView doa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pendukung);

        shareLokasi = (CardView)findViewById(R.id.cardView_shareLoc);
        doa         = (CardView)findViewById(R.id.cardView_doa);

        shareLokasi.setOnClickListener(this);
        doa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_shareLoc:
                //startActivity(new Intent(this, ));
                break;
            case R.id.cardView_doa:
                startActivity(new Intent(this, DoaUmrohActivity.class));
                break;
        }
    }
}
