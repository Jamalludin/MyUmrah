package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.uninet.myumrah.util.Url.REGISTER;

public class RegisterInteractor {

    public RequestQueue registerReq;

    public RegisterInteractor(Context context){

        registerReq = Volley.newRequestQueue(context);
    }

    public void RegisterRequest(JSONObject objRegis, final Register register){
        JsonObjectRequest objectRegister = new JsonObjectRequest(Request.Method.POST, REGISTER, objRegis, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("register", response.toString());
                register.Result(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        registerReq.add(objectRegister);
    }

    public interface Register{

        void Result (String result);
    }
}
