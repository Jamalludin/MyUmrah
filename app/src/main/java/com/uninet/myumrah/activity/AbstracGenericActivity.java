package com.uninet.myumrah.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.presenter.DataDiriPresenter;
import com.uninet.myumrah.presenter.DataTambahanPresenter;
import com.uninet.myumrah.presenter.DownPaymentPresenter;
import com.uninet.myumrah.presenter.list_paket.BankPresenter;
import com.uninet.myumrah.presenter.list_paket.CaraBayarPresenter;
import com.uninet.myumrah.presenter.list_paket.InstansiPresenter;
import com.uninet.myumrah.presenter.list_paket.LamaHariPresenter;
import com.uninet.myumrah.presenter.list_paket.PaketPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class AbstracGenericActivity extends AppCompatActivity{

    //ListPaket
    protected ArrayList<String> lamaJalan     = new ArrayList<String>();
    protected ArrayList<String> tahunPaket    = new ArrayList<String>();
    protected ArrayList<String> weekPaket     = new ArrayList<String>();
    protected ArrayList<String> montPaket     = new ArrayList<String>();
    protected ArrayList<String> bayarPaket    = new ArrayList<String>();
    protected ArrayList<String> instanList    = new ArrayList<String>();
    protected ArrayList<String> bankList      = new ArrayList<String>();
    protected ArrayList<Double> dpList        = new ArrayList<Double>();
    protected ArrayList<String> cicilanList   = new ArrayList<String>();
    protected ArrayList<String> perkawinan    = new ArrayList<String>();
    protected ArrayList<String> golonganDarah = new ArrayList<String>();
    protected LamaHariPresenter lamaHariPresenter;
    protected InstansiPresenter instansiPresenter;
    protected CaraBayarPresenter caraBayarPresenter;
    protected BankPresenter bankPresenter;
    protected PaketPresenter paketPresenter;
    protected DataDiriPresenter dataDiriPresenter;
    protected DownPaymentPresenter downPaymentPresenter;
    protected DataTambahanPresenter dataTambahanPresenter;
    protected Spinner lamaPerjalanan;
    protected Spinner tahunPaketSpin;
    protected Spinner bulanPaketSpin;
    protected Spinner weekPakerSpin;
    protected Spinner caraBayar;
    protected Spinner bankListSpin;
    protected Spinner instansiList;
    protected Spinner downPaymentListSpin;
    protected TextView hargaPaket;
    protected TextView dpNominal;
    protected TextView totalTalangan;
    protected Button cariPaket;
    protected String idInstansi;
    protected String idBayar;
    protected String idBank;
    protected String idDownP;
    protected JSONArray instansiId;
    protected JSONArray bankId;
    protected JSONArray bayarId;
    protected RecyclerView mRecyclerView;
    protected RecyclerView.Adapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected ProgressDialog pdialog;

    //daftarUmroh
    protected Spinner golonganDarahSpin;
    protected Spinner statusPerkawinan;
    protected RadioButton pria,wni,wanita,wna;
    protected TextView tglLahir;
    protected ImageView img_tgl_lahir;
    protected EditText textNama;
    protected EditText textAyah;
    protected EditText textTmpLahir;
    protected EditText textKK;
    protected EditText textNik;
    protected EditText textNip;
    protected EditText textNoHp;
    protected EditText textEmail;
    protected EditText textThUmroh;
    protected Button   daftarIndividu;
    protected JSONArray goldarArray;
    protected JSONArray cicilanArr;
    protected JSONArray downPaymentArr;
    protected ArrayList<String> darahs = new ArrayList<String>();;
    protected ArrayList<String> perkawinans = new ArrayList<String>();
    protected Calendar calendar = Calendar.getInstance();

    //datapendukung
    protected ArrayList<String> provinsiArr     = new ArrayList<String>();
    protected ArrayList<String> kelurahanArr    = new ArrayList<String>();
    protected ArrayList<String> kabupatenArr    = new ArrayList<String>();
    protected ArrayList<String> kecamatanArr    = new ArrayList<String>();
    protected ArrayList<String> bajuUkuran      = new ArrayList<String>();
    protected ArrayList<String> pendidikanArr   = new ArrayList<String>();
    protected ArrayList<String> pekerjaanArr    = new ArrayList<String>();
    protected ArrayList<String> mahramarr       = new ArrayList<String>();
    protected ArrayList<String> hubunganArr     = new ArrayList<String>();
    protected ArrayList<String> tahunSakitArray = new ArrayList<String>();
    protected ArrayList<String> penyakitList    = new ArrayList<String>();
    protected ArrayList<String> lamaList        = new ArrayList<String>();
    protected EditText alamatJamaah;
    protected EditText rtrw;
    protected EditText namaMahram;
    protected EditText namaDarurat;
    protected EditText telpDarurat;
    protected EditText alamatDarurat;
    protected EditText dinas;
    protected TextView txtPos;
    protected TextView txtProvinsi;
    protected Spinner pilihPovinsi;
    protected Spinner pilihKabupaten;
    protected Spinner pilihKecamatan;
    protected Spinner pilihKelurahan;
    protected Spinner pendidikanLast;
    protected Spinner pekerjaanList;
    protected Spinner ukuranBaju;
    protected Spinner statusMahram;
    protected Spinner spinnerPenyakit1;
    protected Spinner spinnerPenyakit2;
    protected Spinner spinnerPenyakit3;
    protected Spinner tahunSakit1;
    protected Spinner tahunSakit2;
    protected Spinner tahunSakit3;
    protected Spinner lamaSakit1;
    protected Spinner lamaSakit2;
    protected Spinner lamaSakit3;
    protected Spinner hubDaruratList;
    protected Button simpanData;
    protected JSONArray provinsiArray;
    protected JSONArray kabupatenArray;
    protected JSONArray kecamatanArray;
    protected JSONArray kelurahanArray;
    protected JSONArray bajuArray;
    protected JSONArray pendidikanArray;
    protected JSONArray pekerjaanArray;
    protected JSONArray mahramArray;
    protected JSONArray penyakitArray;
    protected JSONArray hubunganArray;
    protected String  idProvi;

    //approval
    protected ApprovalPresenter approvalPresenter;
    protected TextView  tgl_registrasi;
    protected TextView  id_jamaah;
    protected TextView  nama_jamaah;
    protected TextView  nik_jamaah;
    protected TextView  hp_jamaah;
    protected TextView  jk_jamaah;
    protected TextView  agen_jamaah;
    protected TextView  paket_jamaah;
    protected TextView  cicilan_jamaah;
    protected TextView  periode;
    protected TextView  berangkat;
    protected TextView  va_jamaah;
    protected TextView  bank_jamaah;
    protected TextView  txt_noRek;
    protected TextView  BICek;
    protected EditText  assigment;
    protected EditText  no_rek;
    protected Button setujuApproval;
    protected Button tolakApproval;
    public static String IDJAMAAH;

    protected void tahunPaket() {
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int y = year ;y <= year+2; y++){
            tahunPaket.add(Integer.toString(y));
        }

    }

    protected void weekPaket(){

        for (int w = 1; w<=4; w++){
            weekPaket.add("Minggu Ke "+Integer.toString(w));
        }

    }

    protected void bulanPaket(){

        for (int m = 1; m <= 12; m++){
            montPaket.add(Integer.toString(m));
        }
    }

    protected String getIdInstansi(int a){

        idInstansi = "";

        try {
            JSONObject json = instansiId.getJSONObject(a);
            idInstansi = json.getString("idInstansi");

        }catch (Exception e){

        }
        return idInstansi;
    }

    protected String getIdBayar(int b){

        idBayar = "";

        try {
            JSONObject objBayar = bayarId.getJSONObject(b);
            idBayar = objBayar.getString("idJenisBayar");

        }catch (Exception e){

        }

        return idBayar;
    }

    protected String getIdBank(int c){

        idBank = "";

        try {

            JSONObject objBank = bankId.getJSONObject(c);
            idBank = objBank.getString("idBank");

        }catch (Exception e){

        }
        return idBank;
    }

    protected String getIdDownpaymetn(int d){

        idDownP = "";
        try {

            JSONObject objIdDp = downPaymentArr.getJSONObject(d);
            idDownP = objIdDp.getString("idDp");

        }catch (Exception e){

        }
        return idDownP;
    }

    protected String getIdProvinsi(int p){
        idProvi= "";

        try {

            JSONObject provObj = provinsiArray.getJSONObject(p);
            idProvi = provObj.getString("idProvinsi");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return idProvi;
    }

    protected String getIdKabupaten(int idKabs){

        String kabsId = "";

        try {

            JSONObject provObj = kabupatenArray.getJSONObject(idKabs);
            kabsId = provObj.getString("idKabupaten");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return kabsId;
    }

    protected String getIdKecamatan(int camatId){

        String  idCamat= "";

        try {

            JSONObject provObj = kecamatanArray.getJSONObject(camatId);
            idCamat = provObj.getString("idKecamatan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return idCamat;
    }

    protected String getIdKelurahan(int lurahId){

        String  idLurah= "";

        try {

            JSONObject lurahObj = kelurahanArray.getJSONObject(lurahId);
            idLurah = lurahObj.getString("idKelurahan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return idLurah;
    }

    protected String getKodePos(int posId){

        String  idPos= "";

        try {

            JSONObject posObj = kelurahanArray.getJSONObject(posId);
            idPos = posObj.getString("kodePos");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return idPos;
    }

    public String getIdUkuran(int bajus){

        String sbaju = "";

        try {

            JSONObject provObj = bajuArray.getJSONObject(bajus);
            sbaju = provObj.getString("idUkuran");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sbaju;
    }

    public String getIdPendidikan(int didiks){

        String sdidik = "";

        try {

            JSONObject didikObj = pendidikanArray.getJSONObject(didiks);
            sdidik = didikObj.getString("idPendidikan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sdidik;

    }

    public String idPerkerjaan(int provesi){

        String proves = "";

        try {

            JSONObject kerjaObj = pekerjaanArray.getJSONObject(provesi);
            proves = kerjaObj.getString("idPekerjaan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return proves;

    }

    public String getIdMahram(int stats){

        String stMahram = "";

        try {

            JSONObject statObj = mahramArray.getJSONObject(stats);
            stMahram = statObj.getString("idStatusMahram");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stMahram;

    }

    public String idHubungan(int ikatan){

        String hubungans = "";

        try {

            JSONObject hubunganObj = hubunganArray.getJSONObject(ikatan);
            hubungans = hubunganObj.getString("idHubungan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return hubungans;
    }

    public String idPenyakit(int sakits){

        String idSakit = "";

        try {

            JSONObject sakitObj = penyakitArray.getJSONObject(sakits);
            idSakit = sakitObj.getString("idPenyakit");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return idSakit;
    }

    public void tahunSakit(){

        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1978; i <= thisYear; i++) {
            tahunSakitArray.add(Integer.toString(i));
        }

    }

    public void getMont(){

        for (int i =1; i<=12;i++){

            lamaList.add(Integer.toString(i));
        }

    }

}
