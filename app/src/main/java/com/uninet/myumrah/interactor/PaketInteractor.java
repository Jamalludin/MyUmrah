package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uninet.myumrah.model.Paket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.uninet.myumrah.util.DaftarUtil.BULAN;
import static com.uninet.myumrah.util.DaftarUtil.LAMA;
import static com.uninet.myumrah.util.DaftarUtil.MINGGU;
import static com.uninet.myumrah.util.DaftarUtil.TAHUN;
import static com.uninet.myumrah.util.Url.PAKET_UMROH;

public class PaketInteractor {

    public RequestQueue paketRequet;

    public PaketInteractor(Context context){
        paketRequet = Volley.newRequestQueue(context);
    }

    public void PaketRequest(final PaketList paketList){
        StringRequest requestPaket = new StringRequest(Request.Method.POST, PAKET_UMROH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("paketnya", response.toString());
                paketList.paket(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> data = new HashMap<>();
                data.put("hariPaket",LAMA);
                data.put("mingguPaket",MINGGU);
                data.put("bulanPaket",BULAN);
                data.put("tahunPaket",TAHUN);
                return data;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        paketRequet.add(requestPaket);
    }

    public interface PaketList{
        void paket(String pakes);
    }
}
