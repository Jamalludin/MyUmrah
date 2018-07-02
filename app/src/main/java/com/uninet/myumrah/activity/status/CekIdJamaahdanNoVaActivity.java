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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CekIdJamaahdanNoVaActivity extends AbstracGenericActivity implements CekStatusView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_id_jamaahdan_no_va);

        statusPresenter = new CekStatusPresenter(this,getApplicationContext());
        statusPresenter.cekStatus();

        id_jamaah    = (TextView)findViewById(R.id.txt_idJamaahVA);
        nama_jamaah  = (TextView)findViewById(R.id.txt_namaJamaahVA);
        nik_jamaah   = (TextView)findViewById(R.id.txt_nomorIndukJamaahVA);
        noVa        = (TextView)findViewById(R.id.txt_noVa);
        statusVa    = (TextView)findViewById(R.id.txt_statusVA);
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

        nama_jamaah.setText(" : "+jamaah.getNamaLengkap());
        nik_jamaah.setText(" : "+jamaah.getNik());
        id_jamaah.setText(" : "+jamaah.getIdJamaah());
        noVa.setText(" : "+jamaah.getVa().getNamaVa());
    }
}
