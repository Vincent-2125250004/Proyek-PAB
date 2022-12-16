package com.if3a.paimonopedia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.models.Characters;
import com.if3a.paimonopedia.models.talents;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterTalents extends RecyclerView.Adapter<AdapterTalents.ViewHolder> {
    public List<Characters> charactersList =new ArrayList<>();

    public AdapterTalents(List<Characters> charactersList) {
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public AdapterTalents.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_talents,parent,false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTalents.ViewHolder holder, int position) {
        Characters chr = charactersList.get(position);
        holder.tvName.setText(chr.getName());
        holder.tvtype.setText("1");
        holder.tvDescription.setText(chr.getDescription());

        if (chr.getImage().isEmpty()){
            holder.ImageTalents.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(chr.getImage()).into(holder.ImageTalents);
        }
    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvtype, tvDescription;
        private ImageView ImageTalents;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name_talents);
            tvtype = itemView.findViewById(R.id.tv_typetalent);
            tvDescription = itemView.findViewById(R.id.tv_Desc_talents);
            ImageTalents = itemView.findViewById(R.id.icon_talents);
        }
    }
}
