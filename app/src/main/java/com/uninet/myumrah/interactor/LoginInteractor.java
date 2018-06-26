package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.uninet.myumrah.fragment.LoginFragment.PASSWORD;
import static com.uninet.myumrah.fragment.LoginFragment.USER_LOGIN;
import static com.uninet.myumrah.util.Url.LOGIN;

public class LoginInteractor {
    public RequestQueue loginRequest;
    private int code;

    public LoginInteractor(Context context) {
        loginRequest = Volley.newRequestQueue(context);
    }

    public void LoginRequest(final Login login){

        StringRequest loginReq = new StringRequest(Request.Method.POST, LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("login", response.toString());
                login.Hasil(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                login.Hasil(String.valueOf(code));
            }
        }){

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                code = response.statusCode;
                return super.parseNetworkResponse(response);

            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("username",USER_LOGIN);
                map.put("password",PASSWORD);
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        loginRequest.add(loginReq);

    }

    public interface Login{
        void Hasil (String hasil);
    }
}
