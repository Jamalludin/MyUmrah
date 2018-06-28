package com.uninet.myumrah.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.daftar_umroh.DaftarUmroh;
import com.uninet.myumrah.model.Cicilan;

import java.text.DecimalFormat;
import java.util.List;

import static com.uninet.myumrah.util.DaftarUtil.CICILAN_ID;

public class CicilanAdapter extends RecyclerView.Adapter<CicilanAdapter.CicilanHolder> {

    List<Cicilan> cicilanList;

    public class CicilanHolder extends RecyclerView.ViewHolder{

        private TextView lamaDp;
        private TextView nominalDP;
        private ImageView addDP;

        public CicilanHolder(View itemView) {
            super(itemView);

            lamaDp    = (TextView) itemView.findViewById(R.id.lama_dp);
            nominalDP = (TextView) itemView.findViewById(R.id.harga_dp);
            addDP     = (ImageView)itemView.findViewById(R.id.btn_add);
        }
    }

    public CicilanAdapter(List<Cicilan> detailDPUnities){
        cicilanList = detailDPUnities;
    }

    @NonNull
    @Override
    public CicilanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View paket = LayoutInflater.from(parent.getContext()).inflate(R.layout.crad_view_cicilan,
                parent, false);

        CicilanHolder viewHolderPaket = new CicilanHolder(paket);
        return viewHolderPaket;
    }

    @Override
    public void onBindViewHolder(@NonNull CicilanHolder holder, final int position) {

        holder.lamaDp.setText(cicilanList.get(position).getLamaCicilan()+" kali");
        String convert = String.valueOf(cicilanList.get(position).getNominalCicilan());
        double amount = Double.parseDouble(convert);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        holder.nominalDP.setText("Rp. "+formatter.format(amount));

        holder.addDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            CICILAN_ID = String.valueOf(cicilanList.get(position).getIdCicilan());
            view.getContext().startActivity(new Intent(view.getContext(), DaftarUmroh.class));

            }
        });

    }

    @Override
    public int getItemCount() {
        return cicilanList.size();
    }
}
