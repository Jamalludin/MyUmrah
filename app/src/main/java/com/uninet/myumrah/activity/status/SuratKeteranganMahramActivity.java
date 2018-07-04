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

public class SuratKeteranganMahramActivity extends AbstracGenericActivity implements CekStatusView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_keterangan_mahram);

        statusPresenter = new CekStatusPresenter(this,getApplicationContext());
        statusPresenter.cekStatus();

        idJamaah = (TextView)findViewById(R.id.txt_idJamaah_ketMahram);
        namaJamaah = (TextView)findViewById(R.id.txt_namaJamaah_ketMahram);
        nikJamaah = (TextView)findViewById(R.id.txt_nomorIndukJamaah_ketMahram);
        status = (TextView)findViewById(R.id.txt_status_ketMahram);
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

        namaJamaah.setText(" : "+jamaah.getNamaLengkap());
        nikJamaah.setText(" : "+jamaah.getNik());
        idJamaah.setText(" : "+jamaah.getIdJamaah());

    }
}
