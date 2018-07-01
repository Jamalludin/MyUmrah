package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.Url.LAMA_HARI;

public class LamaPaketInteractor {
    public RequestQueue lamaPaket;

    public LamaPaketInteractor(Context context) {
        lamaPaket = Volley.newRequestQueue(context);
    }

    public void LamaPaketRequest(final LamaHari lamaHari){

        StringRequest requestLama = new StringRequest(Request.Method.GET, LAMA_HARI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("lama", response.toString());
                lamaHari.Hasil(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        lamaPaket.add(requestLama);
    }

    public interface LamaHari{
        void Hasil(String hasil);
    }
}
