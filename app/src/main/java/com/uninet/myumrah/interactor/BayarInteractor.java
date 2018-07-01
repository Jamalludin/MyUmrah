package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.DaftarUtil.NAMA_USER;
import static com.uninet.myumrah.util.Url.TAGIHAN_BAYAR;

public class BayarInteractor {
    public RequestQueue requestBayar;

    public BayarInteractor(Context context) {
        requestBayar = Volley.newRequestQueue(context);
    }

    public void tagihanBayar(final Tagihan tagihan){
        StringRequest tagihanRequest = new StringRequest(Request.Method.GET, TAGIHAN_BAYAR + NAMA_USER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("tagihan",response.toString());
                tagihan.tagihan(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestBayar.add(tagihanRequest);
    }

    public interface Tagihan{
        void tagihan(String tagihanBayar);
    }
}
