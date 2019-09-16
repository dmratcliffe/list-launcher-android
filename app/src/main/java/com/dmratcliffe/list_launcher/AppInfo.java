package com.dmratcliffe.list_launcher;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private CharSequence label;
    private CharSequence packageName;
    private Drawable icon;
    private CharSequence appStatus;

    public AppInfo(CharSequence label, CharSequence packageName, Drawable icon){
        this(label, packageName, icon, "visible");
    }

    public AppInfo(CharSequence label, CharSequence packageName, Drawable icon, CharSequence status){
        this.label = label;
        this.packageName = packageName;
        this.icon = icon;
        this.appStatus = status;
    }

    public CharSequence getLabel() {
        return label;
    }

    public void setLabel(CharSequence label) {
        this.label = label;
    }

    public CharSequence getPackageName() {
        return packageName;
    }

    public void setPackageName(CharSequence packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public CharSequence getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(CharSequence appStatus) {
        this.appStatus = appStatus;
    }
}

