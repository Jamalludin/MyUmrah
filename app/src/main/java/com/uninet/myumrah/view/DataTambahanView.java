package com.uninet.myumrah.view;

public interface DataTambahanView {
    void validasiDataSuccess(String data);
    void validasiDataError(String data);
    void daftar(String daftar);
    void provinsi(String provinsi);
    void kabupaten(String kabupaten);
    void kecamatan(String kecamatan);
    void kelurahan(String kelurahan);
    void ukuranBaju(String baju);
    void mahram (String mahram);
    void pendidikan(String pendidikan);
    void pekerjaan(String pekerjaan);
    void penyakit(String penyakit);
    void hubungan(String hubungan);

}
