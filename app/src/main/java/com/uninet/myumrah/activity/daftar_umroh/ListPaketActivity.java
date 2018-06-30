package com.uninet.myumrah.activity.daftar_umroh;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.adapter.PaketAdapter;
import com.uninet.myumrah.model.Paket;
import com.uninet.myumrah.presenter.list_paket.BankPresenter;
import com.uninet.myumrah.presenter.list_paket.CaraBayarPresenter;
import com.uninet.myumrah.presenter.list_paket.InstansiPresenter;
import com.uninet.myumrah.presenter.list_paket.LamaHariPresenter;
import com.uninet.myumrah.presenter.list_paket.PaketPresenter;
import com.uninet.myumrah.view.ListPaketView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static com.uninet.myumrah.util.DaftarUtil.BANK;
import static com.uninet.myumrah.util.DaftarUtil.BANKID;
import static com.uninet.myumrah.util.DaftarUtil.BAYAR;
import static com.uninet.myumrah.util.DaftarUtil.BAYAR_ID;
import static com.uninet.myumrah.util.DaftarUtil.BULAN;
import static com.uninet.myumrah.util.DaftarUtil.INSTANSI;
import static com.uninet.myumrah.util.DaftarUtil.INSTANSI_ID;
import static com.uninet.myumrah.util.DaftarUtil.LAMA;
import static com.uninet.myumrah.util.DaftarUtil.MINGGU;
import static com.uninet.myumrah.util.DaftarUtil.TAHUN;


