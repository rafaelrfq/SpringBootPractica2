package edu.pucmm.eict.alquiler.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    @Lob
    private String picture;
    private String mimeType;

    public Equipment(){}

    public Equipment(String name, String category, String picture, String mimeType){
        this.name = name;
        this.category = category;
        this.picture = picture;
        this.mimeType = mimeType;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public String getMimeType() { return mimeType; }

    public void setMimeType(String mimeType) { this.mimeType = mimeType; }
}
