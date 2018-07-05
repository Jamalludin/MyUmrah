package com.uninet.myumrah.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uninet.myumrah.MainActivity;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.approval.JamaahApprovalActivity;
import com.uninet.myumrah.activity.daftar_umroh.ListPaketActivity;
import com.uninet.myumrah.activity.login_aplikasi.LoginActivity;
import com.uninet.myumrah.activity.login_aplikasi.Session;
import com.uninet.myumrah.activity.status.CekBayarDownpaymentActivity;
import com.uninet.myumrah.activity.status.CekBayarFullPaymentActivity;
import com.uninet.myumrah.activity.status.CekBayarMahramActivity;
import com.uninet.myumrah.activity.status.CekIdJamaahdanNoVaActivity;
import com.uninet.myumrah.activity.status.CekSuratPenambahanTigaKataActivity;
import com.uninet.myumrah.activity.status.CekSuratRekomendasiPasporActivity;
import com.uninet.myumrah.activity.status.JadwalKeberangkatanActivity;
import com.uninet.myumrah.activity.status.JadwalManasikActivity;
import com.uninet.myumrah.activity.status.StatusAkomodasiActivity;
import com.uninet.myumrah.activity.status.StatusPasporActivity;
import com.uninet.myumrah.activity.status.StatusPengirimanKelengkapanActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanBankActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanKoperasiActivity;
import com.uninet.myumrah.activity.status.StatusPersetujuanTravelActivity;
import com.uninet.myumrah.activity.status.StatusVisaActivity;
import com.uninet.myumrah.activity.status.SuratKeteranganMahramActivity;
import com.uninet.myumrah.activity.status.SuratKeteranganUmrohActivity;
import com.uninet.myumrah.model.JadwalManasik;

import static com.uninet.myumrah.util.DaftarUtil.ROLE_USER;

