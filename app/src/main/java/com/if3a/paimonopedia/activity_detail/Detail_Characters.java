package com.if3a.paimonopedia.activity_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.adapter.AdapterTalents;
import com.if3a.paimonopedia.api.APIRequestData;
import com.if3a.paimonopedia.api.RetroServer;
import com.if3a.paimonopedia.models.talents;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;

public class Detail_Characters extends AppCompatActivity {
    public TextView tvName, tvelemen, tvRarity, tvTitle, tvWeapon, tvRegion, tvFaction, tvCons, tvBirth, tvDesc;
    private ImageView ImageMain, Icon;

    private RecyclerView rvTalents;
    private List<talents> talentsList;
    private AdapterTalents adapterTalents;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_characters);

        Intent intent = getIntent();

        tvName = findViewById(R.id.tv_nama_detail);
        tvRarity = findViewById(R.id.tv_rarity);
        tvTitle = findViewById(R.id.tv_title_detail);
        tvWeapon = findViewById(R.id.tv_weapon);
        tvRegion = findViewById(R.id.tv_region);
        tvelemen = findViewById(R.id.tv_elemen);
        tvFaction = findViewById(R.id.tv_faction);
        ImageMain = findViewById(R.id.ImageChara);
        Icon = findViewById(R.id.icon_detail_character);
        tvCons = findViewById(R.id.tv_constellation);
        tvBirth= findViewById(R.id.tv_birthday);
        tvDesc = findViewById(R.id.tv_desc);

        tvName.setText(intent.getStringExtra("varName"));
        tvRarity.setText(String.valueOf(intent.getStringExtra("varRarity")));
        tvelemen.setText(intent.getStringExtra("varVision"));
        tvTitle.setText(intent.getStringExtra("varTitle"));
        tvWeapon.setText(intent.getStringExtra("varWeapon"));
        tvRegion.setText(intent.getStringExtra("varRegion"));
        tvFaction.setText(intent.getStringExtra("varFaction"));
        tvCons.setText(intent.getStringExtra("varCons"));
        tvBirth.setText(intent.getStringExtra("varBirth"));
        tvDesc.setText(intent.getStringExtra("varDesc"));

        if (intent.getStringExtra("varIcon").isEmpty()){
            Icon.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varIcon")).into(Icon);
        }

        if (intent.getStringExtra("varImage").isEmpty()){
            ImageMain.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varImage")).into(ImageMain);
        }

        rvTalents = findViewById(R.id.rv_Talents);
        linearLayoutManager = new LinearLayoutManager(Detail_Characters.this);
        rvTalents.setLayoutManager(linearLayoutManager);


        retrieveTalents("talents");
    }

    private void retrieveTalents (String talent){
        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);



    }


}