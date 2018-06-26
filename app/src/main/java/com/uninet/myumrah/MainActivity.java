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

import com.uninet.myumrah.activity.approval.JamaahApprovalBank;
import com.uninet.myumrah.activity.approval.JamaahApprovalMyUmroh;
import com.uninet.myumrah.activity.approval.JamahApproval;
import com.uninet.myumrah.activity.daftar_umroh.ListPaket;
import com.uninet.myumrah.activity.login_aplikasi.Login;
import com.uninet.myumrah.activity.login_aplikasi.Session;

public class MainActivity extends AppCompatActivity {
    private Button daftar;
    private Spinner ubah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daftar = (Button)findViewById(R.id.btn_daftar_umroh);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ListPaket.class));
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
                    startActivity(new Intent(MainActivity.this, JamahApproval.class));
                }else if (item == 2){
                    startActivity(new Intent(MainActivity.this, JamaahApprovalBank.class));
                }else {
                    startActivity(new Intent(MainActivity.this, JamaahApprovalMyUmroh.class));
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
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
