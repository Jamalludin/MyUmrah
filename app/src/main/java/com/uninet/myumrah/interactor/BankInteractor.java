package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.DaftarUtil.INSTANSI_ID;
import static com.uninet.myumrah.util.Url.LIST_BANK;

public class BankInteractor {
    public RequestQueue requestQueue;

    public BankInteractor(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void BankRequest(final ListBank banklist){

        StringRequest requestBank = new StringRequest(Request.Method.GET, LIST_BANK+INSTANSI_ID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i("bank", response.toString());
                banklist.bank(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(requestBank);
    }

    public interface ListBank{
        void bank(String bank);
    }
}
