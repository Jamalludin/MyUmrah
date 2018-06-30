package com.uninet.myumrah.util;

public class Url {

    public static final String HOST2             = "http://192.168.43.168:8080/myumrah-api";
    public static final String HOST              = "http://36.37.68.130:41009/myumrah-api";
    public static final String REGISTER          = HOST+"/public/users";
    public static final String LOGIN             = HOST+"/login";
    public static final String PAKET_UMROH       = HOST+"/public/paket/find-hariPakets";
    public static final String LIST_INSTANSI     = HOST+"/public/instansi/finds";
    public static final String LIST_BANK         = HOST+"/public/bank/find-banks?idinstansi=";
    public static final String CARA_BAYAR        = HOST+"/public/bayar/finds";
    public static final String DOWN_PAYMENT      = HOST+"/public/downpayment/find-by-idBank?idbank=";
    public static final String CICILAN_LIST      = HOST+"/public/cicilan/find-by-dp?id-talangan=";
    public static final String PROVINSI          = HOST+"/public/provinsi/find-provinsi";
    public static final String KABUPATEN         = HOST+"/public/kabupaten/find-by-provinsis?idProvinsi=";
    public static final String KECAMATAN         = HOST+"/public/kecamatan/find-by-idProvinsiAndIdKabupaten";
    public static final String KELURAHAN         = HOST+"/public/kelurahan/finds";
    public static final String UKURAN_BAJU       = HOST+"/public/ukuran/finds";
    public static final String MAHRAM            = HOST+"/public/mahram/finds";
    public static final String PENDIDIKAN        = HOST+"/public/pendidikan/finds";
    public static final String PEKERJAAN         = HOST+"/public/pekerjaan/finds";
    public static final String PENYAKIT          = HOST+"/public/penyakit/finds";
    public static final String HUBUNGAN          = HOST+"/public/hubungan/finds";
    public static final String DAFTAR            = HOST2+"/public/jamaah/creates";
    public static final String APPROVAL          = HOST+"/public/jamaah/find-by-role?namaRole=ROLE_BANDAHARA_KOPERASI";
    public static final String DETAIL_JAMAAH     = HOST+"/public/jamaah/find-by-id?idJamaah=";
    public static final String TALANGAN          = HOST+"/public/talangan/find-by-dp";
    public static final String APPROVAL_KOPERASI = HOST2+"/public/approval/update-koperasi";
    public static final String APPROVAL_BANK     = HOST+"/public/approval/update-bank";
    public static final String APPROVAL_MYUMROH  = HOST+"/public/approval/update-myumroh";
    public static final String APPROVAL_SAVE     = HOST2+"/public/approval/creates";
    public static final String UPDATE_JAMAAH     = HOST2+"/public/jamaah/updates";
    public static final String JAMAAH_PENYAKIT   = HOST2+"/public/penyakit/creates";

}
