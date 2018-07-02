package com.uninet.myumrah.util;

public class Url {

    public static final String HOST2             = "http://10.12.1.176:8080/myumrah-api";
    public static final String HOST              = "http://36.37.68.130:41009/myumrah-api";
    public static final String REGISTER          = HOST+"/public/users";
    public static final String LOGIN             = HOST+"/login";
    public static final String LAMA_HARI         = HOST+"/public/pakets/find-hariPaket";
    public static final String PAKET_UMROH       = HOST+"/public/pakets/find-by-spec";
    public static final String LIST_INSTANSI     = HOST+"/public/instansis/find";
    public static final String LIST_BANK         = HOST+"/public/banks/find-bank?idinstansi=";
    public static final String CARA_BAYAR        = HOST+"/public/bayars/find";
    public static final String DOWN_PAYMENT      = HOST+"/public/downpayments/find-by-idBank?idbank=";
    public static final String CICILAN_LIST      = HOST+"/public/cicilans/find-by-dp?id-talangan=";
    public static final String PROVINSI          = HOST+"/public/provinsis/find-provinsi";
    public static final String KABUPATEN         = HOST+"/public/kabupatens/find-by-provinsi?idProvinsi=";
    public static final String KECAMATAN         = HOST+"/public/kecamatans/find-by-idProvinsiAndIdKabupaten";
    public static final String KELURAHAN         = HOST+"/public/kelurahans/find";
    public static final String UKURAN_BAJU       = HOST+"/public/ukurans/find";
    public static final String MAHRAM            = HOST+"/public/mahrams/find";
    public static final String PENDIDIKAN        = HOST+"/public/pendidikans/find";
    public static final String PEKERJAAN         = HOST+"/public/pekerjaans/find";
    public static final String PENYAKIT          = HOST+"/public/penyakits/find";
    public static final String HUBUNGAN          = HOST+"/public/hubungans/find";
    public static final String DAFTAR            = HOST2+"/public/jamaahs/create";
    public static final String APPROVAL          = HOST+"/public/jamaahs/find-by-role?namaRole=";
    public static final String DETAIL_JAMAAH     = HOST+"/public/jamaahs/find-by-id?idJamaah=";
    public static final String TALANGAN          = HOST+"/public/talangans/find-by-dp";
    public static final String APPROVAL_KOPERASI = HOST2+"/public/approvals/update-koperasi";
    public static final String APPROVAL_BANK     = HOST+"/public/approvals/update-bank";
    public static final String APPROVAL_MYUMROH  = HOST+"/public/approvals/update-myumroh";
    public static final String APPROVAL_SAVE     = HOST2+"/public/approvals/creates";
    public static final String UPDATE_JAMAAH     = HOST2+"/public/jamaahs/update";
    public static final String JAMAAH_PENYAKIT   = HOST2+"/public/penyakits/create";
    public static final String FIND_USER         = HOST2+"/public/jamaahs/find-namaUser?namaUser=";
    public static final String TAGIHAN_BAYAR     = HOST2+"";

}