public class MenuStatusActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView approvalBendahara;
    private CardView approvalBank;
    private CardView approvalTravel;
    private CardView idJamaahAndVA;
    private CardView bayarDownpayment;
    private CardView bayarFullpayment;
    private CardView bayarCicilan;
    private CardView bayarMahram;
    private CardView bayarGantiJamaah;
    private CardView kelengkapanDocument;
    private CardView rekomendasiPaspor;
    private CardView penambahanTigaKata;
    private CardView keteranganUmroh;
    private CardView keteranganMahram;
    private CardView paspor;
    private CardView visa;
    private CardView pengirimanKelengkapan;
    private CardView jadwalManasik;
    private CardView jadwalKeberangkatan;
    private CardView perubahanJamaah;
    private CardView perubahanKeluarga;
    private CardView perubahanMahram;
    private CardView akomodasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_status);

        approvalBendahara       = (CardView)findViewById(R.id.cardView_approvalBendahara);
        approvalBank            = (CardView)findViewById(R.id.cardView_approvalbank);
        approvalTravel          = (CardView)findViewById(R.id.cardView_approvalTravel);
        idJamaahAndVA           = (CardView)findViewById(R.id.cardView_idJamaahVa);
        bayarDownpayment        = (CardView)findViewById(R.id.cardView_bayarDP);
        bayarFullpayment        = (CardView)findViewById(R.id.cardView_bayarFP);
        bayarCicilan            = (CardView)findViewById(R.id.cardView_bayarCicilan);
        bayarMahram             = (CardView)findViewById(R.id.cardView_bayarMaharam);
        bayarGantiJamaah        = (CardView)findViewById(R.id.cardView_gantiJamaah);
        kelengkapanDocument     = (CardView)findViewById(R.id.cardView_kelengkapanDoc);
        rekomendasiPaspor       = (CardView)findViewById(R.id.cardView_rekomendasiPaspor);
        penambahanTigaKata      = (CardView)findViewById(R.id.cardView_tigaKata);
        keteranganUmroh         = (CardView)findViewById(R.id.cardView_keteranganUmroh);
        keteranganMahram        = (CardView)findViewById(R.id.cardView_keteranganMahram);
        paspor                  = (CardView)findViewById(R.id.cardView_paspor);
        visa                    = (CardView)findViewById(R.id.cardView_visa);
        pengirimanKelengkapan   = (CardView)findViewById(R.id.cardView_kirimPerlengkapan);
        jadwalManasik           = (CardView)findViewById(R.id.cardView_jadwalManasik);
        jadwalKeberangkatan     = (CardView)findViewById(R.id.cardView_jadwalKeberangkatan);
        perubahanJamaah         = (CardView)findViewById(R.id.cardView_perubahanJamaah);
        perubahanKeluarga       = (CardView)findViewById(R.id.cardView_perubahanKeluarga);
        perubahanMahram         = (CardView)findViewById(R.id.cardView_perubahanMaram);
        akomodasi               = (CardView)findViewById(R.id.cardView_akomodasi);

        approvalBendahara.setOnClickListener(this);
        approvalBank.setOnClickListener(this);
        approvalTravel.setOnClickListener(this);
        idJamaahAndVA.setOnClickListener(this);
        bayarDownpayment.setOnClickListener(this);
        bayarFullpayment.setOnClickListener(this);
        bayarCicilan.setOnClickListener(this);
        bayarMahram.setOnClickListener(this);
        bayarGantiJamaah.setOnClickListener(this);
        kelengkapanDocument.setOnClickListener(this);
        rekomendasiPaspor.setOnClickListener(this);
        penambahanTigaKata.setOnClickListener(this);
        keteranganMahram.setOnClickListener(this);
        keteranganUmroh.setOnClickListener(this);
        paspor.setOnClickListener(this);
        visa.setOnClickListener(this);
        pengirimanKelengkapan.setOnClickListener(this);
        jadwalManasik.setOnClickListener(this);
        jadwalKeberangkatan.setOnClickListener(this);
        perubahanJamaah.setOnClickListener(this);
        perubahanKeluarga.setOnClickListener(this);
        perubahanMahram.setOnClickListener(this);
        akomodasi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cardView_approvalBendahara:
                startActivity(new Intent(this, StatusPersetujuanKoperasiActivity.class));
                break;

            case R.id.cardView_approvalbank:
                startActivity(new Intent(this, StatusPersetujuanBankActivity.class));
                break;

            case R.id.cardView_approvalTravel:
                startActivity(new Intent(this, StatusPersetujuanTravelActivity.class));
                break;

            case R.id.cardView_idJamaahVa:
                startActivity(new Intent(this, CekIdJamaahdanNoVaActivity.class));
                break;

            case R.id.cardView_bayarDP:
                startActivity(new Intent(this, CekBayarDownpaymentActivity.class));
                break;

            case R.id.cardView_bayarFP:
                startActivity(new Intent(this, CekBayarFullPaymentActivity.class));
                break;

            case R.id.cardView_bayarCicilan:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_bayarMaharam:
                startActivity(new Intent(this, CekBayarMahramActivity.class));
                break;

            case R.id.cardView_gantiJamaah:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_kelengkapanDoc:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_rekomendasiPaspor:
                startActivity(new Intent(this, CekSuratRekomendasiPasporActivity.class));
                break;

            case R.id.cardView_tigaKata:
                startActivity(new Intent(this, CekSuratPenambahanTigaKataActivity.class));
                break;

            case R.id.cardView_keteranganUmroh:
                startActivity(new Intent(this, SuratKeteranganUmrohActivity.class));
                break;

            case R.id.cardView_keteranganMahram:
                startActivity(new Intent(this, SuratKeteranganMahramActivity.class));
                break;

            case R.id.cardView_paspor:
                startActivity(new Intent(this, StatusPasporActivity.class));
                break;

            case R.id.cardView_visa:
                startActivity(new Intent(this, StatusVisaActivity.class));
                break;

            case R.id.cardView_kirimPerlengkapan:
                startActivity(new Intent(this, StatusPengirimanKelengkapanActivity.class));
                break;

            case R.id.cardView_jadwalManasik:
                startActivity(new Intent(this, JadwalManasikActivity.class));
                break;

            case R.id.cardView_jadwalKeberangkatan:
                startActivity(new Intent(this, JadwalKeberangkatanActivity.class));
                break;

            case R.id.cardView_perubahanJamaah:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_perubahanKeluarga:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_perubahanMaram:
                //startActivity(new Intent(this,));
                break;

            case R.id.cardView_akomodasi:
                startActivity(new Intent(this, StatusAkomodasiActivity.class));
                break;
        }
    }
}
