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

public class BankApproval extends AbstracGenericActivity implements ApprovalView,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_approval);

        Bundle extras   = getIntent().getExtras();
        IDJAMAAH        = extras.getString("idnya");

        tgl_registrasi    = (TextView)findViewById(R.id.tglDftr_bank);
        id_jamaah         = (TextView)findViewById(R.id.id_jamaah_bank);
        nama_jamaah       = (TextView)findViewById(R.id.nama_lengkap_jamaah_bank);
        nik_jamaah        = (TextView)findViewById(R.id.nip_jamaah_bank);
        hp_jamaah         = (TextView)findViewById(R.id.no_hp_jamaah_bank);
        jk_jamaah         = (TextView)findViewById(R.id.txt_jk_bank);
        agen_jamaah       = (TextView)findViewById(R.id.agen_bank);
        paket_jamaah      = (TextView)findViewById(R.id.txt_paketBank);
        cicilan_jamaah    = (TextView)findViewById(R.id.txt_cicilBank);
        periode           = (TextView)findViewById(R.id.txt_pcicilBank);
        berangkat         = (TextView)findViewById(R.id.txt_berangkatBank);
        va_jamaah         = (TextView)findViewById(R.id.txt_vaBank);
        bank_jamaah       = (TextView)findViewById(R.id.txt_aBank);
        txt_noRek         = (TextView)findViewById(R.id.txt_aRekBank);
        assigment         = (EditText)findViewById(R.id.input_assmentBank);

        setujuApproval    = (Button)findViewById(R.id.setuju_jamaah_bank);
        tolakApproval     = (Button)findViewById(R.id.tolak_jamaah_bank);

        approvalPresenter = new ApprovalPresenter(this, getApplicationContext());
        approvalPresenter.setDetailJamaah();
    }

    @Override
    public void listJamaah(String listJamah) {

    }

    @Override
    public void detailJamaah(String detailJamaah) {

        try {

        }catch (Exception e){

        }

        tgl_registrasi.setText(" : ");
        id_jamaah.setText(" : ");
        nama_jamaah.setText(" : ");
        nik_jamaah.setText(" : ");
        hp_jamaah.setText(" : ");
        jk_jamaah.setText(" : ");
        agen_jamaah.setText(" : ");
        paket_jamaah.setText(" : ");
        cicilan_jamaah.setText(" : ");
        periode.setText(" : ");
        berangkat.setText(" : ");
        va_jamaah.setText(" : ");
        bank_jamaah.setText(" : ");
        txt_noRek.setText(" : ");

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setuju_jamaah_bank:

                ASSIGMENT = assigment.getText().toString();

                if (ASSIGMENT.equals("")){

                    Toast.makeText(this, "Mohon Isi Assigment", Toast.LENGTH_SHORT).show();
                }else {

                    pdialog.setMessage("Sedang Memproses...");
                    pdialog.show();
                }

                break;

            case R.id.tolak_jamaah_bank:

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
