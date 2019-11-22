package com.example.kaalix1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    NavigationView nv;
    DrawerLayout d;
    ActionBarDrawerToggle a;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "My Action", Toast.LENGTH_SHORT).show();
                Snackbar.make(v, "My Action", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

        d = (DrawerLayout)findViewById(R.id.d);
        a = new ActionBarDrawerToggle(this, d, R.string.Open,R.string.Close);
        //a = new ActionBarDrawerToggle(this, d, "open", "close");
        a.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav);
        nv =(NavigationView)findViewById(R.id.nav_view);
        NavigationMenuView nmv = (NavigationMenuView)nv.getChildAt(0);
        nv.setItemTextColor(null);
        nv.setItemTextAppearance(R.style.MenuTextStyle);


        nmv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
                    case R.id.basket:
                        Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
                    case R.id.orders:
                        Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(a.onOptionsItemSelected(item))
        {
            //Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            if(d.isDrawerOpen(GravityCompat.START))
            {
                d.closeDrawer(GravityCompat.START);
            }
            else
            {
                d.openDrawer(GravityCompat.START);
            }
            return true;
        }
        switch (item.getItemId())
        {
            case R.id.home:
                Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
            case R.id.basket:
                Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
            case R.id.orders:
                Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
            case R.id.account:
                Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
            default:
                return true;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        d.closeDrawer(GravityCompat.START);
    }
}
