package com.if3a.paimonopedia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.activity_detail.Detail_Weapons;
import com.if3a.paimonopedia.models.Weapons;
import com.squareup.picasso.Picasso;

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
        Weapons wp = weaponsList.get(position);

        holder.tvName.setText(wp.getName());
        holder.tvRarity.setText(String.valueOf(wp.getRarity()));


        if (wp.getImage().isEmpty()){
            holder.ImageWeapons.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(wp.getImage()).into(holder.ImageWeapons);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(holder.itemView.getContext(), Detail_Weapons.class);

                intent.putExtra("varName", wp.getName());
                intent.putExtra("varRarity", String.valueOf(wp.getRarity()));
                intent.putExtra("varType", wp.getType());
                intent.putExtra("varbaseAtk", String.valueOf(wp.getBaseAtk()));
                intent.putExtra("varSubstat", String.valueOf(wp.getSubStat()));
                intent.putExtra("varAbillity", wp.getAbilityName());
                intent.putExtra("varAbillityDesc", wp.getAbilityDescription());
                intent.putExtra("varImageWeapons", wp.getImage());
                intent.putExtra("varLocation", wp.getLocation());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return weaponsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvRarity, tvName;
        private ImageView ImageWeapons;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvRarity = itemView.findViewById(R.id.tv_Rarity);
            ImageWeapons = itemView.findViewById(R.id.icon_weapons);

        }
    }

}
