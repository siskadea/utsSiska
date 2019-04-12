package com.siska.utsjastip.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siska.utsjastip.R;
import com.siska.utsjastip.models.Koleksi;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class KoleksiAdapter extends RecyclerView.Adapter<KoleksiAdapter.ViewHolder> {

    private List<Koleksi> dataList;

    public KoleksiAdapter(List<Koleksi> dataList) {

        this.dataList = dataList;
    }
    @NonNull
    @Override
    public KoleksiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View koleksiView = inflater.inflate(R.layout.list_item, viewGroup, false);

        return new KoleksiAdapter.ViewHolder(koleksiView);
    }

    @Override
    public void onBindViewHolder(@NonNull KoleksiAdapter.ViewHolder viewHolder, int i) {
        Koleksi data = dataList.get(i);

        if (data.getImg() != null) {
            Picasso.get().load(data.getImg()).into(viewHolder.imageView);
        } else {
            Picasso.get().load(data.getImg_local()).into(viewHolder.imageView);
        }

        viewHolder.brandView.setText(data.getBrand());
        viewHolder.ketView.setText(data.getKet());
    }

    @Override
    public int getItemCount() {
            return dataList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView brandView;
        TextView ketView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_img);
            brandView= itemView.findViewById(R.id.list_brand);
            ketView = itemView.findViewById(R.id.list_ket);
        }
    }
}
