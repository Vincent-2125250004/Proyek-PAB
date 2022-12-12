package com.if3a.paimonopedia.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.if3a.paimonopedia.R;
import com.if3a.paimonopedia.fragment.AboutFragment;
import com.if3a.paimonopedia.fragment.Artifacts_Fragment;
import com.if3a.paimonopedia.fragment.CharactersFragment;
import com.if3a.paimonopedia.fragment.WeaponsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navbar;
    private BottomNavigationView about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navbar = findViewById(R.id.navbar);
        about = findViewById(R.id.about);

        bukafragment(new CharactersFragment());

        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navChara:
                        bukafragment(new CharactersFragment());
                        return true;


                    case R.id.navWeapons:
                        bukafragment(new WeaponsFragment());
                        return true;

                    case R.id.navArtifact:
                        bukafragment(new Artifacts_Fragment());
                        return true;
                }
                return false;
            }
        });

        about.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bukafragment(new AboutFragment());
                return true;
            }
        });
    }

    private void bukafragment(Fragment fr) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fl_container, fr);
        FT.commit();
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }


}