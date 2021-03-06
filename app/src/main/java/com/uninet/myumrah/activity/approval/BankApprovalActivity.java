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
import com.uninet.myumrah.model.CommonModel;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.model.JamaahApproval;
import com.uninet.myumrah.model.Role;
import com.uninet.myumrah.model.StatusAktif;
import com.uninet.myumrah.model.StatusApproval;
import com.uninet.myumrah.model.User;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.view.ApprovalView;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.uninet.myumrah.activity.approval.KoperasiApprovalActivity.ASSIGMENT;
import static com.uninet.myumrah.util.DaftarUtil.ROLE_USER;

public class BankApprovalActivity extends AbstracGenericActivity implements ApprovalView, View.OnClickListener {

    private Jamaah jamaah = new Jamaah();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_approval);

        Bundle extras = getIntent().getExtras();
        IDJAMAAH = extras.getString("idnya");

        txtTglRegistrasi = (TextView) findViewById(R.id.tglDftr_bank);
        txtIdJamaah = (TextView) findViewById(R.id.id_jamaah_bank);
        txtNamaJamaah = (TextView) findViewById(R.id.nama_lengkap_jamaah_bank);
        txtNikJamaah = (TextView) findViewById(R.id.nip_jamaah_bank);
        txtHpJamaah = (TextView) findViewById(R.id.no_hp_jamaah_bank);
        txtJenisKelaminJamaah = (TextView) findViewById(R.id.txt_jk_bank);
        txtAgenJamaah = (TextView) findViewById(R.id.agen_bank);
        txtPaketJamaah = (TextView) findViewById(R.id.txt_paketBank);
        txtCicilanJamaah = (TextView) findViewById(R.id.txt_cicilBank);
        txtPeriode = (TextView) findViewById(R.id.txt_pcicilBank);
        txtBerangkat = (TextView) findViewById(R.id.txt_berangkatBank);
        txtVaJamaah = (TextView) findViewById(R.id.txt_vaBank);
        txtBankJamaah = (TextView) findViewById(R.id.txt_aBank);
        txtNoRek = (TextView) findViewById(R.id.txt_aRekBank);
        editTxtAssigment = (EditText) findViewById(R.id.input_assmentBank);

        setujuApproval = (Button) findViewById(R.id.setuju_jamaah_bank);
        tolakApproval = (Button) findViewById(R.id.tolak_jamaah_bank);

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

            Type type = new TypeToken<Jamaah>() {
            }.getType();
            jamaah = gson.fromJson(approval.get("data"), type);


        } catch (Exception e) {
            e.printStackTrace();

        }

        String tglRegistrasi = format.format(jamaah.getTglDaftar());
        String tglBerangkat = format.format(jamaah.getPaket().getTglBerangkat());

        txtTglRegistrasi.setText(" : " + tglRegistrasi);
        txtIdJamaah.setText(" : " + jamaah.getIdCard());
        txtNamaJamaah.setText(" : " + jamaah.getNamaLengkap());
        txtNikJamaah.setText(" : " + jamaah.getNik());
        txtHpJamaah.setText(" : " + jamaah.getNoHp());
        txtJenisKelaminJamaah.setText(" : " + jamaah.getJenisKelamin().getNamaJenisKelamin());
        txtAgenJamaah.setText(" : " + jamaah.getAgen().getNamaAgen());
        txtPaketJamaah.setText(" : " + jamaah.getPaket().getNamaPaket());
        txtCicilanJamaah.setText(" : " + jamaah.getCicilan().getNominalCicilan());
        txtPeriode.setText(" : " + jamaah.getCicilan().getLamaCicilan());
        txtBerangkat.setText(" : " + tglBerangkat);
        txtVaJamaah.setText(" : " + jamaah.getVa().getNamaVa());
        txtBankJamaah.setText(" : " + jamaah.getBank().getNamaBank());
        txtNoRek.setText(" : " + jamaah.getNoRek());

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {

    }

    @Override
    public void updateJamaah(String updateJamaah) {

        try {

            Gson gson = new Gson();
            CommonModel commonModel = gson.fromJson(updateJamaah, CommonModel.class);
            statusCode = commonModel.getStatus();
        } catch (Exception e) {

        }

        if (statusCode.equalsIgnoreCase("0013")) {
            startActivity(new Intent(BankApprovalActivity.this, JamaahApprovalActivity.class));
            Toast.makeText(this, R.string.success_update, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, R.string.failed_update, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setuju_jamaah_bank:

                ASSIGMENT = editTxtAssigment.getText().toString();

                jamaah.setStatusAktif(new StatusAktif(1));
                jamaah.setUser(new User(new Role(ROLE_USER)));

                JamaahApproval jamaahApproval = new JamaahApproval();
                jamaahApproval.setAssesmentBank(ASSIGMENT);
                jamaahApproval.setTglApprovalBank(new java.sql.Date(new Date().getTime()));
                jamaahApproval.setStatusApproval(new StatusApproval(1));
                jamaahApproval.setApproval(new Approval(2));
                jamaahApproval.setJamaah(jamaah);

                if (ASSIGMENT.equals("")) {

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();
                } else {

                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                    System.out.println(gson.toJson(jamaahApproval));
                    approvalPresenter.setUpdateJamaah(gson.toJson(jamaahApproval));
                    /*pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();*/

                }

                break;

            case R.id.tolak_jamaah_bank:

                ASSIGMENT = editTxtAssigment.getText().toString();

                jamaah.setStatusAktif(new StatusAktif(0));
                jamaah.setUser(new User(new Role(ROLE_USER)));

                JamaahApproval jamaahApproval1 = new JamaahApproval();
                jamaahApproval1.setApproval(new Approval(3));
                jamaahApproval1.setAssesmentBank(ASSIGMENT);
                jamaahApproval1.setTglApprovalBank(new java.sql.Date(new Date().getTime()));
                jamaahApproval1.setStatusApproval(new StatusApproval(2));
                jamaahApproval1.setJamaah(jamaah);

                if (ASSIGMENT.equals("")) {

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();
                } else {

                    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                    approvalPresenter.setUpdateJamaah(gson.toJson(jamaahApproval1));
                    /*pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();*/
                }

                break;
        }
    }
}
