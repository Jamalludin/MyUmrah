package com.uninet.myumrah.presenter;

import android.content.Context;

import com.uninet.myumrah.interactor.ApprovalInteractor;
import com.uninet.myumrah.interactor.JamaahInteractor;
import com.uninet.myumrah.view.ApprovalView;

import org.json.JSONObject;

public class ApprovalPresenter {

    private ApprovalView approvalView;
    private ApprovalInteractor approvalInteractor;
    private JamaahInteractor jamaahInteractor;

    public ApprovalPresenter(ApprovalView approvalView, Context context) {
        this.approvalView = approvalView;
        approvalInteractor = new ApprovalInteractor(context);
        jamaahInteractor = new JamaahInteractor(context);
    }

    public void setListApproval(){
        approvalInteractor.approvalJamaah(new ApprovalInteractor.ListApproval() {
            @Override
            public void setuju(String setuju) {
                approvalView.listJamaah(setuju);
            }
        });
    }

    public void setUpdateJamaah(String jamaahUpdate){
        jamaahInteractor.updateJamaah(jamaahUpdate, new JamaahInteractor.UpdateJamaah() {
            @Override
            public void updateJamaah(String updateJamaah) {
                approvalView.updateJamaah(updateJamaah);
            }
        });
    }

    public void setDetailJamaah(){
        jamaahInteractor.detailJamaah(new JamaahInteractor.DataJamaah() {
            @Override
            public void dataJamaah(String dataJamaah) {
                approvalView.detailJamaah(dataJamaah);
            }
        });
    }

    public void setApprovalKoperasi(String approvalKoperasi){
        approvalInteractor.approvalKoperasi(approvalKoperasi, new ApprovalInteractor.ApprovalKoperasi() {
            @Override
            public void approvalKoperasi(String approvalKoperasi) {
                approvalView.approvalJamaah(approvalKoperasi);
            }
        });
    }

    public void setApprovalBank(JSONObject approvalBank){
        approvalInteractor.approvalBank(approvalBank, new ApprovalInteractor.ApprovalBank() {
            @Override
            public void approvalBank(String approvalBank) {
                approvalView.listJamaah(approvalBank);
            }
        });
    }

    public void setApprovalMyumroh(JSONObject approvalMyumroh){
        approvalInteractor.approvalMyumroh(approvalMyumroh, new ApprovalInteractor.ApprovalMyumroh() {
            @Override
            public void approvalMyumroh(String approvalMyumroh) {
                approvalView.listJamaah(approvalMyumroh);
            }
        });
    }
}
