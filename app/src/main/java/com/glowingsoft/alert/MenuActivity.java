package com.glowingsoft.alert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    RelativeLayout donnerclilck,takerclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        donnerclilck = (RelativeLayout) findViewById(R.id.donnerClick);
        takerclick = (RelativeLayout) findViewById(R.id.takerClick);
        donnerclilck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "toast", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this,DonnerActivity.class);
                startActivity(intent);
            }
        });
        takerclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,TakerActivity.class);
                startActivity(intent);
            }
        });
    }
}
