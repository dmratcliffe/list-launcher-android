package com.dmratcliffe.list_launcher;

import android.app.Application;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class AppList extends ArrayList<AppInfo> {


    /*
        These functions make it easier to get information from the list.
        TODO: Write setters for these. It's less important, but still.
     */
    public CharSequence getLabel(int index) {
        return super.get(index).getLabel();
    }
    public CharSequence getPackageName(int index) {
        return super.get(index).getPackageName();
    }
    public Drawable getIcon(int index) {
        return super.get(index).getIcon();
    }
    public CharSequence getAppStatus(int index){
        return  super.get(index).getAppStatus();
    }

    /*
        This allows the fetching of a list of all apps with a matching status.
        The status could be "hidden" or "favorite", but this leaves it open for more.
        Anything else, by the way, is considered normal for now.
     */
    public AppList getSpecificStatusList(String status) {
        AppList matchingStatus = new AppList();

        for (int i = 0; i < super.size(); i++) {
            if (this.getAppStatus(i) == status) {
                matchingStatus.add(super.get(i));
            }
        }

        return  matchingStatus;
    }
    public AppList getFavoriteList(){
        return this.getSpecificStatusList("favorite");
    }
    public AppList getHiddenList(){
        return this.getSpecificStatusList("hidden");
    }

    //unfortunately there isn't a great way to do this on apilevel 7.
    // :(
    //It needs to be fast, as any delay will get in the way. So I don't want to do a ton
    //of operations on the existing list.
    public AppList getDrawerList(){
        AppList drawerList = new AppList();
        for (int i = 0; i < super.size(); i++) {
            if (this.getAppStatus(i) != "hidden") {
                drawerList.add(super.get(i));
            }
        }
        return drawerList;
    }

    /*
        Save and load functions for the list
        Basically the easiest way is JSON I think....
     */
    //TODO: Implement these methods.

}
