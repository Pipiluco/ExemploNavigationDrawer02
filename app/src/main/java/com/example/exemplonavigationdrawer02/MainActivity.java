package com.example.exemplonavigationdrawer02;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tbMain);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.dlMain);
        NavigationView navigationView = findViewById(R.id.nvViewMain);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentContainerMain, new MenssagemFragment()).commit();
            navigationView.setCheckedItem(R.id.navMenssagem);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navMenssagem:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentContainerMain, new MenssagemFragment()).commit();
                break;
            case R.id.navChat:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentContainerMain, new ChatFragment()).commit();
                break;
            case R.id.navPerfil:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentContainerMain, new PerfilFragment()).commit();
                break;
            case R.id.navShare:
                Toast.makeText(getApplicationContext(), "Compartilhar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navSend:
                Toast.makeText(getApplicationContext(), "Enviar", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
