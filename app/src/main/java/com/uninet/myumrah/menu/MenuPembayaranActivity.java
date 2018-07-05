package com.uninet.myumrah.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.pembayaran.BayarBelanjaActivity;
import com.uninet.myumrah.activity.pembayaran.BayarDownPaymentActivity;
import com.uninet.myumrah.activity.pembayaran.BayarFullPaymentActivity;

public class MenuPembayaranActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView membayarDownpayment;
    private CardView membayarFullPayment;
    private CardView membayarBelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pembayaran);

        membayarDownpayment = (CardView)findViewById(R.id.cardView_membayarDP);
        membayarFullPayment = (CardView)findViewById(R.id.cardView_membayarFP);
        membayarBelanja     = (CardView)findViewById(R.id.cardView_membayarBelanja);

        membayarDownpayment.setOnClickListener(this);
        membayarFullPayment.setOnClickListener(this);
        membayarBelanja.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_membayarDP:
                startActivity(new Intent(this, BayarDownPaymentActivity.class));
                break;
            case R.id.cardView_membayarFP:
                startActivity(new Intent(this, BayarFullPaymentActivity.class));
                break;
            case R.id.cardView_membayarBelanja:
                startActivity(new Intent(this, BayarBelanjaActivity.class));
                break;
        }
    }
}
