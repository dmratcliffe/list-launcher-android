package com.dmratcliffe.list_launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

public class AppListUpdater {
    public AppList updateList(Context c, AppList appList){

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        PackageManager pm = c.getPackageManager();

        AppList updatedList = new AppList();

        List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);

        for(ResolveInfo ri : allApps) {
            AppInfo app = new AppInfo(ri.loadLabel(pm), ri.activityInfo.packageName, ri.activityInfo.loadIcon(pm));
            updatedList.add(app);
        }
    }
}
