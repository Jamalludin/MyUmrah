package com.uninet.myumrah.activity.approval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.view.ApprovalView;

import static com.uninet.myumrah.activity.approval.KoperasiApproval.ASSIGMENT;

public class MyUmrahApproval extends AbstracGenericActivity implements ApprovalView,View.OnClickListener {

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

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {

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
