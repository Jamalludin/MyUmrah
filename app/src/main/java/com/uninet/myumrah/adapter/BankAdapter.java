package com.uninet.myumrah.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.approval.JamaahApprovalBank;
import com.uninet.myumrah.model.Jamaah;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.ViewHolder> {

    List<Jamaah> approvalList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView jamaahApproBankID,jamaahApproBanknama,jamaahApproBanknik;

        public ViewHolder(View itemView) {
            super(itemView);

            jamaahApproBankID   = (TextView)itemView.findViewById(R.id.txt_kode_approvalBank);
            jamaahApproBanknama = (TextView)itemView.findViewById(R.id.txt_nama_approvalBank);
            jamaahApproBanknik  = (TextView)itemView.findViewById(R.id.txt_nik_approvalBank);
        }
    }

    public BankAdapter(List<Jamaah> bankList){

        approvalList = bankList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crad_view_approval_bank, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.jamaahApproBankID.setText(approvalList.get(position).getIdJamaah());
        holder.jamaahApproBanknik.setText(approvalList.get(position).getNik());
        holder.jamaahApproBanknama.setText(approvalList.get(position).getNamaLengkap());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent calon = new Intent(view.getContext(), JamaahApprovalBank.class);

                Bundle bundle = new Bundle();
                bundle.putString("idJMnya", approvalList.get(position).getIdJamaah());
                calon.putExtras(bundle);
                view.getContext().startActivity(calon);

            }
        });

    }

    @Override
    public int getItemCount() {
        return approvalList.size();
    }
}
