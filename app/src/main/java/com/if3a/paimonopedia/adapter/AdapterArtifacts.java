package com.if3a.paimonopedia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.activity_detail.Detail_Artifacts;
import com.if3a.paimonopedia.models.Artifacts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterArtifacts extends RecyclerView.Adapter<AdapterArtifacts.ViewHolder> {
    private List<Artifacts> artifactsList = new ArrayList<>();


    public AdapterArtifacts(List<Artifacts> artifactsList) {
        this.artifactsList = artifactsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_artifacts, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artifacts art = artifactsList.get(position);

        holder.tvname.setText(art.getName());
        holder.tvrarity.setText(String.valueOf(art.getRarity()));

        if (art.getImage().isEmpty()) {
            holder.iconArtifacts.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(art.getImage()).into(holder.iconArtifacts);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail_Artifacts.class);
                intent.putExtra("varName", art.getName());
                intent.putExtra("varMaxRarity", String.valueOf(art.getArtifactsSets().getMaxRarity()));
                intent.putExtra("varType",art.getType());
                intent.putExtra("vartwopieces", art.getArtifactsSets().getTwoPieceBonus());
                intent.putExtra("varfourpieces", art.getArtifactsSets().getFourPieceBonus());
                intent.putExtra("varLore", art.getLore());
                intent.putExtra("varDesc", art.getDescription());
                intent.putExtra("varLocation", art.getLocation());
                intent.putExtra("varImageArtifacts", art.getImage());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artifactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname, tvrarity;
        private ImageView iconArtifacts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tv_name);
            tvrarity = itemView.findViewById(R.id.tv_max_rarity);
            iconArtifacts = itemView.findViewById(R.id.icon_artifacts);

        }
    }
}
