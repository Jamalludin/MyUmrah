package com.uninet.myumrah.activity.approval;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.AbstracGenericActivity;
import com.uninet.myumrah.activity.login_aplikasi.Session;
import com.uninet.myumrah.adapter.ApprovalAdapter;
import com.uninet.myumrah.model.ListJamaah;
import com.uninet.myumrah.presenter.ApprovalPresenter;
import com.uninet.myumrah.view.ApprovalView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.uninet.myumrah.util.DaftarUtil.ROLE_USER;

public class JamaahApprovalActivity extends AbstracGenericActivity implements ApprovalView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jamah_approval);

        mRecyclerView   = (RecyclerView) findViewById(R.id.list_jamaah);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        approvalPresenter = new ApprovalPresenter(this, getApplicationContext());
        approvalPresenter.setListApproval();
    }

    @Override
    public void listJamaah(String listJamah) {

        List<ListJamaah> approvalJamaah = new ArrayList<>();

        try {

            JsonParser parser = new JsonParser();
            JsonObject approval = parser.parse(listJamah).getAsJsonObject();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

            Type listType = new TypeToken<List<ListJamaah>>() {}.getType();
            approvalJamaah = gson.fromJson(approval.get("data"), listType);

        }catch (Exception e){

        }

        mAdapter = new ApprovalAdapter(approvalJamaah);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void detailJamaah(String detailJamaah) {

    }

    @Override
    public void approvalJamaah(String approvalJamaah) {

    }

    @Override
    public void updateJamaah(String updateJamaah) {

    }
}
