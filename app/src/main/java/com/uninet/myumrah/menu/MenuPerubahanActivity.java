package com.uninet.myumrah.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.perubahan.LinkKeluargaActivity;
import com.uninet.myumrah.activity.perubahan.PenggantianJamaahActivity;

public class MenuPerubahanActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView perubahanLinkKeluarga;
    private CardView perubahanJamaah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_perubahan);

        perubahanLinkKeluarga = (CardView)findViewById(R.id.cardView_rubahLinkKeluarga);
        perubahanJamaah       = (CardView)findViewById(R.id.cardView_rubahJamaah);

        perubahanLinkKeluarga.setOnClickListener(this);
        perubahanJamaah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_rubahLinkKeluarga:
                startActivity(new Intent(this, LinkKeluargaActivity.class));
                break;
            case R.id.cardView_rubahJamaah:
                startActivity(new Intent(this, PenggantianJamaahActivity.class));
                break;
        }
    }
}
