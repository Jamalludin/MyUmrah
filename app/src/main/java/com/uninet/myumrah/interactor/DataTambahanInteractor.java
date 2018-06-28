package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.uninet.myumrah.util.DaftarUtil.KABUPATEN_ID;
import static com.uninet.myumrah.util.DaftarUtil.KECAMATAN_ID;
import static com.uninet.myumrah.util.DaftarUtil.PROVINSI_ID;
import static com.uninet.myumrah.util.Url.DAFTAR;
import static com.uninet.myumrah.util.Url.HUBUNGAN;
import static com.uninet.myumrah.util.Url.KABUPATEN;
import static com.uninet.myumrah.util.Url.KECAMATAN;
import static com.uninet.myumrah.util.Url.KELURAHAN;
import static com.uninet.myumrah.util.Url.MAHRAM;
import static com.uninet.myumrah.util.Url.PEKERJAAN;
import static com.uninet.myumrah.util.Url.PENDIDIKAN;
import static com.uninet.myumrah.util.Url.PENYAKIT;
import static com.uninet.myumrah.util.Url.PROVINSI;
import static com.uninet.myumrah.util.Url.UKURAN_BAJU;

public class DataTambahanInteractor {
    public RequestQueue requestDataTambahan;

    public DataTambahanInteractor(Context context) {
        requestDataTambahan = Volley.newRequestQueue(context);
    }

    public void provinsi(final ProvinsiList provinsiList){
        StringRequest requestProvinsi = new StringRequest(Request.Method.GET, PROVINSI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("provinsi", response.toString());
                provinsiList.provinsi(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestProvinsi);

    }

    public void kabupaten(final KabupatenList kabupatenList){
        StringRequest requestKabupaten = new StringRequest(Request.Method.GET, KABUPATEN+PROVINSI_ID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("kabupaten", response.toString());
                kabupatenList.kabupaten(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestKabupaten);
    }

    public void kecamatan(final KecamatanList kecamatanList){
        StringRequest requestKecamatan = new StringRequest(Request.Method.POST, KECAMATAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("kecamatan", response.toString());
                kecamatanList.kecamatan(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> data = new HashMap<>();
                data.put("idProvinsi",PROVINSI_ID);
                data.put("idKabupaten",KABUPATEN_ID);
                return data;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        requestDataTambahan.add(requestKecamatan);
    }

    public void kelurahan(final KelurahanList kelurahanList){
        StringRequest requestKelurahan = new StringRequest(Request.Method.POST, KELURAHAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("kelurahan", response.toString());
                kelurahanList.kelurahan(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> data = new HashMap<>();
                data.put("idProvinsi",PROVINSI_ID);
                data.put("idKabupaten",KABUPATEN_ID);
                data.put("idKecamatan",KECAMATAN_ID);
                return data;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        requestDataTambahan.add(requestKelurahan);

    }

    public void ukuranBaju(final UkuranBajuList ukuranBajuList){
        StringRequest requestBaju = new StringRequest(Request.Method.GET, UKURAN_BAJU, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("ukuranBaju", response.toString());
                ukuranBajuList.baju(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestBaju);
    }

    public void mahram(final MahramList mahramList){
        StringRequest requestMahram = new StringRequest(Request.Method.GET, MAHRAM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("mahram", response.toString());
                mahramList.mahram(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestMahram);
    }

    public void pendidikan(final PendidikanList pendidikanList){
        StringRequest requestPendidikan = new StringRequest(Request.Method.GET, PENDIDIKAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("pendidikan", response.toString());
                pendidikanList.pendidikan(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestPendidikan);
    }

    public void pekerjaan(final PekerjaanList pekerjaanList){
        StringRequest requestPekerjaan = new StringRequest(Request.Method.GET, PEKERJAAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("pekerjaan", response.toString());
                pekerjaanList.pekerjaan(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestPekerjaan);
    }

    public void penyakit(final PenyakitList penyakitList){
        StringRequest requestPenyakit = new StringRequest(Request.Method.GET, PENYAKIT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("penyakit",response.toString());
                penyakitList.penyakit(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestPenyakit);
    }

    public void hubungan(final HubunganList hubunganList){
        StringRequest requestHubungan = new StringRequest(Request.Method.GET, HUBUNGAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("hubungan",response.toString());
                hubunganList.hubungan(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDataTambahan.add(requestHubungan);

    }

    public void daftar(final String json, final Save save){
        JsonObjectRequest requestDaftar = new JsonObjectRequest(Request.Method.POST, DAFTAR, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("daftar", response.toString());
                save.Hasil(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            public byte[] getBody() {
                return json.getBytes();
            }
        };
        requestDataTambahan.add(requestDaftar);
    }

    public interface ProvinsiList{
        void provinsi(String provinsi);
    }

    public interface KabupatenList{
        void kabupaten(String kabupaten);
    }

    public interface KecamatanList{
        void kecamatan(String kecamatan);
    }

    public interface KelurahanList{
        void kelurahan(String kelurahan);
    }

    public interface UkuranBajuList{
        void baju(String baju);
    }

    public interface MahramList{
        void mahram(String mahram);
    }

    public interface PendidikanList{
        void pendidikan(String pendidikan);
    }

    public interface PekerjaanList{
        void pekerjaan(String pekerjaan);
    }

    public interface PenyakitList{
        void penyakit(String penyakit);
    }

    public interface HubunganList{
        void hubungan(String hubungan);
    }

    public interface Save{
        void Hasil(String hasil);
    }
}
