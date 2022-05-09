package com.cbu.mobileapplicationproject.entities.concrete;

import com.cbu.mobileapplicationproject.entities.interfaces.IEntityBase;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class EntityBase implements IEntityBase, Serializable {

    @SerializedName("id")
    private int Id;
    @SerializedName("creationDate")
    private Date CreationDate;
    @SerializedName("createdUserId")
    private int CreatedUserId;
    @SerializedName("updateDate")
    private Date UpdateDate;
    @SerializedName("updatedUserId")
    private int UpdatedUserId;
    @SerializedName("isDeleted")
    private boolean IsDeleted;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public int getCreatedUserId() {
        return CreatedUserId;
    }

    public void setCreatedUserId(int createdUserId) {
        CreatedUserId = createdUserId;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public int getUpdatedUserId() {
        return UpdatedUserId;
    }

    public void setUpdatedUserId(int updatedUserId) {
        UpdatedUserId = updatedUserId;
    }

    public boolean getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

}
