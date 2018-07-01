package com.uninet.myumrah.presenter;

import com.uninet.myumrah.model.DataDiriModel;
import com.uninet.myumrah.view.DataDiriView;

public class DataDiriPresenter implements IDataDiri{

    private DataDiriView dataDiriView;

    public DataDiriPresenter(DataDiriView dataDiriView) {
        this.dataDiriView = dataDiriView;
    }

    @Override
    public void validasi(String namaLengkap, String namaAyah, String tempatLahir, String noKK, String nik, String noHP, String email, String tglLahir, String jenisKelamin, String statusPerkawinan, String kewargaNegaraan, String golonganDarah) {

        DataDiriModel diri = new DataDiriModel(namaLengkap,namaAyah,tempatLahir,noKK,nik,noHP, email,
                tglLahir,jenisKelamin,statusPerkawinan,kewargaNegaraan,golonganDarah);

        int codeModel = diri.isValidasi();

        if (codeModel == 0)
            dataDiriView.validasiDataError("Mohon Isi Nama Lengkap");
        else if (codeModel == 1)
            dataDiriView.validasiDataError("Mohon Isi Nama Ayah");
        else if (codeModel == 2)
            dataDiriView.validasiDataError("Mohon Isi Tempat Lahir");
        else if (codeModel == 3)
            dataDiriView.validasiDataError("Mohon Isi Nomor Kartu Keluarga");
        else if (codeModel == 4)
            dataDiriView.validasiDataError("Nomor Kartu Keluarga Harus 16 Digit");
        else if (codeModel == 5)
            dataDiriView.validasiDataError("Mohon Isi Nomor Induk KTP");
        else if (codeModel == 6)
            dataDiriView.validasiDataError("Nomor Induk KTP Harus 16 Digit");
        else if (codeModel == 7)
            dataDiriView.validasiDataError("Mohon Isi Nomor Handphone");
        else if (codeModel == 8)
            dataDiriView.validasiDataError("Nomor HP Minimal 11 Digit");
        else if (codeModel == 9)
            dataDiriView.validasiDataError("Mohon Isi Email");
        else if (codeModel == 10)
            dataDiriView.validasiDataError("Isi Email Sesuai Format");
        else if (codeModel == 11)
            dataDiriView.validasiDataError("Mohon Isi Tanggal Lahir");

        else
            dataDiriView.validasiDataSuccess("");
    }
}
