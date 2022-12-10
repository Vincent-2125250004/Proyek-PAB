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

import java.util.ArrayList;
import java.util.List;

public class AdapterArtifacts extends RecyclerView.Adapter<AdapterArtifacts.ViewHolder> {
    private List<Artifacts> artifactsList = new ArrayList<>();

    public AdapterArtifacts(List<Artifacts> artifactsList) {
        this.artifactsList = artifactsList;
    }

    @NonNull
    @Override
    public AdapterArtifacts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_artifacts, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArtifacts.ViewHolder holder, int position) {
        Artifacts art = artifactsList.get(position);

        holder.tvName.setText(art.getName());
        holder.tvRarity.setText(art.getMax_rarity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Name : " + art.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return artifactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvRarity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvRarity = itemView.findViewById(R.id.tv_max_rarity);
        }
    }
}
