package com.uninet.myumrah.activity.daftar_umroh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uninet.myumrah.MainActivity;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.activity.login_aplikasi.Session;
import com.uninet.myumrah.model.Approval;
import com.uninet.myumrah.model.Bank;
import com.uninet.myumrah.model.Cicilan;
import com.uninet.myumrah.model.DownPayment;
import com.uninet.myumrah.model.GolonganDarah;
import com.uninet.myumrah.model.Hubungan;
import com.uninet.myumrah.model.Instansi;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.model.JamaahApproval;
import com.uninet.myumrah.model.JamaahPenyakit;
import com.uninet.myumrah.model.JenisBayar;
import com.uninet.myumrah.model.JenisKelamin;
import com.uninet.myumrah.model.Kecamatan;
import com.uninet.myumrah.model.Kelurahan;
import com.uninet.myumrah.model.Kewarganegaraan;
import com.uninet.myumrah.model.KotaKabupaten;
import com.uninet.myumrah.model.Paket;
import com.uninet.myumrah.model.Pekerjaan;
import com.uninet.myumrah.model.Pendidikan;
import com.uninet.myumrah.model.Penyakit;
import com.uninet.myumrah.model.Provinsi;
import com.uninet.myumrah.model.StatusAktif;
import com.uninet.myumrah.model.StatusApproval;
import com.uninet.myumrah.model.StatusKawin;
import com.uninet.myumrah.model.StatusMahram;
import com.uninet.myumrah.model.StatusPenyakit;
import com.uninet.myumrah.model.StatusPesawat;
import com.uninet.myumrah.model.Talangan;
import com.uninet.myumrah.model.Ukuran;
import com.uninet.myumrah.model.User;
import com.uninet.myumrah.presenter.DataTambahanPresenter;
import com.uninet.myumrah.util.JsonUtil;
import com.uninet.myumrah.view.DataTambahanView;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.uninet.myumrah.util.DaftarUtil.ALAMAT_KELUARGA;
import static com.uninet.myumrah.util.DaftarUtil.ALAMAT_LENGKAP;
import static com.uninet.myumrah.util.DaftarUtil.BANK;
import static com.uninet.myumrah.util.DaftarUtil.BANKID;
import static com.uninet.myumrah.util.DaftarUtil.BAYAR;
import static com.uninet.myumrah.util.DaftarUtil.BAYAR_ID;
import static com.uninet.myumrah.util.DaftarUtil.CICILAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.DINAS;
import static com.uninet.myumrah.util.DaftarUtil.EMAIL_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.GOLDAR;
import static com.uninet.myumrah.util.DaftarUtil.HUBUNGAN_KELUARGA;
import static com.uninet.myumrah.util.DaftarUtil.IDDP;
import static com.uninet.myumrah.util.DaftarUtil.ID_PAKET;
import static com.uninet.myumrah.util.DaftarUtil.INSTANSI_ID;
import static com.uninet.myumrah.util.DaftarUtil.KABUPATEN_ID;
import static com.uninet.myumrah.util.DaftarUtil.KECAMATAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.KELAMIN;
import static com.uninet.myumrah.util.DaftarUtil.KELURAHAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.LAMA_SAKIT1;
import static com.uninet.myumrah.util.DaftarUtil.LAMA_SAKIT2;
import static com.uninet.myumrah.util.DaftarUtil.LAMA_SAKIT3;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_AYAH;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_KELUARGA;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_LENGKAP;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_MAHRAM;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_PENYAKIT1;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_PENYAKIT2;
import static com.uninet.myumrah.util.DaftarUtil.NAMA_PENYAKIT3;
import static com.uninet.myumrah.util.DaftarUtil.NEGARA;
import static com.uninet.myumrah.util.DaftarUtil.NIK_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.NIP_JAMAAH;
import static com.uninet.myumrah.util.DaftarUtil.NO_HP;
import static com.uninet.myumrah.util.DaftarUtil.NO_KK;
import static com.uninet.myumrah.util.DaftarUtil.PEKERJAAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.PENDIDIKAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.POS_KODE;
import static com.uninet.myumrah.util.DaftarUtil.PROVINSI_ID;
import static com.uninet.myumrah.util.DaftarUtil.RIWAYAT_PERKAWINAN;
import static com.uninet.myumrah.util.DaftarUtil.RT_RW;
import static com.uninet.myumrah.util.DaftarUtil.STATUS_MAHRAM;
import static com.uninet.myumrah.util.DaftarUtil.TAHUN_SAKIT1;
import static com.uninet.myumrah.util.DaftarUtil.TAHUN_SAKIT2;
import static com.uninet.myumrah.util.DaftarUtil.TAHUN_SAKIT3;
import static com.uninet.myumrah.util.DaftarUtil.TALANGAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.TELP_KELUARGA;
import static com.uninet.myumrah.util.DaftarUtil.TEMPAT_LAHIR;
import static com.uninet.myumrah.util.DaftarUtil.TERAKHIR_UMROH;
import static com.uninet.myumrah.util.DaftarUtil.TGL_LAHIR;
import static com.uninet.myumrah.util.DaftarUtil.UKURAN_BAJU_ID;

