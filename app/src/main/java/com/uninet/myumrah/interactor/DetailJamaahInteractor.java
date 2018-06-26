package com.uninet.myumrah.interactor;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.uninet.myumrah.activity.AbstracGenericActivity.IDJAMAAH;
import static com.uninet.myumrah.util.Url.DETAIL_JAMAAH;

public class DetailJamaahInteractor {
    public RequestQueue queueDetail;

    public DetailJamaahInteractor(Context context) {
        queueDetail = Volley.newRequestQueue(context);
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
}
