package com.uninet.myumrah.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uninet.myumrah.R;
import com.uninet.myumrah.activity.daftar_umroh.CicilanPaketActivity;
import com.uninet.myumrah.activity.daftar_umroh.DaftarUmrohActivity;
import com.uninet.myumrah.model.Paket;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.uninet.myumrah.util.DaftarUtil.BAYAR_ID;
import static com.uninet.myumrah.util.DaftarUtil.HARGA_PAKET;
import static com.uninet.myumrah.util.DaftarUtil.ID_PAKET;

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.PaketHolder> {

    List<Paket> paketUmrohUnityList;

    public class PaketHolder extends RecyclerView.ViewHolder{

        public TextView nmPaket;
        public TextView hrgPaket;
        public TextView kiraanBerangkat;
        public TextView kiraanHari;
        public TextView destinasi;
        public TextView htlMekah;
        public TextView htlMadinah;
        public Button btnPilih;

        public PaketHolder(View itemView) {
            super(itemView);

            nmPaket         = (TextView) itemView.findViewById(R.id.txt_paket);
            hrgPaket        = (TextView) itemView.findViewById(R.id.txt_hargaPaket);
            kiraanBerangkat = (TextView) itemView.findViewById(R.id.txt_estimasi);
            kiraanHari      = (TextView) itemView.findViewById(R.id.txt_lamaHari);
            destinasi       = (TextView) itemView.findViewById(R.id.txt_destinasi);
            htlMekah        = (TextView) itemView.findViewById(R.id.txt_htlMekah);
            htlMadinah      = (TextView) itemView.findViewById(R.id.txt_htlMadinah);
            btnPilih        = (Button) itemView.findViewById(R.id.btn_dtlPaket);
        }
    }

    public PaketAdapter(List<Paket> paketUmrohUnities){
        paketUmrohUnityList = paketUmrohUnities;
    }

    @NonNull
    @Override
    public PaketHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View paket = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_paket_umroh,
                parent, false);

        PaketHolder viewHolderPaket = new PaketHolder(paket);
        return viewHolderPaket;
    }

    @Override
    public void onBindViewHolder(@NonNull PaketHolder holder, final int position) {

        holder.nmPaket.setText(paketUmrohUnityList.get(position).getNamaPaket());
        holder.kiraanHari.setText(" : "+String.valueOf(paketUmrohUnityList.get(position).getHariPaket())+" Hari");
        holder.destinasi.setText(" : "+paketUmrohUnityList.get(position).getDestinasi());

        String htlMadinah = String.valueOf(paketUmrohUnityList.get(position).getHotelMadinah().getNamaHotel());
        holder.htlMadinah.setText(" : "+htlMadinah);

        String htlMekkah = String.valueOf(paketUmrohUnityList.get(position).getHotelMekkah().getNamaHotel());
        holder.htlMekah.setText(" : "+htlMekkah);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = paketUmrohUnityList.get(position).getTglBerangkat();
        String reportDate = df.format(today);
        holder.kiraanBerangkat.setText(" : "+reportDate);

        String convert = String.valueOf(paketUmrohUnityList.get(position).getHargaPaket());
        double amount = Double.parseDouble(convert);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        holder.hrgPaket.setText(" : "+"Rp. "+formatter.format(amount));

        holder.btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ID_PAKET = paketUmrohUnityList.get(position).getIdPaket();
                if (BAYAR_ID.equalsIgnoreCase("1")){

                    view.getContext().startActivity(new Intent(view.getContext(), CicilanPaketActivity.class));
                    HARGA_PAKET = String.valueOf(paketUmrohUnityList.get(position).getHargaPaket());

                }else {

                    view.getContext().startActivity(new Intent(view.getContext(), DaftarUmrohActivity.class));

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return paketUmrohUnityList.size();
    }
}
