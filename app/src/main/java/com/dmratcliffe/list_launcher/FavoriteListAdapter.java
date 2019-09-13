package com.dmratcliffe.list_launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHolder> {
    //static public List<AppInfo> appsList;

    boolean debug = true;
    String TAG = "list-launcher";

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public ImageView img;


        //This is the subclass ViewHolder which simply
        //'holds the views' for us to show on each row
        public ViewHolder(View itemView) {
            super(itemView);

            //Finds the views from our row.xml
            textView = (TextView) itemView.findViewById(R.id.text);
            img = (ImageView) itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View v) {
            int pos = getAdapterPosition();
            Context context = v.getContext();

            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(MainActivity.appsList.get(pos).packageName.toString());
            context.startActivity(launchIntent);
            Toast.makeText(v.getContext(), MainActivity.appsList.get(pos).label.toString(), Toast.LENGTH_LONG).show();

        }
    }


    public FavoriteListAdapter(Context c) {

        //This is where we build our list of app details, using the app
        //object we created to store the label, package name and icon

        PackageManager pm = c.getPackageManager();
        MainActivity.appsList = new ArrayList<AppInfo>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        String favoriteApps[][] = {{"Chrome", "com.android.chrome"}};

        ArrayList<AppInfo> sorted = new ArrayList<AppInfo>();
        for (int j = 0; j < MainActivity.appsList.size(); j++) {
            for (int g = j + 1; g  < MainActivity.appsList.size(); g++) {
                // comparing strings
                if (MainActivity.appsList.get(g).label.toString().compareToIgnoreCase(MainActivity.appsList.get(j).label.toString()) < 0) {
                    AppInfo temp = MainActivity.appsList.get(j);
                    MainActivity.appsList.set(j, MainActivity.appsList.get(g));
                    MainActivity.appsList.set(g, temp);
                }
            }
            sorted.add(MainActivity.appsList.get(j));
        }
        MainActivity.appsList = sorted;

    }

    public class AppCompare implements Comparator<AppInfo>{
        @Override
        public int compare(AppInfo app1, AppInfo app2){
            return app1.label.toString().compareToIgnoreCase(app2.label.toString());
        }
    }

    @Override
    public void onBindViewHolder(FavoriteListAdapter.ViewHolder viewHolder, int i) {

        //Here we use the information in the list we created to define the views

        String appLabel = MainActivity.appsList.get(i).label.toString();
        String appPackage = MainActivity.appsList.get(i).packageName.toString();
        Drawable appIcon = MainActivity.appsList.get(i).icon;

        TextView textView = viewHolder.textView;
        textView.setText(appLabel);
        ImageView imageView = viewHolder.img;
        imageView.setImageDrawable(appIcon);
    }


    @Override
    public int getItemCount() {

        //This method needs to be overridden so that Androids knows how many items
        //will be making it into the list

        return MainActivity.appsList.size();
    }


    @Override
    public FavoriteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //This is what adds the code we've written in here to our target view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.app_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}