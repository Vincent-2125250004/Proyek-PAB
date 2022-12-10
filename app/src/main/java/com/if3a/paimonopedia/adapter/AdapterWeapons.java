package com.if3a.paimonopedia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.models.Artifacts;
import com.if3a.paimonopedia.models.Weapons;

import java.util.ArrayList;
import java.util.List;

public class AdapterWeapons extends RecyclerView.Adapter<AdapterWeapons.ViewHolder> {
    private List<Weapons> weaponsList = new ArrayList<>();

    public AdapterWeapons(List<Weapons> weaponsList) {
        this.weaponsList = weaponsList;
    }

    @NonNull
    @Override
    public AdapterWeapons.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weapons, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWeapons.ViewHolder holder, int position) {
        Weapons weap = weaponsList.get(position);

        holder.tvName.setText(weap.getName());
        holder.tvRarity.setText(weap.getRarity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Name : " + weap.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return weaponsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvRarity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_Name);
            tvRarity = itemView.findViewById(R.id.tv_Rarity);
        }
    }
}
