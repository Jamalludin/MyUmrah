package com.uninet.myumrah.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.oprasional.DataJamaahMeninggalActivity;
import com.uninet.myumrah.activity.oprasional.DataJamaahSakitActivity;
import com.uninet.myumrah.activity.oprasional.DataJamaahTersesatActivity;
import com.uninet.myumrah.activity.oprasional.DataKeberangkatanActivity;
import com.uninet.myumrah.activity.oprasional.DataKepulanganActivity;

public class MenuOperationalActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView verifikasiKeberangkatan;
    private CardView inputDataKepulangan;
    private CardView inputJamaahSakit;
    private CardView inputJamaahMeninggal;
    private CardView inputJamaahTersesat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_operational);

        verifikasiKeberangkatan = (CardView)findViewById(R.id.cardView_verifikasiKeberangkatan);
        inputDataKepulangan     = (CardView)findViewById(R.id.cardView_dataKepulangan);
        inputJamaahSakit        = (CardView)findViewById(R.id.cardView_inputJamaahSakit);
        inputJamaahMeninggal    = (CardView)findViewById(R.id.cardView_inputJamaahMeninggal);
        inputJamaahTersesat     = (CardView)findViewById(R.id.cardView_inputJamaahTersesat);

        verifikasiKeberangkatan.setOnClickListener(this);
        inputDataKepulangan.setOnClickListener(this);
        inputJamaahSakit.setOnClickListener(this);
        inputJamaahMeninggal.setOnClickListener(this);
        inputJamaahTersesat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_verifikasiKeberangkatan:
                startActivity(new Intent(this, DataKeberangkatanActivity.class));
                break;

            case R.id.cardView_dataKepulangan:
                startActivity(new Intent(this, DataKepulanganActivity.class));
                break;

            case R.id.cardView_inputJamaahSakit:
                startActivity(new Intent(this, DataJamaahSakitActivity.class));
                break;

            case R.id.cardView_inputJamaahMeninggal:
                startActivity(new Intent(this, DataJamaahMeninggalActivity.class));
                break;

            case R.id.cardView_inputJamaahTersesat:
                startActivity(new Intent(this, DataJamaahTersesatActivity.class));
                break;
        }
    }
}
