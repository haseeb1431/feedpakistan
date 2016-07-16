package com.glowingsoft.alert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    EditText accountTitle,address,usernameET;
    Button saveData;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String URL ="http://glowingsoft.com/freelunch/register.php";
    String type = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        accountTitle = (EditText) findViewById(R.id.titleEt);
        address = (EditText) findViewById(R.id.address);
        saveData = (Button) findViewById(R.id.save);
        usernameET = (EditText) findViewById(R.id.usernameET);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"save",Toast.LENGTH_SHORT).show();
                serverRequest();
            }
        });
    }
    public void serverRequest(){
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        final String typeString = radioButton.getText().toString();

        if (typeString.equals("Taker")){
            type = "2";
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistrationActivity.this,"Registered Successfully!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegistrationActivity.this,ProfileActivity.class);
                        intent.putExtra("id",response);
                        intent.putExtra("title",accountTitle.getText().toString());
                        intent.putExtra("name",accountTitle.getText().toString());
                        intent.putExtra("address",accountTitle.getText().toString());
                        intent.putExtra("type",type);
                        startActivity(intent);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrationActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("title",accountTitle.getText().toString());
                params.put("name",usernameET.getText().toString());
                params.put("address", address.getText().toString());
                params.put("type",type);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
