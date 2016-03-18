package com.xinlan.toolbaraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ChildActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.show_actionbar_btn).setOnClickListener(new View.OnClickListener() {//show ActionBar
            @Override
            public void onClick(View v) {
                getSupportActionBar().show();
            }
        });

        findViewById(R.id.hide_actionbar_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//hide ActionBar
                getSupportActionBar().hide();
            }
        });

        getSupportActionBar().setTitle("ChildActivity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sub_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setTranslationX(200);

        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                System.out.println("item  expand");
                return true;  // Return true to expand action view;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                System.out.println("item  collapse");
                return true;   // Return true to expand action view;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }//end switch
    }
}//end class
