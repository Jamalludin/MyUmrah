package com.uninet.myumrah.activity.daftar_umroh;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.adapter.CicilanAdapter;
import com.uninet.myumrah.model.Cicilan;
import com.uninet.myumrah.model.Talangan;
import com.uninet.myumrah.presenter.DownPaymentPresenter;
import com.uninet.myumrah.view.CicilanPaketView;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.uninet.myumrah.util.DaftarUtil.HARGA_PAKET;
import static com.uninet.myumrah.util.DaftarUtil.IDDP;
import static com.uninet.myumrah.util.DaftarUtil.TALANGAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.TOTAL_TALANGAN;

public class CicilanPaketActivity extends AbstracGenericActivity implements CicilanPaketView {

    public DecimalFormat formatter = new DecimalFormat("#,###");
    public static String item;
    private Talangan tangalanBank = new Talangan();
    private ImageView imgCekPaket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cicilan_paket);

        imgCekPaket = (ImageView)findViewById(R.id.img_cekCicilan);
        imgCekPaket.setVisibility(View.GONE);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_dp);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        downPaymentPresenter = new DownPaymentPresenter(this, getApplicationContext());
        downPaymentPresenter.setDownPayment();

        hargaPaket      = (TextView) findViewById(R.id.hrgPaket);
        dpNominal       = (TextView) findViewById(R.id.totalDP);
        totalTalangan   = (TextView) findViewById(R.id.nilaiTalangan);

        downPaymentListSpin = (Spinner) findViewById(R.id.spinnerDP);
        downPaymentListSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Spinner spinner = (Spinner) parent;
                item = spinner.getSelectedItem().toString();

                IDDP = getIdDownpaymetn(position).toString();

                hargaPaket.setText(" : " + " Rp." + formatter.format(Double.parseDouble(HARGA_PAKET)) + " - ");
                dpNominal.setText(formatter.format(Double.parseDouble(item)));

                talangan();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void talangan() {

        TOTAL_TALANGAN = Double.parseDouble(HARGA_PAKET) - Double.parseDouble(item);
        totalTalangan.setText(" : " + " Rp." + formatter.format(TOTAL_TALANGAN));
        downPaymentPresenter.setTalangan();

    }

    @Override
    public void listDownPayment(String downPayment) {

        dpList.clear();

        try {
            JSONObject dpObj = new JSONObject(downPayment);
            downPaymentArr = dpObj.getJSONArray("data");
            for (int i = 0; i < downPaymentArr.length(); i++) {
                JSONObject objDp = downPaymentArr.getJSONObject(i);
                dpList.add(objDp.getDouble("nominalDp"));
            }

            downPaymentListSpin.setAdapter(new ArrayAdapter<Double>(CicilanPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, dpList));

        } catch (Exception e) {


        }

    }

    @Override
    public void listCicilan(String listCicil) {

        List<Cicilan> cicilans = new ArrayList<>();

        try {
            JSONObject objCicil = new JSONObject(listCicil);
            cicilanArr = objCicil.getJSONArray("data");

            for (int i = 0; i < cicilanArr.length(); i++) {

                JSONObject object = cicilanArr.getJSONObject(i);
                Cicilan cicil = new Cicilan();
                BigDecimal cicilan = new BigDecimal(object.getInt("nominalCicilan"));
                cicil.setNominalCicilan(cicilan);
                cicil.setLamaCicilan(object.getInt("lamaCicilan"));
                cicil.setIdCicilan(object.getInt("idCicilan"));

                cicilans.add(cicil);
            }
        } catch (Exception e) {


        }

        if (cicilans.isEmpty()){
            imgCekPaket.setVisibility(View.VISIBLE);

        }else {
            imgCekPaket.setVisibility(View.GONE);
        }

        mAdapter = new CicilanAdapter(cicilans);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void listTalangan(String talangan) {

        try {
            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(talangan).getAsJsonObject();
            Gson gson = new Gson();

            Type type = new TypeToken<Talangan>() {}.getType();
            tangalanBank = gson.fromJson(approval.get("data"), type);

        } catch (Exception e) {

        }

        Log.i("talanganID",String.valueOf(tangalanBank.getIdTalangan()));
        TALANGAN_ID = String.valueOf(tangalanBank.getIdTalangan());
        downPaymentPresenter.setCicilan();
    }

}
