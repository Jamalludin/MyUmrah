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

public class StatusPersetujuanTravelActivity extends AbstracGenericActivity implements CekStatusView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_persetujuan_travel);

        statusPresenter = new CekStatusPresenter(this,getApplicationContext());
        statusPresenter.cekStatus();

        txtNamaJamaah = (TextView)findViewById(R.id.txt_cekTravName);
        txtNikJamaah = (TextView)findViewById(R.id.txt_nikCekTrav);
        jenisBayar          = (TextView)findViewById(R.id.txt_jnsBayarTrav);
        tglApproval         = (TextView)findViewById(R.id.txt_tglApproTrav);
        assigmentApproval   = (TextView)findViewById(R.id.txt_assigTrav);
        rLayout             = (RelativeLayout)this.findViewById(R.id.rLetaveTrav);
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

        String tglApprovalMyumroh = format.format(jamaah.getJamaahApproval().getTglApprovalMyumroh());
        txtNamaJamaah.setText(" : "+jamaah.getNamaLengkap());
        txtNikJamaah.setText(" : "+jamaah.getNik());
        jenisBayar.setText(" : "+jamaah.getJenisBayar().getNamaJenisBayar());
        tglApproval.setText(" : "+tglApprovalMyumroh);
        assigmentApproval.setText(" : "+jamaah.getJamaahApproval().getAssesmentMyumroh());
    }
}
