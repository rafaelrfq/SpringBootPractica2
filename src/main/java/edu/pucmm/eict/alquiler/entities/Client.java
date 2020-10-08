package edu.pucmm.eict.alquiler.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    private String cedula;

    private String name;
    private String lastName;

    @Lob
    private String picture;
    private String mimeType;

    public Client(){}

    public Client(String cedula, String name, String lastName){
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
    }

    public String getCedula() { return cedula; }

    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPicture() { return picture; }

    public void setPicture(String fotoBase64) { this.picture = fotoBase64; }

    public String getMimeType() { return mimeType; }

    public void setMimeType(String mimeType) { this.mimeType = mimeType; }
}