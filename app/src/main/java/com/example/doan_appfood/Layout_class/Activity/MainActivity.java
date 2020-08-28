package com.example.doan_appfood.Layout_class.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.doan_appfood.Layout_class.fagment.Main_fragment;
import com.example.doan_appfood.Layout_class.fagment.fragment_fastfood;
import com.example.doan_appfood.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView = null;
    private Toolbar toolbar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        setControl();
        Dreamlayout();
    }
    public void AnhXa(){
        navigationView =  findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawer =  findViewById(R.id.drawer_layout);

    }
    private void setControl(){
        setSupportActionBar(toolbar);

        //DEFAULT FRAGMENT
        Main_fragment fragment = new Main_fragment();
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frg_container, fragment);
        fragmentTransaction.commit();

    }
    private void Dreamlayout(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_navi_dream, R.string.close_navi_dream);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       int id = menuItem.getItemId();
            if(id == R.id.nav_fastfood) {
                fragment_fastfood fastfood = new fragment_fastfood();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frg_container, fastfood);
                transaction.commit();
            }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
