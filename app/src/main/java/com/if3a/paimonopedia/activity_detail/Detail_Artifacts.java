package com.if3a.paimonopedia.activity_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.if3a.paimonopedia.R;
import com.squareup.picasso.Picasso;

public class Detail_Artifacts extends AppCompatActivity {

    private TextView tvMaxRarity,tvType, tvName, tvTwopiecesBonus, tvFourpiecesBonus, tvlocation, tvlore, tvdesc;
    private ImageView ImageArtifact, MainImageArtifact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artifacts);

        Intent intent = getIntent();

        tvType = findViewById(R.id.tv_type_artifacts);
        tvName = findViewById(R.id.tv_nama_detail);
        tvMaxRarity = findViewById(R.id.tv_rarity);
        tvlore =findViewById(R.id.tv_lore_artifacts);
        tvlocation= findViewById(R.id.tv_location_artifacts);
        tvdesc = findViewById(R.id.tv_desc_artifacts);
        tvTwopiecesBonus = findViewById(R.id.tv_twosetbonus);
        tvFourpiecesBonus = findViewById(R.id.tv_foursetbonus);
        ImageArtifact = findViewById(R.id.icon_detail_artifacts);
        MainImageArtifact= findViewById(R.id.ImageArtifacts);

        tvName.setText(intent.getStringExtra("varName"));
        tvType.setText(intent.getStringExtra("varType"));
        tvlore.setText(intent.getStringExtra("varLore"));
        tvlocation.setText(intent.getStringExtra("varLocation"));
        tvdesc.setText(intent.getStringExtra("varDesc"));
        tvMaxRarity.setText(intent.getStringExtra("varMaxRarity"));
        tvTwopiecesBonus.setText(intent.getStringExtra("vartwopieces"));
        tvFourpiecesBonus.setText(intent.getStringExtra("varfourpieces"));

        if (intent.getStringExtra("varImageArtifacts").isEmpty()){
            ImageArtifact.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varImageArtifacts")).into(ImageArtifact);
        }

        if (intent.getStringExtra("varImageArtifacts").isEmpty()){
            MainImageArtifact.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varImageArtifacts")).into(MainImageArtifact);
        }

    }
}