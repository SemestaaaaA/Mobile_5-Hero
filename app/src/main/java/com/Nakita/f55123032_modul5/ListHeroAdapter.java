package com.Nakita.f55123032_modul5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
    private ArrayList<Pahlawan> listPahlawan;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    public interface OnItemClickCallback{
        void onItemClicked(Pahlawan data);
    }
    public ListHeroAdapter(ArrayList<Pahlawan> list){this.listPahlawan = list;}
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
        return new ListViewHolder(view);}
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Pahlawan pahlawan = listPahlawan.get(position);
        holder.imgPhoto.setImageResource(pahlawan.getPhoto());
        holder.tvName.setText(pahlawan.getName());
        holder.tvDescription.setText(pahlawan.getDescription());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listPahlawan.get(holder.getAdapterPosition())));
    }
    @Override
    public int getItemCount() {
        return listPahlawan.size();
    }





    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}