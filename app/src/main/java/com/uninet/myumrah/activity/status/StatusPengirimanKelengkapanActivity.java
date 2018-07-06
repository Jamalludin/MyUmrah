package com.uninet.myumrah.activity.status;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.presenter.CekStatusPresenter;
import com.uninet.myumrah.view.CekStatusView;

import java.lang.reflect.Type;

public class StatusPengirimanKelengkapanActivity extends AbstracGenericActivity implements CekStatusView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_pengiriman_kelengkapan);

        statusPresenter = new CekStatusPresenter(this,getApplicationContext());
        statusPresenter.cekStatus();

        txtIdJamaah = (TextView)findViewById(R.id.txt_idJamaah_pengiriman);
        txtNamaJamaah = (TextView)findViewById(R.id.txt_namaJamaah_pengiriman);
        txtNikJamaah = (TextView)findViewById(R.id.txt_nomorIndukJamaah_pengiriman);
        status = (TextView)findViewById(R.id.txt_status_visa);
    }

    @Override
    public void statusView(String approvalStatus) {

        Jamaah jamaah = new Jamaah();

        try {

            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(approvalStatus).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

            Type type = new TypeToken<Jamaah>() {}.getType();
            jamaah = gson.fromJson(approval.get("data"), type);


        }catch (Exception e){
            e.printStackTrace();

        }

        txtNamaJamaah.setText(" : "+jamaah.getNamaLengkap());
        txtNikJamaah.setText(" : "+jamaah.getNik());
        txtIdJamaah.setText(" : "+jamaah.getIdJamaah());

    }
}
