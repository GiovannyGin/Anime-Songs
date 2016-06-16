package com.commonapps.animesongs;


import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.commonapps.animesongs.com.commonapps.animesong.mylist.MyMusicList;
import com.commonapps.animesongs.com.commonapps.animesong.album;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);


        drawerLayout = (DrawerLayout)findViewById(R.id.navigation_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);

        if(navigationView !=null){
            setupNavigationDrawerContent(navigationView);
        }


        getSupportActionBar().setTitle("Inicio");
        muestraFragment(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);


    }
    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.opcion_navegacion_album:
                                menuItem.setChecked(true);
                                muestraFragment(0);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                                drawerLayout.closeDrawer(GravityCompat.START);

                                return true;
                            case R.id.opcion_navegacion_milista:
                                menuItem.setChecked(true);
                                muestraFragment(1);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.opcion_navegacion_top:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
}
    public void muestraFragment (int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                //FragmentManager fragmentCards = getSupportFragmentManager();
                //fragmentCards.beginTransaction().replace(R.id.contenedor_fragments, new album()).commit();
                Intent intent1 = new Intent(this, album.class);
                startActivity(intent1);
                break;

            case 1:
                Intent intent = new Intent(this, MyMusicList.class);
                startActivity(intent);
                break;
        }
}}
