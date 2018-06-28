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
import com.uninet.myumrah.util.DaftarUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.uninet.myumrah.util.DaftarUtil.BANKID;
import static com.uninet.myumrah.util.DaftarUtil.IDDP;
import static com.uninet.myumrah.util.DaftarUtil.TOTAL_TALANGAN;
import static com.uninet.myumrah.util.Url.CICILAN_LIST;
import static com.uninet.myumrah.util.Url.TALANGAN;

public class CicilanInteractor {
    public RequestQueue requestCicilan;

    public CicilanInteractor(Context context) {
        requestCicilan = Volley.newRequestQueue(context);
    }

    public void Cicilan(final CicilanList cicilanList){
        StringRequest cicilanReq = new StringRequest(Request.Method.GET, CICILAN_LIST+ DaftarUtil.TALANGAN_ID+"&id-bank="+BANKID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("cicilan", response.toString());
                cicilanList.CicilanList(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestCicilan.add(cicilanReq);
    }

    public void talangan(final TalanganList talanganList){
        StringRequest talanganRequest = new StringRequest(Request.Method.POST, TALANGAN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("talangan",response.toString());
                talanganList.TalanganList(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> data = new HashMap<>();
                data.put("nominalDP",String.valueOf(TOTAL_TALANGAN));
                data.put("idBank",BANKID);
                return data;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        requestCicilan.add(talanganRequest);
    }

    public interface CicilanList{
        void CicilanList(String cicilanList);
    }

    public interface TalanganList{
        void TalanganList(String talangan);
    }
}
