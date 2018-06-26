package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.Url.CARA_BAYAR;

public class CaraBayarInteractor {
    public RequestQueue bayarRequest;

    public CaraBayarInteractor(Context context) {
        bayarRequest = Volley.newRequestQueue(context);
    }

    public void CaraBayarRequest(final ListBayar bayarList){
        StringRequest requestBayar = new StringRequest(Request.Method.GET, CARA_BAYAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("bayar",response.toString());
                bayarList.bayar(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        bayarRequest.add(requestBayar);
    }

    public interface ListBayar{
        void bayar(String bayar);
    }
}
