package com.uninet.myumrah.activity.login_aplikasi;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private Context context;

    public Session(Context context) {
        this.context = context;
    }


    public void token(String username, String sandi, String role,String token){

        SharedPreferences preferences = this.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", sandi);
        editor.putString("data",token);
        editor.putString("roles", role);
        editor.commit();
    }

    public void logout(){

        SharedPreferences preferences = this.context.getSharedPreferences("token",Context.MODE_PRIVATE);
        SharedPreferences.Editor e = preferences.edit();
        e.clear().commit();
    }

    public void paket (String idPaket){

        SharedPreferences paket = this.context.getSharedPreferences("paket", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = paket.edit();
        edit.putString("id_paket", idPaket);
        edit.commit();
    }

    public void detailJamaah (String idJamah){

        SharedPreferences paket = this.context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = paket.edit();
        edit.putString("id_jamaah", idJamah);
        edit.commit();
    }

    public boolean cekLogin(){

        SharedPreferences preferences = this.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        if (preferences.getString("username",null) != null){
            return true;
        }else return false;
    }

    public String getUserName(){
        SharedPreferences preferences = this.context.getSharedPreferences("token",Context.MODE_PRIVATE);
        return preferences.getString("username",null);
    }

    public String tokenLogin(){
        SharedPreferences preferences = this.context.getSharedPreferences("token",Context.MODE_PRIVATE);
        return preferences.getString("data",null);
    }

    public String role(){
        SharedPreferences preferences = this.context.getSharedPreferences("token",Context.MODE_PRIVATE);
        return preferences.getString("roles",null);
    }
}