public class ListPaketActivity extends AbstracGenericActivity implements ListPaketView, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_paket);

        mRecyclerView   = (RecyclerView) findViewById(R.id.list_paket);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        lamaHariPresenter = new LamaHariPresenter(this, getApplicationContext());
        lamaHariPresenter.setLamaHari();

        instansiPresenter = new InstansiPresenter(this, getApplicationContext());
        instansiPresenter.setInstansi();

        caraBayarPresenter = new CaraBayarPresenter(this, getApplicationContext());
        caraBayarPresenter.setCaraBayar();

        paketPresenter = new PaketPresenter(this,getApplicationContext());

        bankPresenter = new BankPresenter(this, getApplicationContext());

        tahunPaket.clear();
        tahunPaket.add("--Pilih--");
        montPaket.clear();
        montPaket.add("--Pilih--");
        weekPaket.clear();
        weekPaket.add("--Pilih--");

        lamaPerjalanan = (Spinner) findViewById(R.id.spinner_lamaPerjalanan);
        tahunPaketSpin = (Spinner) findViewById(R.id.spinner_tahun);
        bulanPaketSpin = (Spinner) findViewById(R.id.spinner_bulan);
        weekPakerSpin  = (Spinner) findViewById(R.id.spinner_minggu);
        caraBayar      = (Spinner) findViewById(R.id.spinner_caraBayar);
        bankListSpin   = (Spinner) findViewById(R.id.spinner_bankBayar);
        instansiList   = (Spinner) findViewById(R.id.spinner_isntansi);
        cariPaket      = (Button) findViewById(R.id.btn_cariPaket);

        lamaPerjalanan.setOnItemSelectedListener(this);
        tahunPaketSpin.setOnItemSelectedListener(this);
        bulanPaketSpin.setOnItemSelectedListener(this);
        weekPakerSpin.setOnItemSelectedListener(this);
        caraBayar.setOnItemSelectedListener(this);
        bankListSpin.setOnItemSelectedListener(this);
        instansiList.setOnItemSelectedListener(this);

        super.tahunPaket();
        super.weekPaket();

        tahunPaketSpin.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, tahunPaket));
        weekPakerSpin.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, weekPaket));

        ArrayAdapter<CharSequence> adapter_ubah = ArrayAdapter.createFromResource(this, R.array.mont, android.R.layout.simple_spinner_item);
        adapter_ubah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bulanPaketSpin.setAdapter(adapter_ubah);

        cariPaket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paketPresenter.onValidasi(LAMA,TAHUN,BULAN,MINGGU,BAYAR,INSTANSI,BANK);

            }
        });


    }

    @Override
    public void lamaHari(String hari) {

        lamaJalan.clear();
        lamaJalan.add("--Pilih--");

        try {
            JSONObject lamaObj = new JSONObject(hari);
            JSONArray lamaArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < lamaArray.length(); i++) {
                JSONObject hariObj = lamaArray.getJSONObject(i);
                lamaJalan.add(hariObj.getString("hariPaket"));
            }

            lamaPerjalanan.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, lamaJalan));

        } catch (Exception e) {


        }
    }

    @Override
    public void caraBayar(String bayar) {

        bayarPaket.clear();
        bayarPaket.add("--Pilih--");

        try {
            JSONObject bayarObj = new JSONObject(bayar);
            bayarId = bayarObj.getJSONArray("data");

            for (int i = 0; i < bayarId.length(); i++) {
                JSONObject hariObj = bayarId.getJSONObject(i);
                bayarPaket.add(hariObj.getString("namaJenisBayar"));
            }

            caraBayar.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, bayarPaket));

        }catch (Exception e){

        }
    }

    @Override
    public void instansiList(String instansi) {

        instanList.clear();
        instanList.add("--Pilih--");

        try {
            JSONObject instanObj = new JSONObject(instansi);
            instansiId = instanObj.getJSONArray("data");

            for (int i = 0; i < instansiId.length(); i++) {
                JSONObject objInstan = instansiId.getJSONObject(i);
                instanList.add(objInstan.getString("namaInstansi"));

            }

            instansiList.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, instanList));

        } catch (Exception e) {


        }
    }

    @Override
    public void bankList(String bank) {

        bankList.clear();
        bankList.add("--Pilih--");

        try {
            JSONObject instanObj = new JSONObject(bank);
            bankId = instanObj.getJSONArray("data");

            for (int i = 0; i < bankId.length(); i++) {
                JSONObject objInstan = bankId.getJSONObject(i);
                bankList.add(objInstan.getString("namaBank"));

            }
            bankListSpin.setAdapter(new ArrayAdapter<String>(ListPaketActivity.this, android.R.layout.simple_spinner_dropdown_item, bankList));

        }catch (Exception e){


        }

    }

    @Override
    public void paketList(String paketList) {

        List<Paket> resutlNew = new ArrayList<>();

        try {

            JsonParser parser = new JsonParser();
            JsonObject o = parser.parse(paketList).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

            Type listType = new TypeToken<List<Paket>>() {}.getType();
            resutlNew = gson.fromJson(o.get("data"), listType);

        }catch (Exception e){

        }

        mAdapter = new PaketAdapter(resutlNew);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onValidasiSucces(String message) {

        paketPresenter.setPaket();
    }

    @Override
    public void onValidasiError(String message) {
        Toasty.error(ListPaketActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        String item = spinner.getSelectedItem().toString();

        if (spinner.getId() == R.id.spinner_isntansi) {

            if (item.equals("--Pilih--")){

                INSTANSI_ID = null;
                bankList.clear();
                bankList.add("--Pilih--");

            }else {

                INSTANSI_ID = getIdInstansi(position-1).toString();
                bankPresenter.setBank();
            }

        }else if (spinner.getId() == R.id.spinner_lamaPerjalanan){
            LAMA = spinner.getSelectedItem().toString();

        }else if (spinner.getId() == R.id.spinner_tahun){
            TAHUN = spinner.getSelectedItem().toString();

        }else if (spinner.getId() == R.id.spinner_bulan){
            BULAN = String.valueOf(spinner.getSelectedItemPosition());


        }else if (spinner.getId() == R.id.spinner_minggu){
            MINGGU = String.valueOf(spinner.getSelectedItemPosition());


        }else if (spinner.getId() == R.id.spinner_bankBayar){

            if (item.equals("--Pilih--")){

                BANK = null;
            }else {

                BANK = item;
                BANKID = getIdBank(position-1).toString();

            }


        }else {

            BAYAR = item;
            BAYAR_ID = getIdBayar(position-1).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
