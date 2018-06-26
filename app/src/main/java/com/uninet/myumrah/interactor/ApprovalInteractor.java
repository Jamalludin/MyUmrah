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

import static com.uninet.myumrah.util.Url.APPROVAL;
import static com.uninet.myumrah.util.Url.APPROVAL_BANK;
import static com.uninet.myumrah.util.Url.APPROVAL_KOPERASI;
import static com.uninet.myumrah.util.Url.APPROVAL_MYUMROH;
import static com.uninet.myumrah.util.Url.APPROVAL_SAVE;

public class ApprovalInteractor {
    public RequestQueue queueApproval;

    public ApprovalInteractor(Context context) {
        queueApproval = Volley.newRequestQueue(context);
    }

    public void approvalJamaah(final ListApproval listApproval){
            StringRequest requestApproval = new StringRequest(Request.Method.GET, APPROVAL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("approval", response.toString());
                listApproval.setuju(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queueApproval.add(requestApproval);
    }

    public void approvalKoperasi(final String koperasi, final ApprovalKoperasi approvalKoperasi){
        JsonObjectRequest requestKoperasi = new JsonObjectRequest(Request.Method.PUT, APPROVAL_KOPERASI, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("approvalKoperasi", response.toString());
                approvalKoperasi.approvalKoperasi(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            public byte[] getBody(){
                return koperasi.getBytes();
            }
        };
        queueApproval.add(requestKoperasi);

    }

    public void approvalBank(JSONObject bank, final ApprovalBank approvalBank){

        JsonObjectRequest requestBank = new JsonObjectRequest(Request.Method.PUT, APPROVAL_BANK, bank, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("approvalBank",response.toString());
                approvalBank.approvalBank(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queueApproval.add(requestBank);

    }

    public void approvalMyumroh(JSONObject myumroh, final ApprovalMyumroh approvalMyumroh){

        JsonObjectRequest requestMyumroh = new JsonObjectRequest(Request.Method.PUT, APPROVAL_MYUMROH, myumroh, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("approvalMyumroh",response.toString());
                approvalMyumroh.approvalMyumroh(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queueApproval.add(requestMyumroh);

    }

    public void approvalSave(JSONObject saveApproval, final ApprovalSave approvalSave){

        JsonObjectRequest requestSave = new JsonObjectRequest(Request.Method.POST, APPROVAL_SAVE, saveApproval, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("approvalSave",response.toString());
                approvalSave.approvalSave(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queueApproval.add(requestSave);

    }

    public interface ListApproval{
        void setuju(String setuju);
    }

    public interface ApprovalKoperasi{
        void approvalKoperasi(String approvalKoperasi);
    }

    public interface ApprovalBank{
        void approvalBank(String approvalBank);
    }

    public interface ApprovalMyumroh{
        void approvalMyumroh(String approvalMyumroh);
    }

    public interface ApprovalSave{
        void approvalSave(String approvalSave);
    }
}
