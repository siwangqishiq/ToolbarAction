package com.xinlan.toolbaraction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_favorite:
                Intent it = new Intent(this, ChildActivity.class);
                startActivity(it);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//end switch
    }
}//end class
