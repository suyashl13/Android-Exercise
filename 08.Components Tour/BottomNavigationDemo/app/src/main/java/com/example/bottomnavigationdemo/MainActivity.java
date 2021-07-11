package com.example.bottomnavigationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.flFragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.flFragment, new HomeFragment()).commit();


        bottomNavigationView.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()){
                            case R.id.mi_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.mi_msg:
                                selectedFragment = new SecondFragment();
                                break;
                            case R.id.mi_profile:
                                selectedFragment = new ThirdFragment();
                                break;
                            }

                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.flFragment, selectedFragment).commit();
                            return true;
                    }
                }
        );

    }




}