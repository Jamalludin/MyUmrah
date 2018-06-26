package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.util.DaftarUtil.BANKID;
import static com.uninet.myumrah.util.Url.DOWN_PAYMENT;

public class DownPaymentInteractor {
    public RequestQueue requestDownPayment;

    public DownPaymentInteractor(Context context) {
        requestDownPayment = Volley.newRequestQueue(context);
    }

    public void DownPayment(final DownPaymentList downPaymentList){
        StringRequest requestDP = new StringRequest(Request.Method.GET, DOWN_PAYMENT+BANKID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("downpayment", response.toString());
                downPaymentList.listDP(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestDownPayment.add(requestDP);
    }

    public interface DownPaymentList{
        void listDP (String listDP);
    }
}
