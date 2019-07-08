package com.mbsoft.elsafeir.Utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.mbsoft.elsafeir.LoginActivity;

import java.util.Locale;

public class Constants {

    public static String Title="Title";


    public static final void languageChange(String L, Activity context) {
        String languageToLoad = L; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getBaseContext().getResources().updateConfiguration(config,
                context.getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(context, LoginActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.finishAffinity();
        context.startActivity(intent);


    }
}
