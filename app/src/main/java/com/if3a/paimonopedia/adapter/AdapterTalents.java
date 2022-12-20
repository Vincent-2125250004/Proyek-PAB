package com.if3a.paimonopedia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.models.Talents;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterTalents extends RecyclerView.Adapter<AdapterTalents.ViewHolder> {
    public List<Talents> talentsList = new ArrayList<>();

    public AdapterTalents(List<Talents> ListTalents) {
        this.talentsList = ListTalents;
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
        Talents tl = talentsList.get(position);
        holder.tvName.setText(tl.getName());
        holder.tvtype.setText(tl.getType());
        holder.tvDescription.setText(tl.getDescription());

        if (tl.getImage().isEmpty()){
            holder.ImageTalents.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(tl.getImage()).into(holder.ImageTalents);
        }
    }

    @Override
    public int getItemCount() {
        return talentsList.size();
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
