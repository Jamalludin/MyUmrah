package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.Url.LIST_INSTANSI;

public class InstansiInteractor {
    public RequestQueue requestInstan;

    public InstansiInteractor(Context context) {
        requestInstan = Volley.newRequestQueue(context);
    }

    public void InstansiRequest(final ListInstansi instansiList){

        StringRequest requestInstansi = new StringRequest(Request.Method.GET, LIST_INSTANSI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("instansi", response.toString());
                instansiList.instansi(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestInstan.add(requestInstansi);
    }

    public interface ListInstansi{
        void instansi(String instansi);
    }
}
