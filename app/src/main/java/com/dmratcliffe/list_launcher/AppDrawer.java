package com.dmratcliffe.list_launcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AppDrawer extends AppCompatActivity {
    boolean debug = true;
    String TAG = "list-launcher";

    private FloatingActionButton closeDrawerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_drawer);


        closeDrawerButton = findViewById(R.id.closeDrawerButton);
        closeDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(debug)
                    Log.i(TAG, "onClick: closeDrawerButton was pressed, moving activity");
                finish();
            }
        });

        //TODO: Make sure this works with new apps, i dont think it will
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.appDrawerRecycler);
        AppListAdapter radapter = new AppListAdapter(this);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
