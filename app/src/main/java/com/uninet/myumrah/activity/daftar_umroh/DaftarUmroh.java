package com.uninet.myumrah.activity.daftar_umroh;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.view.DataDiriView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import es.dmoral.toasty.Toasty;

import static com.uninet.myumrah.util.DaftarUtil.EMAIL_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.GOLDAR;
import static com.uninet.myumrah.util.DaftarUtil.KELAMIN;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_AYAH;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_LENGKAP;
import static com.uninet.myumrah.util.DaftarUtil.NEGARA;
import static com.uninet.myumrah.util.DaftarUtil.NIK_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.NIP_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.NO_HP;
import static com.uninet.myumrah.util.DaftarUtil.NO_KK;
import static com.uninet.myumrah.util.DaftarUtil.RIWAYAT_PERKAWINAN;
import static com.uninet.myumrah.util.DaftarUtil.TEMPAT_LAHIR;
import static com.uninet.myumrah.util.DaftarUtil.TERAKHIR_UMROH;
import static com.uninet.myumrah.util.DaftarUtil.TGL_LAHIR;


public class DaftarUmroh extends AbstracGenericActivity implements DataDiriView, AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_umroh);

        textNama        = (EditText)findViewById(R.id.input_nama_lengkap);
        textAyah        = (EditText)findViewById(R.id.input_nama_ayah);
        textTmpLahir    = (EditText)findViewById(R.id.input_lahir);
        textKK          = (EditText)findViewById(R.id.input_kk);
        textNik         = (EditText)findViewById(R.id.input_nik);
        textNip         = (EditText)findViewById(R.id.input_nip);
        textNoHp        = (EditText)findViewById(R.id.input_nohp);
        textEmail       = (EditText)findViewById(R.id.input_email);
        textThUmroh     = (EditText)findViewById(R.id.input_terakhir);
        tglLahir        = (TextView)findViewById(R.id.txt_tgl_lahir);
        img_tgl_lahir   = (ImageView)findViewById(R.id.img_tgl);
        pria            = (RadioButton)findViewById(R.id.radio_btn_laki_laki);
        wanita          = (RadioButton)findViewById(R.id.radio_btn_Perempuan);
        wni             = (RadioButton)findViewById(R.id.radio_wni);
        wna             = (RadioButton)findViewById(R.id.radio_wna);
        daftarIndividu  = (Button)findViewById(R.id.btn_daftar_individu);

        pdialog         = new ProgressDialog(this);
        darahs          = new ArrayList<String>();
        perkawinans     = new ArrayList<String>();

        golonganDarahSpin = (Spinner)findViewById(R.id.spinner_goldarIndi);
        statusPerkawinan = (Spinner)findViewById(R.id.spinner_status_perkawinan);

        golonganDarahSpin.setOnItemSelectedListener(this);
        statusPerkawinan.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> goldar = ArrayAdapter.createFromResource(this, R.array.golongan_darah, android.R.layout.simple_spinner_item);
        goldar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        golonganDarahSpin.setAdapter(goldar);

        ArrayAdapter<CharSequence> perkawinan = ArrayAdapter.createFromResource(this, R.array.perkawinan, android.R.layout.simple_spinner_item);
        perkawinan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusPerkawinan.setAdapter(perkawinan);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String format_date = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format_date, Locale.US);
                tglLahir.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        img_tgl_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DaftarUmroh.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        daftarIndividu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NAMA_LENGKAP   = textNama.getText().toString();
                NAMA_AYAH      = textAyah.getText().toString();
                TEMPAT_LAHIR   = textTmpLahir.getText().toString();
                NO_KK          = textKK.getText().toString();
                NIK_JAMAAH     = textNik.getText().toString();
                NIP_JAMAAH     = textNip.getText().toString();
                NO_HP          = textNoHp.getText().toString();
                EMAIL_JAMAAH   = textEmail.getText().toString();
                TERAKHIR_UMROH = textThUmroh.getText().toString();
                TGL_LAHIR      = tglLahir.getText().toString();

                if (wni.isChecked()){

                    NEGARA = "1";

                }else {

                    NEGARA = "2";

                }

                if (pria.isChecked()){

                    KELAMIN = "1";
                }else {

                    KELAMIN = "2";
                }
                startActivity(new Intent(DaftarUmroh.this,DataPendukung.class));
            }
        });

    }

    @Override
    public void validasiDataSuccess(String data) {
        Toasty.success(this, data, Toast.LENGTH_LONG).show();

    }

    @Override
    public void validasiDataError(String data) {
        Toasty.error(this, data, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;

        if (spinner.getId() == R.id.spinner_goldarIndi) {
            GOLDAR = String.valueOf(spinner.getSelectedItemPosition()+1);

        }else {
            RIWAYAT_PERKAWINAN = String.valueOf(spinner.getSelectedItemPosition()+1);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
