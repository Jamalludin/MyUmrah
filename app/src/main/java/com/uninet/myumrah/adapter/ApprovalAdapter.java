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
import com.uninet.myumrah.activity.approval.BankApproval;
import com.uninet.myumrah.activity.approval.JamahApproval;
import com.uninet.myumrah.activity.approval.KoperasiApproval;
import com.uninet.myumrah.activity.approval.MyUmrahApproval;
import com.uninet.myumrah.activity.login_aplikasi.Session;
import com.uninet.myumrah.model.Jamaah;
import com.uninet.myumrah.model.ListJamaah;

import java.util.List;

public class ApprovalAdapter extends RecyclerView.Adapter<ApprovalAdapter.ViewHolder> {

    List<ListJamaah> jamaahs;
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView jamaahID,namaJamaah,nikJamaah;

        public ViewHolder(View itemView) {
            super(itemView);

            jamaahID    = (TextView)itemView.findViewById(R.id.kode_jamaah);
            namaJamaah  = (TextView)itemView.findViewById(R.id.nama_calon_jamaah);
            nikJamaah   = (TextView)itemView.findViewById(R.id.nip_calon_jamaah);
        }
    }

    public ApprovalAdapter(List<ListJamaah> jamaahList){
        jamaahs = jamaahList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_calon_jamaah, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.jamaahID.setText(jamaahs.get(position).getIdJamaah());
        holder.nikJamaah.setText(jamaahs.get(position).getNik());
        holder.namaJamaah.setText(jamaahs.get(position).getNamaLengkap());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String role = new Session(view.getContext()).role();
                if (role.equalsIgnoreCase("")){

                    Intent calon = new Intent(view.getContext(), KoperasiApproval.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("idnya", jamaahs.get(position).getIdJamaah());
                    calon.putExtras(bundle);
                    view.getContext().startActivity(calon);

                }else if (role.equalsIgnoreCase("")){

                    Intent calon = new Intent(view.getContext(), BankApproval.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("idnya", jamaahs.get(position).getIdJamaah());
                    calon.putExtras(bundle);
                    view.getContext().startActivity(calon);

                }else {

                    Intent calon = new Intent(view.getContext(), MyUmrahApproval.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("idnya", jamaahs.get(position).getIdJamaah());
                    calon.putExtras(bundle);
                    view.getContext().startActivity(calon);
                }*/
                Intent calon = new Intent(view.getContext(), KoperasiApproval.class);
                Bundle bundle = new Bundle();
                bundle.putString("idnya", jamaahs.get(position).getIdJamaah());
                calon.putExtras(bundle);
                view.getContext().startActivity(calon);


            }
        });
    }

    @Override
    public int getItemCount() {
        return jamaahs.size();
    }
}
