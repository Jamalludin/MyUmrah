package com.uninet.myumrah.activity.approval;

import android.support.v7.app.AppCompatActivity;
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
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.view.ApprovalView;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.uninet.myumrah.activity.approval.KoperasiApproval.ASSIGMENT;

public class MyUmrahApproval extends AbstracGenericActivity implements ApprovalView,View.OnClickListener {

    private Jamaah jamaah = new Jamaah();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_umrah_approval);

        Bundle extras   = getIntent().getExtras();
        IDJAMAAH        = extras.getString("idnya");

        tgl_registrasi    = (TextView)findViewById(R.id.tglDftr_travel);
        id_jamaah         = (TextView)findViewById(R.id.id_jamaah_travel);
        nama_jamaah       = (TextView)findViewById(R.id.nama_lengkap_jamaah_tra);
        nik_jamaah        = (TextView)findViewById(R.id.nip_jamaah_travel);
        hp_jamaah         = (TextView)findViewById(R.id.no_hp_jamaah_travel);
        jk_jamaah         = (TextView)findViewById(R.id.txt_jk_travel);
        agen_jamaah       = (TextView)findViewById(R.id.agen_travel);
        paket_jamaah      = (TextView)findViewById(R.id.txt_paketTra);
        cicilan_jamaah    = (TextView)findViewById(R.id.txt_cicilTra);
        periode           = (TextView)findViewById(R.id.txt_pcicilTra);
        berangkat         = (TextView)findViewById(R.id.txt_berangkatTra);
        va_jamaah         = (TextView)findViewById(R.id.txt_vaTra);
        bank_jamaah       = (TextView)findViewById(R.id.txt_aTravel);
        txt_noRek         = (TextView)findViewById(R.id.txt_aRekTra);
        BICek             = (TextView)findViewById(R.id.txt_aCekBI);
        assigment         = (EditText)findViewById(R.id.input_assmentTra);

        setujuApproval    = (Button)findViewById(R.id.setuju_jamaah_travel);
        tolakApproval     = (Button)findViewById(R.id.tolak_jamaah_travel);

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
        txt_noRek.setText(" : "+jamaah.getNoRek());
        BICek.setText(" : "+jamaah.getJamaahApproval().getAssesmentBank());

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {

    }

    @Override
    public void updateJamaah(String updateJamaah) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setuju_jamaah_travel:

                ASSIGMENT = assigment.getText().toString();

                if (ASSIGMENT.equals("")){

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();
                }else {

                    pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();
                }

                break;

            case R.id.tolak_jamaah_travel:
                ASSIGMENT = assigment.getText().toString();

                if (ASSIGMENT.equals("")){

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();
                }else {

                    pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();
                }
                break;

        }
    }
}
