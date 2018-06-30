package com.uninet.myumrah.activity.approval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.model.Agen;
import com.uninet.myumrah.model.Approval;
import com.uninet.myumrah.model.Bank;
import com.uninet.myumrah.model.Cicilan;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.model.JamaahApproval;
import com.uninet.myumrah.model.JenisKelamin;
import com.uninet.myumrah.model.ListJamaah;
import com.uninet.myumrah.model.Paket;
import com.uninet.myumrah.model.StatusAktif;
import com.uninet.myumrah.model.StatusApproval;
import com.uninet.myumrah.model.User;
import com.uninet.myumrah.model.Va;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.util.JsonUtil;
import com.uninet.myumrah.view.ApprovalView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KoperasiApprovalActivity extends AbstracGenericActivity implements ApprovalView,View.OnClickListener{

    public static String NOMOR_REK;
    public static String ASSIGMENT;
    private Jamaah jamaah = new Jamaah();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koperasi_approval);

        Bundle extras   = getIntent().getExtras();
        IDJAMAAH        = extras.getString("idnya");

        tgl_registrasi  = (TextView) findViewById(R.id.tglDftr_bendahara);
        id_jamaah       = (TextView) findViewById(R.id.id_jamaah_bendahara);
        nama_jamaah     = (TextView) findViewById(R.id.nama_lengkap_jamaah_bendahara);
        nik_jamaah      = (TextView) findViewById(R.id.nip_jamaah_bendahara);
        hp_jamaah       = (TextView) findViewById(R.id.no_hp_jamaah_bendahara);
        jk_jamaah       = (TextView) findViewById(R.id.txt_jk_benda);
        agen_jamaah     = (TextView) findViewById(R.id.agen_bendahara);
        paket_jamaah    = (TextView) findViewById(R.id.txt_paketPB);
        cicilan_jamaah  = (TextView) findViewById(R.id.txt_cicil);
        periode         = (TextView) findViewById(R.id.txt_pcicil);
        berangkat       = (TextView) findViewById(R.id.txt_berangkatB);
        va_jamaah       = (TextView) findViewById(R.id.txt_vaBenda);
        bank_jamaah     = (TextView) findViewById(R.id.txt_bankBend);
        no_rek          = (EditText) findViewById(R.id.input_noRekB);
        assigment       = (EditText) findViewById(R.id.input_assmentB);
        setujuApproval  = (Button) findViewById(R.id.setuju_jamaah_benda);
        tolakApproval   = (Button) findViewById(R.id.tolak_jamaah_benda);

        setujuApproval.setOnClickListener(this);
        tolakApproval.setOnClickListener(this);

        approvalPresenter = new ApprovalPresenter(this, getApplicationContext());
        approvalPresenter.setDetailJamaah();
    }

    @Override
    public void listJamaah(String listJamah) {

    }

    @Override
    public void detailJamaah(String detailJamaah) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {

            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(detailJamaah).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

            Type type = new TypeToken<Jamaah>() {}.getType();
            jamaah = gson.fromJson(approval.get("data"), type);


        }catch (Exception e){
            e.printStackTrace();

        }

        String tglRegistrasi = format.format(jamaah.getTglDaftar());
        String tglBerangkat = format.format(jamaah.getPaket().getTglBerangkat());

        tgl_registrasi.setText(" : "+tglRegistrasi);
        id_jamaah.setText(" : "+jamaah.getIdCard());
        nama_jamaah.setText(" : "+jamaah.getNamaLengkap());
        nik_jamaah.setText(" : "+jamaah.getNik());
        hp_jamaah.setText(" : "+jamaah.getNoHp());
        jk_jamaah.setText(" : "+jamaah.getJenisKelamin().getNamaJenisKelamin());
        agen_jamaah.setText(" : "+jamaah.getAgen().getNamaAgen());
        paket_jamaah.setText(" : "+jamaah.getPaket().getNamaPaket());
        cicilan_jamaah.setText(" : "+jamaah.getCicilan().getNominalCicilan());
        periode.setText(" : "+jamaah.getCicilan().getLamaCicilan());
        berangkat.setText(" : "+tglBerangkat);
        va_jamaah.setText(" : "+jamaah.getVa().getNamaVa());
        bank_jamaah.setText(" : "+jamaah.getBank().getNamaBank());

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {
        Toast.makeText(this, ""+approvalJamaah, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateJamaah(String updateJamaah) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setuju_jamaah_benda:

                NOMOR_REK = no_rek.getText().toString();
                ASSIGMENT = assigment.getText().toString();
                JamaahApproval jamaahApproval = new JamaahApproval();
                jamaahApproval.setApproval(new Approval(2));
                jamaahApproval.setAssesmentKoperasi(ASSIGMENT);
                jamaahApproval.setTglApprovalKoperasi(new java.sql.Date(new Date().getTime()));
                jamaahApproval.setStatusApproval(new StatusApproval(2));
                jamaah.setNoRek(NOMOR_REK);
                jamaah.setJamaahApproval(jamaahApproval);
                jamaah.setStatusAktif(new StatusAktif(0));
                jamaah.setUser(new User());

                if (ASSIGMENT.equals("")){

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();

                }else if (NOMOR_REK.equals("")){

                    Toast.makeText(this, "Mohon Isi Nomor Rekening", Toast.LENGTH_SHORT).show();

                }else {

                    approvalPresenter.setUpdateJamaah(JsonUtil.toJson(jamaah));

                    /*pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();*/
                }

                break;

            case R.id.tolak_jamaah_benda:

                NOMOR_REK = no_rek.getText().toString();
                ASSIGMENT = assigment.getText().toString();
                JamaahApproval jamaahApproval1 = new JamaahApproval();
                jamaahApproval1.setApproval(new Approval(1));
                jamaahApproval1.setAssesmentKoperasi(ASSIGMENT);
                jamaahApproval1.setTglApprovalKoperasi(new java.sql.Date(new Date().getTime()));
                jamaahApproval1.setStatusApproval(new StatusApproval(0));
                jamaah.setNoRek(NOMOR_REK);
                jamaah.setJamaahApproval(jamaahApproval1);
                jamaah.setStatusAktif(new StatusAktif(0));
                jamaah.setUser(new User());

                if (ASSIGMENT.equals("")){

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();

                }else {

                    approvalPresenter.setUpdateJamaah(JsonUtil.toJson(jamaah));
                    /*pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();*/
                }

                break;
        }

    }
}
