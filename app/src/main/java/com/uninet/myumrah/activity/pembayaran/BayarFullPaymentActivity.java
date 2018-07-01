package com.uninet.myumrah.activity.pembayaran;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.presenter.BayarPresenter;
import com.uninet.myumrah.view.BayarView;

import java.lang.reflect.Type;

public class BayarFullPaymentActivity extends AbstracGenericActivity implements BayarView,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_payment);

        id_jamaah    = (TextView)findViewById(R.id.txtIdJamaahBayarFP);
        nama_jamaah  = (TextView)findViewById(R.id.txtNamaJamaahBayarFP);
        nik_jamaah   = (TextView)findViewById(R.id.txtNomorIndukBayarFP);
        totalBayar   = (TextView)findViewById(R.id.txtJumlahbayarBayarFP);
        bukanDP      = (TextView)findViewById(R.id.txt_bukanFP);
        prosesDP     = (TextView)findViewById(R.id.txt_menunngu_fp);
        blmDftr      = (TextView)findViewById(R.id.txt_blmDftrFp);
        btn_bayar    = (Button) findViewById(R.id.btn_bayarFP);
        cancel_Bayar = (Button)findViewById(R.id.btn_cancel_bayarFP);
        mainLayout   = (LinearLayout)this.findViewById(R.id.btn_layFP);

        mainLayout.setVisibility(View.INVISIBLE);
        bukanDP.setVisibility(View.INVISIBLE);
        prosesDP.setVisibility(View.INVISIBLE);
        blmDftr.setVisibility(View.INVISIBLE);

        bayarPresenter = new BayarPresenter(this, getApplicationContext());
        bayarPresenter.setDetaiTagihan();

        btn_bayar.setOnClickListener(this);
        cancel_Bayar.setOnClickListener(this);
    }

    @Override
    public void detailTagihan(String tagihan) {

        Jamaah jamaah = new Jamaah();

        try {

            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(tagihan).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

            Type type = new TypeToken<Jamaah>() {}.getType();
            jamaah = gson.fromJson(approval.get("data"), type);


        }catch (Exception e){
            e.printStackTrace();

        }

        id_jamaah.setText(" : "+jamaah.getIdCard());
        nama_jamaah.setText(" : "+jamaah.getNamaLengkap());
        nik_jamaah.setText(" : "+jamaah.getNik());
        hp_jamaah.setText(" : "+jamaah.getNoHp());
        totalBayar.setText(" : "+jamaah.getDownPayment().getNominalDp());


    }

    @Override
    public void onClick(View v) {

    }
}
