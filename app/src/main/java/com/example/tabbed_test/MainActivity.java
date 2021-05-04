package com.example.tabbed_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager viewPager;
    TabLayout mTabLayout;
    TabItem firstItem, secondItem, thirdItem, generalItem;
    PagerAdapter adapter;
    TextView nav_name, nav_email, nav_type;
    MenuItem newEntryMenuItem;
    String userName, userEmail, userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        viewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tab_layout);
        firstItem = findViewById(R.id.first_item);
        secondItem = findViewById(R.id.second_item);
        thirdItem = findViewById(R.id.third_item);
        generalItem = findViewById(R.id.general_item);

        View headerView = navigationView.getHeaderView(0);
        nav_name = headerView.findViewById(R.id.nav_name);
        nav_email = headerView.findViewById(R.id.nav_email);
        nav_type = headerView.findViewById(R.id.nav_type);

        Intent intent = getIntent();
        userName = intent.getStringExtra("name");
        userEmail = intent.getStringExtra("email");
        userType = intent.getStringExtra("type");
        nav_name.setText(userName);
        nav_email.setText(userEmail);
        nav_type.setText(userType);

        newEntryMenuItem = navigationView.getMenu().findItem(R.id.newEntryMenuItem);

        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.hamburger_icon);

//        getSupportActionBar().setDisplayShowTitleEnabled(false);      //Uncomment to remove app name on Tool Bar
        adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        if(userType.equals("Caretaker"))
            newEntryMenuItem.setVisible(false);

        //Setting Tab functionalities
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
    // For Navigation Menu Items
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.newEntryMenuItem) {
            Intent intent = new Intent(MainActivity.this, NewEntry.class);
            intent.putExtra("type", userType);
            intent.putExtra("email", userEmail);
            intent.putExtra("name", userName);
            startActivity(intent);
            Toast.makeText(this, "Going to New Entry page!", Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if(item.getItemId()==R.id.logoutMenuItem) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(intent);
        }
        return false;
    }
}