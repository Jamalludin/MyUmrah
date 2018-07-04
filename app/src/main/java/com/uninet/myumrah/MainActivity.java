package com.uninet.myumrah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static com.uninet.myumrah.util.DaftarUtil.NAMA_USER;
import static com.uninet.myumrah.util.DaftarUtil.ROLE_USER;

public class MainActivity extends AppCompatActivity {
    private Button daftar;
    private Spinner ubah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ROLE_USER = new Session(getApplicationContext()).role();
        NAMA_USER = new Session(getApplicationContext()).getUserName();

        daftar = (Button)findViewById(R.id.btn_daftar_umroh);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ListPaketActivity.class));
            }
        });

        ubah = (Spinner)findViewById(R.id.spinner_ubah);
        ArrayAdapter<CharSequence> adapter_ubah = ArrayAdapter.createFromResource(this, R.array.approval, android.R.layout.simple_spinner_item);
        adapter_ubah.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ubah.setAdapter(adapter_ubah);

        ubah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                int item = spinner.getSelectedItemPosition();

                if (item == 0){

                }else if (item == 1){
                    startActivity(new Intent(MainActivity.this, JamahApprovalActivity.class));
                }else if (item == 2){
                    startActivity(new Intent(MainActivity.this, BayarFullPaymentActivity.class));
                }else if (item == 3){
                    startActivity(new Intent(MainActivity.this, BayarFullPaymentActivity.class));
                }else if (item == 4){
                    startActivity(new Intent(MainActivity.this, CekBayarDownpaymentActivity.class));
                }else if (item == 5){
                    startActivity(new Intent(MainActivity.this, CekBayarFullPaymentActivity.class));
                }else if (item == 6){
                    startActivity(new Intent(MainActivity.this, CekBayarMahramActivity.class));
                }else if (item == 7){
                    startActivity(new Intent(MainActivity.this, CekIdJamaahdanNoVaActivity.class));
                }else if (item == 8){
                    startActivity(new Intent(MainActivity.this, StatusPersetujuanKoperasiActivity.class));
                }else if (item == 9){
                    startActivity(new Intent(MainActivity.this, StatusPersetujuanTravelActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, StatusPersetujuanBankActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                new Session(getApplicationContext()).logout();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
