package com.cbu.mobileapplicationproject.entities.concrete;

import com.cbu.mobileapplicationproject.entities.interfaces.IEntityBase;

import java.util.Date;

public class EntityBase implements IEntityBase {

    private int Id;
    private Date CreationDate;
    private int CreatedUserId;
    private Date UpdateDate;
    private int UpdatedUserId;
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

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

}