public class DataPendukung extends AbstracGenericActivity implements DataTambahanView,AdapterView.OnItemSelectedListener{

    private Jamaah jamaah = new Jamaah();
    private JamaahApproval jamaahApproval = new JamaahApproval();
    private List<JamaahPenyakit> jamaahPenyakits = new ArrayList<>();
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pendukung);

        dataTambahanPresenter = new DataTambahanPresenter(this,getApplicationContext());
        dataTambahanPresenter.setProvinsi();
        dataTambahanPresenter.setBaju();
        dataTambahanPresenter.setMahram();
        dataTambahanPresenter.setPendidikan();
        dataTambahanPresenter.setPekerjaan();
        dataTambahanPresenter.setPenyakit();
        dataTambahanPresenter.setHubungan();

        pilihPovinsi     = (Spinner)findViewById(R.id.spinner_provinsi);
        pilihKabupaten   = (Spinner)findViewById(R.id.spinner_kabupaten);
        pilihKecamatan   = (Spinner)findViewById(R.id.spinner_kecamatan);
        pilihKelurahan   = (Spinner)findViewById(R.id.spinner_kelurahan);
        ukuranBaju       = (Spinner)findViewById(R.id.spinnerBaju);
        pendidikanLast   = (Spinner)findViewById(R.id.spinner_pendidikan);
        pekerjaanList    = (Spinner)findViewById(R.id.spinnerKerja);
        statusMahram     = (Spinner)findViewById(R.id.spinnerStatMahram);
        hubDaruratList   = (Spinner)findViewById(R.id.spinnerHubdarurat);
        spinnerPenyakit1 = (Spinner)findViewById(R.id.spinnerSakit);
        spinnerPenyakit2 = (Spinner)findViewById(R.id.spinnerSakit2);
        spinnerPenyakit3 = (Spinner)findViewById(R.id.spinnerSakit3);
        tahunSakit1      = (Spinner)findViewById(R.id.spinnerTahun);
        tahunSakit2      = (Spinner)findViewById(R.id.spinnerTahun2);
        tahunSakit3      = (Spinner)findViewById(R.id.spinnerTahun3);
        lamaSakit1       = (Spinner)findViewById(R.id.spinnerLama);
        lamaSakit2       = (Spinner)findViewById(R.id.spinnerLama2);
        lamaSakit3       = (Spinner)findViewById(R.id.spinnerLama3);
        simpanData       = (Button)findViewById(R.id.btn_data_pendukung);

        txtPos          = (TextView)findViewById(R.id.txt_pos);
        alamatJamaah    = (EditText)findViewById(R.id.input_alamat);
        rtrw            = (EditText)findViewById(R.id.input_rtrw);
        namaMahram      = (EditText)findViewById(R.id.input_mahramNama);
        namaDarurat     = (EditText)findViewById(R.id.input_namaDarurat);
        alamatDarurat   = (EditText)findViewById(R.id.input_alamatDarurat);
        telpDarurat     = (EditText)findViewById(R.id.input_nomorDarurat);
        dinas           = (EditText)findViewById(R.id.input_dinas);

        pilihPovinsi.setOnItemSelectedListener(this);
        pilihKabupaten.setOnItemSelectedListener(this);
        pilihKecamatan.setOnItemSelectedListener(this);
        pilihKelurahan.setOnItemSelectedListener(this);
        ukuranBaju.setOnItemSelectedListener(this);
        statusMahram.setOnItemSelectedListener(this);
        hubDaruratList.setOnItemSelectedListener(this);
        pekerjaanList.setOnItemSelectedListener(this);
        pendidikanLast.setOnItemSelectedListener(this);
        spinnerPenyakit1.setOnItemSelectedListener(this);
        spinnerPenyakit2.setOnItemSelectedListener(this);
        spinnerPenyakit3.setOnItemSelectedListener(this);
        tahunSakit1.setOnItemSelectedListener(this);
        tahunSakit2.setOnItemSelectedListener(this);
        tahunSakit3.setOnItemSelectedListener(this);
        lamaSakit1.setOnItemSelectedListener(this);
        lamaSakit2.setOnItemSelectedListener(this);
        lamaSakit3.setOnItemSelectedListener(this);

        tahunSakitArray.add("Tahun");
        penyakitList.add("Penyakit");
        lamaList.add("Lama Sakit");

        super.tahunSakit();

        tahunSakit1.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, tahunSakitArray));
        tahunSakit2.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, tahunSakitArray));
        tahunSakit3.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, tahunSakitArray));

        super.getMont();
        lamaSakit1.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, lamaList));
        lamaSakit2.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, lamaList));
        lamaSakit3.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                android.R.layout.simple_spinner_dropdown_item, lamaList));

        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ALAMAT_LENGKAP  = alamatJamaah.getText().toString();
                RT_RW           = rtrw.getText().toString();
                NAMA_MAHRAM     = namaMahram.getText().toString();
                NAMA_KELUARGA   = namaDarurat.getText().toString();
                ALAMAT_KELUARGA = alamatDarurat.getText().toString();
                TELP_KELUARGA   = telpDarurat.getText().toString();
                DINAS           = dinas.getText().toString();

                jamaah.setNamaLengkap(NAMA_LENGKAP);
                jamaah.setNamaAyah(NAMA_AYAH);
                jamaah.setNik(NIK_JAMAAH);
                jamaah.setNip(NIP_JAMAAH);
                jamaah.setKk(NO_KK);
                jamaah.setTempatLahir(TEMPAT_LAHIR);
                Date tglLahir = null;
                try {
                    tglLahir = format.parse(TGL_LAHIR);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                jamaah.setTglLahir(tglLahir);
                jamaah.setTglDaftar(new java.sql.Date(new Date().getTime()));
                jamaah.setAlamat(ALAMAT_LENGKAP);
                jamaah.setRtrw(RT_RW);
                jamaah.setEmail(EMAIL_JAMAAH);
                jamaah.setGolonganDarah(new GolonganDarah(Integer.parseInt(GOLDAR)));
                jamaah.setKewarganegaraan(new Kewarganegaraan(Integer.parseInt(NEGARA)));
                jamaah.setTerakhirUmroh(Integer.parseInt(TERAKHIR_UMROH));
                jamaah.setNoHp(NO_HP);
                jamaah.setNamaDarurat(NAMA_KELUARGA);
                jamaah.setNoHpDarurat(TELP_KELUARGA);
                jamaah.setAlamatDarurat(ALAMAT_KELUARGA);
                jamaah.setPaket(new Paket(ID_PAKET));
                jamaah.setStatusKawin(new StatusKawin(Integer.parseInt(RIWAYAT_PERKAWINAN)));
                jamaah.setJenisKelamin(new JenisKelamin(Integer.parseInt(KELAMIN)));
                jamaah.setPendidikan(new Pendidikan(Integer.parseInt(PENDIDIKAN_ID)));
                jamaah.setPekerjaan(new Pekerjaan(Integer.parseInt(PEKERJAAN_ID)));
                jamaah.setHubungan(new Hubungan(Integer.parseInt(HUBUNGAN_KELUARGA)));
                jamaah.setBank(new Bank(Integer.parseInt(BANKID)));
                jamaah.setUser(new User(new Session(getApplicationContext()).getUserName()));
                jamaah.setNamaMahram(NAMA_MAHRAM);
                jamaah.setStatusMahram(new StatusMahram(Integer.parseInt(STATUS_MAHRAM)));
                jamaah.setUkuran(new Ukuran(Integer.parseInt(UKURAN_BAJU_ID)));
                jamaah.setKelurahan(new Kelurahan(KELURAHAN_ID,POS_KODE));
                jamaah.setKecamatan(new Kecamatan(KECAMATAN_ID));
                jamaah.setKotaKabupaten(new KotaKabupaten(KABUPATEN_ID));
                jamaah.setProvinsi(new Provinsi(PROVINSI_ID));
                jamaah.setCicilan(new Cicilan(Integer.parseInt(CICILAN_ID)));
                jamaah.setDownPayment(new DownPayment(Integer.parseInt(IDDP)));
                jamaah.setTalangan(new Talangan(Integer.parseInt(TALANGAN_ID)));
                jamaah.setJenisBayar(new JenisBayar(Integer.parseInt(BAYAR_ID)));
                jamaah.setInstansi(new Instansi(Integer.parseInt(INSTANSI_ID)));
                jamaah.setStatusAktif(new StatusAktif(0));
                jamaah.setStatusPesawat(new StatusPesawat());

                jamaahApproval.setApproval(new Approval(1));
                jamaahApproval.setStatusApproval(new StatusApproval(2));
                jamaah.setJamaahApproval(jamaahApproval);

                if (NAMA_PENYAKIT1 != null & LAMA_SAKIT1 != null & TAHUN_SAKIT1 != null) {
                    JamaahPenyakit jamaahPenyakit1 = new JamaahPenyakit();
                    jamaahPenyakit1.setJamaah(jamaah);

                    Penyakit penyakit1 = new Penyakit();
                    penyakit1.setIdPenyakit(Integer.parseInt(NAMA_PENYAKIT1));
                    jamaahPenyakit1.setPenyakit(penyakit1);

                    jamaahPenyakit1.setLamaPenyakit(Integer.parseInt(LAMA_SAKIT1));
                    jamaahPenyakit1.setTahunPenyakitIntType(Integer.parseInt(TAHUN_SAKIT1));

                    StatusPenyakit statusPenyakit1 = new StatusPenyakit();
                    statusPenyakit1.setIdStatus(0);
                    jamaahPenyakit1.setStatusPenyakit(statusPenyakit1);

                    jamaahPenyakits.add(jamaahPenyakit1);
                }


                if (NAMA_PENYAKIT2 != null & LAMA_SAKIT2 != null & TAHUN_SAKIT2 != null) {
                    JamaahPenyakit jamaahPenyakit2 = new JamaahPenyakit();
                    jamaahPenyakit2.setJamaah(jamaah);

                    Penyakit penyakit2 = new Penyakit();
                    penyakit2.setIdPenyakit(Integer.parseInt(NAMA_PENYAKIT2));
                    jamaahPenyakit2.setPenyakit(penyakit2);

                    jamaahPenyakit2.setLamaPenyakit(Integer.parseInt(LAMA_SAKIT2));
                    jamaahPenyakit2.setTahunPenyakitIntType(Integer.parseInt(TAHUN_SAKIT2));

                    StatusPenyakit statusPenyakit2 = new StatusPenyakit();
                    statusPenyakit2.setIdStatus(0);
                    jamaahPenyakit2.setStatusPenyakit(statusPenyakit2);

                    jamaahPenyakits.add(jamaahPenyakit2);
                }

                if (NAMA_PENYAKIT3 != null & LAMA_SAKIT3 != null & TAHUN_SAKIT3 != null) {
                    JamaahPenyakit jamaahPenyakit3 = new JamaahPenyakit();
                    jamaahPenyakit3.setJamaah(jamaah);

                    Penyakit penyakit3 = new Penyakit();
                    penyakit3.setIdPenyakit(Integer.parseInt(NAMA_PENYAKIT3));
                    jamaahPenyakit3.setPenyakit(penyakit3);

                    jamaahPenyakit3.setLamaPenyakit(Integer.parseInt(LAMA_SAKIT3));
                    jamaahPenyakit3.setTahunPenyakitIntType(Integer.parseInt(TAHUN_SAKIT3));

                    StatusPenyakit statusPenyakit3 = new StatusPenyakit();
                    statusPenyakit3.setIdStatus(0);
                    jamaahPenyakit3.setStatusPenyakit(statusPenyakit3);

                    jamaahPenyakits.add(jamaahPenyakit3);
                }

                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                System.out.println("request"+gson.toJson(jamaah));
                dataTambahanPresenter.setDaftar(gson.toJson(jamaah));

            }
        });

    }

    @Override
    public void validasiDataSuccess(String data) {

    }

    @Override
    public void validasiDataError(String data) {

    }

    @Override
    public void daftar(String daftar) {

    }

    @Override
    public void approval(String approval) {

    }

    @Override
    public void provinsi(String provinsi) {

        try {
            JSONObject lamaObj = new JSONObject(provinsi);
            provinsiArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < provinsiArray.length(); i++) {
                JSONObject hariObj = provinsiArray.getJSONObject(i);
                provinsiArr.add(hariObj.getString("namaProvinsi"));
            }

            pilihPovinsi.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, provinsiArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void kabupaten(String kabupaten) {

        try {
            JSONObject lamaObj = new JSONObject(kabupaten);
            kabupatenArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < kabupatenArray.length(); i++) {
                JSONObject hariObj = kabupatenArray.getJSONObject(i);
                kabupatenArr.add(hariObj.getString("namaKabupaten"));
            }

            pilihKabupaten.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, kabupatenArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void kecamatan(String kecamatan) {

        try {
            JSONObject lamaObj = new JSONObject(kecamatan);
            kecamatanArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < kecamatanArray.length(); i++) {
                JSONObject hariObj = kecamatanArray.getJSONObject(i);
                kecamatanArr.add(hariObj.getString("namaKecamatan"));
            }

            pilihKecamatan.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, kecamatanArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void kelurahan(String kelurahan) {

        try {
            JSONObject objKelu = new JSONObject(kelurahan);
            kelurahanArray = objKelu.getJSONArray("data");

            for (int i = 0; i<kelurahanArray.length();i++){
                JSONObject keluObj = kelurahanArray.getJSONObject(i);
                kelurahanArr.add(keluObj.getString("namaKelurahan"));
            }

            pilihKelurahan.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, kelurahanArr));

        }catch (Exception e){

        }

    }

    @Override
    public void ukuranBaju(String baju) {

        try {
            JSONObject lamaObj = new JSONObject(baju);
            bajuArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < bajuArray.length(); i++) {
                JSONObject hariObj = bajuArray.getJSONObject(i);
                bajuUkuran.add(hariObj.getString("namaUkuran"));
            }

            ukuranBaju.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, bajuUkuran));

        } catch (Exception e) {


        }

    }

    @Override
    public void mahram(String mahram) {

        try {
            JSONObject lamaObj = new JSONObject(mahram);
            mahramArray = lamaObj.getJSONArray("data");

            for (int i = 0; i < mahramArray.length(); i++) {
                JSONObject hariObj = mahramArray.getJSONObject(i);
                mahramarr.add(hariObj.getString("namaStatus"));
            }

            statusMahram.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, mahramarr));

        } catch (Exception e) {


        }

    }

    @Override
    public void pendidikan(String pendidikan) {

        try {
            JSONObject didikObj = new JSONObject(pendidikan);
            pendidikanArray = didikObj.getJSONArray("data");

            for (int i = 0; i < pendidikanArray.length(); i++) {
                JSONObject objDidik = pendidikanArray.getJSONObject(i);
                pendidikanArr.add(objDidik.getString("namaPendidikan"));
            }

            pendidikanLast.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, pendidikanArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void pekerjaan(String pekerjaan) {

        try {
            JSONObject kerjaObj = new JSONObject(pekerjaan);
            pekerjaanArray = kerjaObj.getJSONArray("data");

            for (int i = 0; i < pekerjaanArray.length(); i++) {
                JSONObject objKerja = pekerjaanArray.getJSONObject(i);
                pekerjaanArr.add(objKerja.getString("namaPekerjaan"));
            }

            pekerjaanList.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, pekerjaanArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void penyakit(String penyakit) {

        try {
            JSONObject sakitObj = new JSONObject(penyakit);
            penyakitArray = sakitObj.getJSONArray("data");

            for (int i = 0; i < penyakitArray.length(); i++) {
                JSONObject objSakit = penyakitArray.getJSONObject(i);
                penyakitList.add(objSakit.getString("namaPenyakit"));
            }

            spinnerPenyakit1.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, penyakitList));
            spinnerPenyakit2.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, penyakitList));
            spinnerPenyakit3.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, penyakitList));

        } catch (Exception e) {


        }

    }

    @Override
    public void hubungan(String hubungan) {

        try {
            JSONObject hubObj = new JSONObject(hubungan);
            hubunganArray = hubObj.getJSONArray("data");

            for (int i = 0; i < hubunganArray.length(); i++) {
                JSONObject objHub = hubunganArray.getJSONObject(i);
                hubunganArr.add(objHub.getString("namaHubungan"));
            }

            hubDaruratList.setAdapter(new ArrayAdapter<String>(DataPendukung.this,
                    android.R.layout.simple_spinner_dropdown_item, hubunganArr));

        } catch (Exception e) {


        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;
        String item = spinner.getSelectedItem().toString();

        if (spinner.getId() == R.id.spinner_provinsi) {

            PROVINSI_ID = getIdProvinsi(position).toString();

            dataTambahanPresenter.setKabupaten();

            kabupatenArr.clear();
            kecamatanArr.clear();
            kelurahanArr.clear();

        } else if (spinner.getId() == R.id.spinner_kabupaten){

            KABUPATEN_ID = getIdKabupaten(position).toString();

            dataTambahanPresenter.setKecamatan();

            kecamatanArr.clear();
            kelurahanArr.clear();

        } else if (spinner.getId() == R.id.spinner_kecamatan){

            KECAMATAN_ID = getIdKecamatan(position).toString();

            dataTambahanPresenter.setKelurahan();

            kelurahanArr.clear();

        } else if (spinner.getId() == R.id.spinner_kelurahan){

            KELURAHAN_ID = getIdKelurahan(position).toString();
            POS_KODE     = getKodePos(position).toString();
            txtPos.setText(POS_KODE);

        }else if (spinner.getId() == R.id.spinnerBaju){

            UKURAN_BAJU_ID = getIdUkuran(position).toString();

        }else if (spinner.getId() == R.id.spinner_pendidikan){

            PENDIDIKAN_ID = getIdPendidikan(position).toString();

        }else if (spinner.getId() == R.id.spinnerKerja){

            PEKERJAAN_ID = idPerkerjaan(position).toString();

        }else if (spinner.getId() == R.id.spinnerStatMahram){

            STATUS_MAHRAM = getIdMahram(position).toString();

        }else if (spinner.getId() == R.id.spinnerHubdarurat){
            HUBUNGAN_KELUARGA = idHubungan(position).toString();

        }else if (spinner.getId() == R.id.spinnerSakit){

            if (item.equalsIgnoreCase("Penyakit")){

                NAMA_PENYAKIT1 = null;

            }else {

                NAMA_PENYAKIT1 = idPenyakit(position-1).toString();

            }


        }else if (spinner.getId() == R.id.spinnerSakit2){

            if (item.equalsIgnoreCase("Penyakit")){

                NAMA_PENYAKIT2 = null;

            }else {

                NAMA_PENYAKIT2 = idPenyakit(position-1).toString();

            }



        }else if (spinner.getId() == R.id.spinnerSakit3){

            if (item.equalsIgnoreCase("Penyakit")){

                NAMA_PENYAKIT3 = null;

            }else {

                NAMA_PENYAKIT3 = idPenyakit(position-1).toString();

            }


        }else if (spinner.getId() == R.id.spinnerTahun){

            if (item.equalsIgnoreCase("Tahun")){

                TAHUN_SAKIT1 = null;

            }else {

                TAHUN_SAKIT1 = item;

            }

        }else if (spinner.getId() == R.id.spinnerTahun2){

            if (item.equalsIgnoreCase("Tahun")){

                TAHUN_SAKIT2 = null;

            }else {

                TAHUN_SAKIT2 = item;

            }

        }else if (spinner.getId() == R.id.spinnerTahun3){

            if (item.equalsIgnoreCase("Tahun")){

                TAHUN_SAKIT3 = null;

            }else {

                TAHUN_SAKIT3 = item;

            }

        }else if (spinner.getId() == R.id.spinnerLama){

            if (item.equalsIgnoreCase("Lama Sakit")){

                LAMA_SAKIT1 = null;

            }else {

                LAMA_SAKIT1 = item;

            }

        }else if (spinner.getId() == R.id.spinnerLama2){

            if (item.equalsIgnoreCase("Lama Sakit")){

                LAMA_SAKIT2 = null;

            }else {

                LAMA_SAKIT2 = item;

            }

        }else if (spinner.getId() == R.id.spinnerLama3){

            if (item.equalsIgnoreCase("Lama Sakit")){

                LAMA_SAKIT3 = null;

            }else {

                LAMA_SAKIT3 = item;

            }

        }else {


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
