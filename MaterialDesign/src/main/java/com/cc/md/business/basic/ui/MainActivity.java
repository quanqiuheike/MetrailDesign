package com.cc.md.business.basic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cc.md.R;

/**
 * Created by cheng.qx on 2017/1/5.
 */

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarLayout appBarLayout;
    private LinearLayout mHeadCollapsToolBarLinearLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        appBarLayout= (AppBarLayout) findViewById(R.id.app_bar_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        mHeadCollapsToolBarLinearLayout= (LinearLayout) findViewById(R.id.head_collaps_tool_bar_layout);
        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.collap_toolbar_layout);
        navigationView.setNavigationItemSelectedListener(this);
        final View headView = navigationView.inflateHeaderView(R.layout.head_view);
        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(verticalOffset<=-mHeadCollapsToolBarLinearLayout.getHeight()/2){
                    collapsingToolbarLayout.setTitle("Collapse");
                }else{
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_xitu:

                break;
            case R.id.navigation_palette:
                break;
            case R.id.navigation_share:
                break;
            case R.id.navigation_setting:
                break;
            case R.id.navigation_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.navigation_register:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
