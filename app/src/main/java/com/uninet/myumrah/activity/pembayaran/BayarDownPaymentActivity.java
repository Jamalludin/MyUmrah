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

public class BayarDownPaymentActivity extends AbstracGenericActivity implements BayarView,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_payment);

        idJamaah = (TextView)findViewById(R.id.txtIdJamaahBayarDP);
        namaJamaah = (TextView)findViewById(R.id.txtNamaJamaahBayarDP);
        nikJamaah = (TextView)findViewById(R.id.txtNomorIndukBayarDP);
        periode      = (TextView)findViewById(R.id.txt_lmCicilan);
        downpayment  = (TextView)findViewById(R.id.txtJumlahbayarBayarDP);
        bukanDP      = (TextView)findViewById(R.id.txt_bukanDP);
        prosesDP     = (TextView)findViewById(R.id.txt_menunngu_dp);
        blmDftr      = (TextView)findViewById(R.id.txt_blmDftrDp);
        btn_bayar    = (Button) findViewById(R.id.btn_bayarDP);
        cancel_Bayar = (Button)findViewById(R.id.btn_cancel_bayarDP);

        mainLayout   = (LinearLayout)this.findViewById(R.id.btn_layDP);
        bayarPresenter = new BayarPresenter(this, getApplicationContext());
        bayarPresenter.setDetaiTagihan();

        btn_bayar.setOnClickListener(this);
        cancel_Bayar.setOnClickListener(this);

        mainLayout.setVisibility(View.INVISIBLE);
        bukanDP.setVisibility(View.INVISIBLE);
        prosesDP.setVisibility(View.INVISIBLE);
        blmDftr.setVisibility(View.INVISIBLE);

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

        idJamaah.setText(" : "+jamaah.getIdCard());
        namaJamaah.setText(" : "+jamaah.getNamaLengkap());
        nikJamaah.setText(" : "+jamaah.getNik());
        hp_jamaah.setText(" : "+jamaah.getNoHp());
        downpayment.setText(" : "+jamaah.getDownPayment().getNominalDp());
        periode.setText(" : "+jamaah.getCicilan().getLamaCicilan());

    }

    @Override
    public void onClick(View v) {

    }
}
