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
import com.uninet.myumrah.activity.approval.JamaahApprovalMyUmrohActivity;
import com.uninet.myumrah.model.Jamaah;

import java.util.List;

public class MyUmrohAdapter extends RecyclerView.Adapter<MyUmrohAdapter.ViewApprovalTravel> {

    List<Jamaah> approvalTravels;

    public class  ViewApprovalTravel extends RecyclerView.ViewHolder{

        public TextView travelJamaId, travelJamaNama, travelNikJamaa;

        public ViewApprovalTravel(View itemView) {
            super(itemView);

            travelJamaId   = (TextView)itemView.findViewById(R.id.txt_kode_approvalTravel);
            travelJamaNama = (TextView)itemView.findViewById(R.id.txt_nama_approvalTravel);
            travelNikJamaa = (TextView)itemView.findViewById(R.id.txt_nik_approvalTravel);
        }
    }

    public MyUmrohAdapter(List<Jamaah> travels){

        approvalTravels = travels;
    }

    @NonNull
    @Override
    public ViewApprovalTravel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crad_view_approval_travel, parent, false);
        ViewApprovalTravel viewHolder = new ViewApprovalTravel(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewApprovalTravel holder, final int position) {

        holder.travelJamaId.setText(approvalTravels.get(position).getIdJamaah());
        holder.travelNikJamaa.setText(approvalTravels.get(position).getNik());
        holder.travelJamaNama.setText(approvalTravels.get(position).getNamaLengkap());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent calon = new Intent(view.getContext(), JamaahApprovalMyUmrohActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("idJMnya", approvalTravels.get(position).getIdJamaah());
                calon.putExtras(bundle);
                view.getContext().startActivity(calon);

            }
        });

    }

    @Override
    public int getItemCount() {
        return approvalTravels.size();
    }
}
