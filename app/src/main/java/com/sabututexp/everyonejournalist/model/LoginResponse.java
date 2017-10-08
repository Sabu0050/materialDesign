package com.sabututexp.everyonejournalist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by s on 10/8/17.
 */

public class LoginResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("error")
    private String error;

    @SerializedName("message")
    private String message;

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

    public String getAccessToken(){
        return accessToken;
    }

    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken(){
        return refreshToken;
    }

    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }

    public String getTokenType(){
        return tokenType;
    }

    public void setExpiresIn(int expiresIn){
        this.expiresIn = expiresIn;
    }

    public int getExpiresIn(){
        return expiresIn;
    }


    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return
                "LogInSuccessResponse{" +
                        "access_token = '" + accessToken + '\'' +
                        ",refresh_token = '" + refreshToken + '\'' +
                        ",token_type = '" + tokenType + '\'' +
                        ",expires_in = '" + expiresIn + '\'' +
                        "}";
    }
}
