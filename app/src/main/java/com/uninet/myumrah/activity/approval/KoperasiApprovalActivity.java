package com.uninet.myumrah.activity.approval;

import android.content.Intent;
import android.os.Bundle;
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
import com.uninet.myumrah.model.Approval;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.model.JamaahApproval;
import com.uninet.myumrah.model.StatusAktif;
import com.uninet.myumrah.model.StatusApproval;
import com.uninet.myumrah.model.User;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.util.JsonUtil;
import com.uninet.myumrah.view.ApprovalView;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        tglRegistrasi = (TextView) findViewById(R.id.tglDftr_bendahara);
        idJamaah = (TextView) findViewById(R.id.id_jamaah_bendahara);
        namaJamaah = (TextView) findViewById(R.id.nama_lengkap_jamaah_bendahara);
        nikJamaah = (TextView) findViewById(R.id.nip_jamaah_bendahara);
        hpJamaah = (TextView) findViewById(R.id.no_hp_jamaah_bendahara);
        jenisKelaminJamaah = (TextView) findViewById(R.id.txt_jk_benda);
        agenJamaah = (TextView) findViewById(R.id.agen_bendahara);
        paketJamaah = (TextView) findViewById(R.id.txt_paketPB);
        cicilanJamaah = (TextView) findViewById(R.id.txt_cicil);
        periode         = (TextView) findViewById(R.id.txt_pcicil);
        berangkat       = (TextView) findViewById(R.id.txt_berangkatB);
        vaJamaah = (TextView) findViewById(R.id.txt_vaBenda);
        bankJamaah = (TextView) findViewById(R.id.txt_bankBend);
        noRekening = (EditText) findViewById(R.id.input_noRekB);
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

        this.tglRegistrasi.setText(" : "+tglRegistrasi);
        idJamaah.setText(" : "+jamaah.getIdCard());
        namaJamaah.setText(" : "+jamaah.getNamaLengkap());
        nikJamaah.setText(" : "+jamaah.getNik());
        hpJamaah.setText(" : "+jamaah.getNoHp());
        jenisKelaminJamaah.setText(" : "+jamaah.getJenisKelamin().getNamaJenisKelamin());
        agenJamaah.setText(" : "+jamaah.getAgen().getNamaAgen());
        paketJamaah.setText(" : "+jamaah.getPaket().getNamaPaket());
        cicilanJamaah.setText(" : "+jamaah.getCicilan().getNominalCicilan());
        periode.setText(" : "+jamaah.getCicilan().getLamaCicilan());
        berangkat.setText(" : "+tglBerangkat);
        vaJamaah.setText(" : "+jamaah.getVa().getNamaVa());
        bankJamaah.setText(" : "+jamaah.getBank().getNamaBank());

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

                NOMOR_REK = noRekening.getText().toString();
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

                NOMOR_REK = noRekening.getText().toString();
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
                    startActivity(new Intent(KoperasiApprovalActivity.this, JamaahApproval.class));
                    finish();
                    /*pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();*/
                }

                break;
        }

    }
}
