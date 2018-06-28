package com.uninet.myumrah.presenter;

import android.content.Context;

import com.uninet.myumrah.interactor.ApprovalInteractor;
import com.uninet.myumrah.interactor.DataTambahanInteractor;
import com.uninet.myumrah.view.DataTambahanView;

import org.json.JSONObject;

public class DataTambahanPresenter {

    private DataTambahanView dataTambahanView;
    private DataTambahanInteractor dataTambahanInteractor;
    private ApprovalInteractor approvalInteractor;

    public DataTambahanPresenter(DataTambahanView dataTambahanView, Context context) {
        this.dataTambahanView = dataTambahanView;
        dataTambahanInteractor = new DataTambahanInteractor(context);
        approvalInteractor = new ApprovalInteractor(context);
    }

    public void setDaftar(String daftar){
        dataTambahanInteractor.daftar(daftar, new DataTambahanInteractor.Save() {
            @Override
            public void Hasil(String hasil) {
                dataTambahanView.daftar(hasil);
            }
        });
    }

    public void setSaveApproval(String saveApproval){
        approvalInteractor.approvalSave(saveApproval, new ApprovalInteractor.ApprovalSave() {
            @Override
            public void approvalSave(String approvalSave) {
                dataTambahanView.approval(approvalSave);
            }
        });
    }

    public void setProvinsi(){
        dataTambahanInteractor.provinsi(new DataTambahanInteractor.ProvinsiList() {
            @Override
            public void provinsi(String provinsi) {
                dataTambahanView.provinsi(provinsi);
            }
        });
    }

    public void setKabupaten(){
        dataTambahanInteractor.kabupaten(new DataTambahanInteractor.KabupatenList() {
            @Override
            public void kabupaten(String kabupaten) {
                dataTambahanView.kabupaten(kabupaten);
            }
        });
    }

    public void setKecamatan(){
        dataTambahanInteractor.kecamatan(new DataTambahanInteractor.KecamatanList() {
            @Override
            public void kecamatan(String kecamatan) {
                dataTambahanView.kecamatan(kecamatan);
            }
        });
    }

    public void setKelurahan(){
        dataTambahanInteractor.kelurahan(new DataTambahanInteractor.KelurahanList() {
            @Override
            public void kelurahan(String kelurahan) {
                dataTambahanView.kelurahan(kelurahan);
            }
        });
    }

    public void setBaju(){
        dataTambahanInteractor.ukuranBaju(new DataTambahanInteractor.UkuranBajuList() {
            @Override
            public void baju(String baju) {
                dataTambahanView.ukuranBaju(baju);
            }
        });
    }

    public void setMahram(){
        dataTambahanInteractor.mahram(new DataTambahanInteractor.MahramList() {
            @Override
            public void mahram(String mahram) {
                dataTambahanView.mahram(mahram);
            }
        });
    }

    public void setPendidikan(){
        dataTambahanInteractor.pendidikan(new DataTambahanInteractor.PendidikanList() {
            @Override
            public void pendidikan(String pendidikan) {
                dataTambahanView.pendidikan(pendidikan);
            }
        });
    }

    public void setPekerjaan(){
        dataTambahanInteractor.pekerjaan(new DataTambahanInteractor.PekerjaanList() {
            @Override
            public void pekerjaan(String pekerjaan) {
                dataTambahanView.pekerjaan(pekerjaan);
            }
        });
    }

    public void setPenyakit(){
        dataTambahanInteractor.penyakit(new DataTambahanInteractor.PenyakitList() {
            @Override
            public void penyakit(String penyakit) {
                dataTambahanView.penyakit(penyakit);
            }
        });
    }

    public void setHubungan(){
        dataTambahanInteractor.hubungan(new DataTambahanInteractor.HubunganList() {
            @Override
            public void hubungan(String hubungan) {
                dataTambahanView.hubungan(hubungan);
            }
        });
    }
}
