package com.uninet.myumrah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.uninet.myumrah.activity.approval.JamaahApprovalBankActivity;
import com.uninet.myumrah.activity.approval.JamaahApprovalMyUmrohActivity;
import com.uninet.myumrah.activity.approval.JamahApprovalActivity;
import com.uninet.myumrah.activity.daftar_umroh.ListPaketActivity;
import com.uninet.myumrah.activity.login_aplikasi.LoginActivity;
import com.uninet.myumrah.activity.login_aplikasi.Session;
import com.uninet.myumrah.activity.pembayaran.BayarFullPaymentActivity;
import com.uninet.myumrah.activity.status.CekBayarDownpaymentActivity;
import com.uninet.myumrah.activity.status.CekBayarFullPaymentActivity;
import com.uninet.myumrah.activity.status.CekBayarMahramActivity;
import com.uninet.myumrah.activity.status.CekIdJamaahdanNoVaActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanBankActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanKoperasiActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanTravelActivity;
import com.uninet.myumrah.menu.MenuOperationalActivity;
import com.uninet.myumrah.menu.MenuPembayaranActivity;
import com.uninet.myumrah.menu.MenuPendukungActivity;
import com.uninet.myumrah.menu.MenuPerubahanActivity;
import com.uninet.myumrah.menu.MenuStatusActivity;

import static com.uninet.myumrah.util.DaftarUtil.NAMA_USER;
import static com.uninet.myumrah.util.DaftarUtil.ROLE_USER;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView pendaftaran;
    private CardView pembayaran;
    private CardView perubahanData;
    private CardView cekStatus;
    private CardView operationalUmroh;
    private CardView fiturPendukung;
    private CardView keluarAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ROLE_USER = new Session(getApplicationContext()).role();
        NAMA_USER = new Session(getApplicationContext()).getUserName();

        pendaftaran      = (CardView)findViewById(R.id.cardView_pendaftaran);
        pembayaran       = (CardView)findViewById(R.id.cardView_pembayaran);
        perubahanData    = (CardView)findViewById(R.id.cardView_perubahan);
        cekStatus        = (CardView)findViewById(R.id.cardView_status);
        operationalUmroh = (CardView)findViewById(R.id.cardView_operational);
        fiturPendukung   = (CardView)findViewById(R.id.cardView_pendukung);
        keluarAplikasi   = (CardView)findViewById(R.id.cardView_logout);

        pendaftaran.setOnClickListener(this);
        pembayaran.setOnClickListener(this);
        perubahanData.setOnClickListener(this);
        cekStatus.setOnClickListener(this);
        operationalUmroh.setOnClickListener(this);
        fiturPendukung.setOnClickListener(this);
        keluarAplikasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_pendaftaran:
                startActivity(new Intent(this,ListPaketActivity.class));
                break;
            case R.id.cardView_pembayaran:
                startActivity(new Intent(this, MenuPembayaranActivity.class));
                break;
            case R.id.cardView_perubahan:
                startActivity(new Intent(this, MenuPerubahanActivity.class));
                break;
            case R.id.cardView_status:
                startActivity(new Intent(this, MenuStatusActivity.class));
                break;
            case R.id.cardView_operational:
                startActivity(new Intent(this, MenuOperationalActivity.class));
                break;
            case R.id.cardView_pendukung:
                startActivity(new Intent(this, MenuPendukungActivity.class));
                break;
            case R.id.cardView_logout:
                new Session(getApplicationContext()).logout();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }
}
