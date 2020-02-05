package com.example.simplebankaccountapps;

import android.content.Context;
import android.content.SharedPreferences;

public class AccountPreference {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

   public AccountPreference(Context context){

            preferences=context.getSharedPreferences("my_pre",Context.MODE_PRIVATE);
            editor=preferences.edit();
    }

    public void setLoginstutas(boolean stutus){

       editor.putBoolean("stutus",stutus);
       editor.commit();

    }

    public boolean getloginstutus(){

       return preferences.getBoolean("stutus",false);
    }

    public void setUserAccount(int account){

       editor.putInt("account",account);
       editor.commit();
    }

    public int getUserAccount(){

       return preferences.getInt("account",-1);
    }
}
