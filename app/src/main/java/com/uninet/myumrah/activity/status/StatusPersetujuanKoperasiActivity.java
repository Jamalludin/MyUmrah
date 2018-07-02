package com.uninet.myumrah.activity.status;

import android.os.Bundle;
import android.widget.RelativeLayout;
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

public class StatusPersetujuanKoperasiActivity extends AbstracGenericActivity implements CekStatusView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_persetujuan_koperasi);

        statusPresenter = new CekStatusPresenter(this,getApplicationContext());
        statusPresenter.cekStatus();

        nama_jamaah       = (TextView)findViewById(R.id.txt_cekBendaName);
        nik_jamaah        = (TextView)findViewById(R.id.txt_nikCekBenda);
        jenisBayar        = (TextView)findViewById(R.id.txt_jnsBayarBenda);
        tglApproval       = (TextView)findViewById(R.id.txt_tglApproBen);
        assigmentApproval = (TextView)findViewById(R.id.txt_assigBend);
        rLayout           = (RelativeLayout)this.findViewById(R.id.rLetave);
    }

    @Override
    public void statusView(String approvalStatus) {

        Jamaah jamaah = new Jamaah();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {

            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(approvalStatus).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

            Type type = new TypeToken<Jamaah>() {}.getType();
            jamaah = gson.fromJson(approval.get("data"), type);


        }catch (Exception e){
            e.printStackTrace();

        }

        String tglApprovalKoperasi = format.format(jamaah.getJamaahApproval().getTglApprovalKoperasi());
        nama_jamaah.setText(" : "+jamaah.getNamaLengkap());
        nik_jamaah.setText(" : "+jamaah.getNik());
        jenisBayar.setText(" : "+jamaah.getJenisBayar().getNamaJenisBayar());
        tglApproval.setText(" : "+tglApprovalKoperasi);
        assigmentApproval.setText(" : "+jamaah.getJamaahApproval().getAssesmentKoperasi());
    }
}
