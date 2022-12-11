package com.if3a.paimonopedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.models.Artifacts;

import java.util.List;

public class AdapterArtifacts extends RecyclerView.Adapter<AdapterArtifacts.HolderData> {
    private List<Artifacts> artifactsList;
    private Context ctx;

    public AdapterArtifacts(Context ctx, List<Artifacts> artifactsList) {
        this.ctx = ctx;
        this.artifactsList = artifactsList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_artifacts, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        Artifacts art = artifactsList.get(position);

        holder.tvName.setText(String.valueOf(art.getName()));
        holder.tvRarity.setText(String.valueOf(art.getMax_rarity()));

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

    public class HolderData extends RecyclerView.ViewHolder {
        private TextView tvName, tvRarity;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvRarity = itemView.findViewById(R.id.tv_max_rarity);
        }
    }
}
