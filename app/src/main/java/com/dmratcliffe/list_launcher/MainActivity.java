package com.dmratcliffe.list_launcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    boolean debug = true;
    String TAG = "list-launcher";

    private ImageButton settingsButton, searchButton;
    private FloatingActionButton appDrawerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsButton = findViewById(R.id.settingsButton);
        searchButton = findViewById(R.id.searchButton);

        appDrawerButton = findViewById(R.id.appDrawerButton);


        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(debug)
                    Log.i(TAG, "onClick: settingsButton was pressed, moving activity");
                Intent settingsIntent = getPackageManager().getLaunchIntentForPackage("com.android.settings");
                startActivity(settingsIntent);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(debug)
                    Log.i(TAG, "onClick: searchButton was pressed, moving activity");
                //TODO: Make this an actual search activity
                Intent settingsIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                startActivity(settingsIntent);
            }
        });
        appDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(debug)
                    Log.i(TAG, "onClick: appDrawerButton button was pressed, moving activity");
                Intent appDrawerIntent = new Intent(getBaseContext(), AppDrawer.class);
                startActivity(appDrawerIntent);
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.favoriteAppsRecycler);
        AppListAdapter radapter = new AppListAdapter(this);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
