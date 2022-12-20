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
import com.if3a.paimonopedia.activity_detail.Detail_Characters;
import com.if3a.paimonopedia.models.Characters;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterCharacters extends RecyclerView.Adapter<AdapterCharacters.ViewHolder> {
    private List<Characters> charactersList = new ArrayList<>();

    public AdapterCharacters(List<Characters> charactersList) {
        this.charactersList = charactersList;
    }

    @NonNull
    @Override
    public AdapterCharacters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterCharacters.ViewHolder holder, int position) {
        Characters chara = charactersList.get(position);

        holder.tvname.setText(chara.getName());
        holder.tvrarity.setText(String.valueOf(chara.getRarity()));

        if (chara.getIcon().isEmpty()) {
            holder.iconchara.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(chara.getIcon()).into(holder.iconchara);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail_Characters.class);
                intent.putExtra("varId", chara.getId());
                intent.putExtra("varName", chara.getName());
                intent.putExtra("varRarity", String.valueOf(chara.getRarity()));
                intent.putExtra("varVision" , chara.getElement());
                intent.putExtra("varIcon", chara.getIcon());
                intent.putExtra("varTitle", chara.getTitle());
                intent.putExtra("varWeapon", chara.getWeapon());
                intent.putExtra("varRegion", chara.getRegion());
                intent.putExtra("varFaction", chara.getFaction());
                intent.putExtra("varImage", chara.getImage());
                intent.putExtra("varCons", chara.getConstellation());
                intent.putExtra("varBirth", chara.getBirthday());
                intent.putExtra("varDesc", chara.getDescription());
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return charactersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView tvname, tvrarity;
        private ImageView iconchara;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tv_name);
            tvrarity = itemView.findViewById(R.id.tv_Rarity);
            iconchara = itemView.findViewById(R.id.icon_chara);
        }
    }
}
