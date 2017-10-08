package com.sabututexp.everyonejournalist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sabututexp.everyonejournalist.R;
import com.sabututexp.everyonejournalist.api.APImethodService;
import com.sabututexp.everyonejournalist.api.ServiceHolder;
import com.sabututexp.everyonejournalist.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView createAccountTextView;
    private String email;
    private String password;
    private APImethodService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        service = ServiceHolder.createService(APImethodService.class);
        emailEditText = (EditText) findViewById(R.id.loginUserEditText);
        passwordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        loginButton = (Button) findViewById(R.id.logINButton);
        createAccountTextView = (TextView) findViewById(R.id.loginTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();

                //check validation
                if(email.isEmpty()||password.isEmpty()){
                    Toast.makeText(LogInActivity.this, "Please Fill up All Required fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    userLogin(email, password);

                }
            }
        });
        createAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }

    private void userLogin(String email, String password) {

        Call<LoginResponse> responseCall = service.userLogin(email, password);

        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && !containsError(response)) {
                    try {
                        LoginResponse logInSuccessResponse = response.body();
                        Toast.makeText(LogInActivity.this, logInSuccessResponse.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {

                    //i have been trying to make it a generic method but the from json method has been creating problems when i pass a generic class to it
                    Gson gson = new GsonBuilder().create();
                    LoginResponse pojo;
                    try {
                        pojo = gson.fromJson(response.errorBody().string(), LoginResponse.class);
                        Toast.makeText(getApplicationContext(), pojo.getError(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        LoginResponse logInSuccessResponse = response.body();
                        if (logInSuccessResponse.getAccessToken() == null)
                            Toast.makeText(getApplicationContext(), logInSuccessResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private boolean containsError(Response<LoginResponse> response) {

        LoginResponse logInSuccessResponse = response.body();
        if (logInSuccessResponse.getAccessToken() == null) {
            Toast.makeText(getApplicationContext(), logInSuccessResponse.getError(), Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
