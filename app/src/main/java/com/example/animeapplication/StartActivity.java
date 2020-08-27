package com.example.animeapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences =this.getSharedPreferences("config", Context.MODE_PRIVATE);
        String data=sharedPreferences.getString("time","");
        if(data.equals("second")){
            Intent intent=new Intent(this,LogoActivity.class);
            startActivity(intent);
        }
        else {
            SharedPreferences sp=this.getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("time","second");
            editor.commit();
            Intent intent=new Intent(this,LogoActivity.class);
            startActivity(intent);

        }

    }
}
