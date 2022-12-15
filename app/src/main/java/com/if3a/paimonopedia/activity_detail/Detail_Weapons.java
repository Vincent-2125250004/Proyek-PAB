package com.if3a.paimonopedia.activity_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.if3a.paimonopedia.R;
import com.squareup.picasso.Picasso;

public class Detail_Weapons extends AppCompatActivity {
    private TextView tvRarity, tvType, tvName, tvbaseatk, tvSubstat, tvAbillity, tvabillitydesc, tvLocation;
    private ImageView ImageWeapons, MainImageWeapons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weapons);

        Intent intent= getIntent();
        String name = intent.getStringExtra("varName");
        String type = intent.getStringExtra("varType");

        tvRarity = findViewById(R.id.tv_rarity);
        tvName = findViewById(R.id.tv_nama_detail);
        tvType = findViewById(R.id.tv_type_detail);
        tvbaseatk = findViewById(R.id.tv_baseatk);
        tvSubstat = findViewById(R.id.tv_substats);
        tvAbillity = findViewById(R.id.tv_abillity);
        tvabillitydesc = findViewById(R.id.tv_abillitydesc);
        ImageWeapons = findViewById(R.id.icon_detail_weapons);
        tvLocation = findViewById(R.id.tv_location);
        MainImageWeapons = findViewById(R.id.ImageWeapons);

        tvName.setText(name);
        tvType.setText(intent.getStringExtra("varType"));
        tvRarity.setText(String.valueOf(intent.getStringExtra("varRarity")));
        tvbaseatk.setText(String.valueOf(intent.getStringExtra("varbaseAtk")));
        tvSubstat.setText(String.valueOf(intent.getStringExtra("varSubstat")));
        tvAbillity.setText(intent.getStringExtra("varAbillity"));
        tvabillitydesc.setText(intent.getStringExtra("varAbillityDesc"));
        tvLocation.setText(intent.getStringExtra("varLocation"));
        if (intent.getStringExtra("varImageWeapons").isEmpty()){
            ImageWeapons.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varImageWeapons")).into(ImageWeapons);
        }

        if (intent.getStringExtra("varImageWeapons").isEmpty()){
            MainImageWeapons.setImageResource(R.drawable.logopaimonopedia);
        }
        else {
            Picasso.get().load(intent.getStringExtra("varImageWeapons")).into(MainImageWeapons);
        }



    }
}