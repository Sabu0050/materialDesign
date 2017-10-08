package com.sabututexp.everyonejournalist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by s on 10/8/17.
 */

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("isVerified")
    @Expose
    private Integer isVerified;
    @SerializedName("isAdmin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("cover_photo")
    @Expose
    private String coverPhoto;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("lastChange")
    @Expose
    private String lastChange;
    @SerializedName("deletedDate")
    @Expose
    private Object deletedDate;

    public User() {
    }

    public User(Integer id, String name, String email, Integer isVerified, Boolean isAdmin, String coverPhoto, String creationDate, String lastChange, Object deletedDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isVerified = isVerified;
        this.isAdmin = isAdmin;
        this.coverPhoto = coverPhoto;
        this.creationDate = creationDate;
        this.lastChange = lastChange;
        this.deletedDate = deletedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public Object getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Object deletedDate) {
        this.deletedDate = deletedDate;
    }
}
