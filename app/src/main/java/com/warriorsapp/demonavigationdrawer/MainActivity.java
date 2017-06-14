package com.warriorsapp.demonavigationdrawer;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.layout_navigation_drawer);

        Toolbar toolbar = (Toolbar)findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        //navigation drawer
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        //Set Listener to the NavigationDrawe
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    //*************************************************************************************//
    //*************************   onNavigationItemSelected   ******************************//
    //*************************************************************************************//
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        String temp;

        switch(item.getItemId())
        {
            case  R.id.inbox :
                temp = "Inbox";
                break;
            case R.id.starred :
                temp = "Starred";
                break;
            case R.id.mail:
                temp = "Mail";
                break;
            case R.id.drafts :
                temp = "Drafts";
                break;
            case R.id.allMail :
                temp = "All Mail";
                break;
            case R.id.trash :
                temp = "Trash";
                break;
            case R.id.span_id :
                temp = "Span";
                break;
            case R.id.myandroid :
                temp = "Android";
                break;
            case R.id.ubuntu :
                temp = "Ubuntu";
                break;
            default:
                temp = "UNKNOW";
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        Toast.makeText(getBaseContext(),temp,Toast.LENGTH_SHORT).show();
        return true;
    }


    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }
}
