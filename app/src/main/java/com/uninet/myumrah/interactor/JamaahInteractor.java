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

import static com.uninet.myumrah.activity.AbstracGenericActivity.IDJAMAAH;
import static com.uninet.myumrah.util.Url.DETAIL_JAMAAH;
import static com.uninet.myumrah.util.Url.UPDATE_JAMAAH;

public class JamaahInteractor {
    public RequestQueue queueDetail;

    public JamaahInteractor(Context context) {
        queueDetail = Volley.newRequestQueue(context);
    }

    public void updateJamaah(final String jamaahUpdate, final UpdateJamaah updateJamaah){
        JsonObjectRequest updateRequest = new JsonObjectRequest(Request.Method.PUT, UPDATE_JAMAAH, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("updateJamaah", response.toString());
                updateJamaah.updateJamaah(response.toString());
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
                return jamaahUpdate.getBytes();
            }
        };
        queueDetail.add(updateRequest);
    }

    public void detailJamaah(final DataJamaah dataJamaah){
        StringRequest requestJamaah = new StringRequest(Request.Method.GET, DETAIL_JAMAAH+IDJAMAAH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("jamaahDetail",response.toString());
                dataJamaah.dataJamaah(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queueDetail.add(requestJamaah);

    }

    public interface DataJamaah{
        void dataJamaah (String dataJamaah);
    }

    public interface UpdateJamaah{
        void updateJamaah(String updateJamaah);
    }
}
