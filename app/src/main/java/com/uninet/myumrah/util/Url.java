package com.uninet.myumrah.util;

public class Url {

    public static final String HOST            = "http://36.37.68.130:41009/myumrah-api/";
    public static final String REGISTER        = HOST+"public/users";
    public static final String LOGIN           = HOST+"login";
    public static final String PAKET_UMROH     = HOST+"public/pakets";
    public static final String LIST_INSTANSI   = HOST+"public/instansis";
    public static final String LIST_BANK       = HOST+"public/banks?idinstansi=";
    public static final String CARA_BAYAR      = HOST+"public/cara-bayars";
    public static final String DOWN_PAYMENT    = HOST+"public/downpayments?idbank=";
    public static final String CICILAN_LIST    = HOST+"public/cicilans?id-talangan=";
    public static final String PROVINSI        = HOST+"public/provinsis";
    public static final String KABUPATEN       = HOST+"public/kabupatens?idProvinsi=";
    public static final String KECAMATAN       = HOST+"public/kecamatans";
    public static final String KELURAHAN       = HOST+"public/kelurahans";
    public static final String UKURAN_BAJU     = HOST+"public/ukurans";
    public static final String MAHRAM          = HOST+"public/mahrams";
    public static final String PENDIDIKAN      = HOST+"public/pendidikans";
    public static final String PEKERJAAN       = HOST+"public/pekerjaans";
    public static final String PENYAKIT        = HOST+"public/penyakits";
    public static final String HUBUNGAN        = HOST+"public/hubungans";
    public static final String DAFTAR          = HOST+"public/jamaahs";
    public static final String APPROVAL        = HOST+"public/jamaah/find-by-role?namaRole=ROLE_ADMINISTRATOR";
    public static final String DETAIL_JAMAAH   = HOST+"public/jamaah/find-by-id?idJamaah=";
    public static final String TALANGAN        = HOST+"public/talangan-dp";
    public static final String APPROVAL_KOPERASI = HOST+"public/approval-koperasis";
    public static final String APPROVAL_BANK = HOST+"public/approval-banks";
    public static final String APPROVAL_MYUMROH = HOST+"public/approval-myumrohs";
    public static final String APPROVAL_SAVE = HOST+"public/save-approval";

    /*public static final String URL      = "http://10.12.1.176/";
    public static final String LOGIN    = URL+"myumroh/user/login.php";*/
}
