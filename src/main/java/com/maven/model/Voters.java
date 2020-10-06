package com.maven.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "voters")
public class Voters {
   
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "fathername")
    private String fathername;

    @Column(name = "mothername")
    private String mothername;

    @Column(name = "nid")
    private String nid;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "religion")
    private String religion;

    @Column(name = "sex")
    private String sex;

    @Column(name = "blood")
    private String blood;

    @Column(name = "area")
    private String area;

    @Column(name = "wordno")
    private String wordno;

    @Column(name = "citycorporation")
    private String citycorporation;
    
    @Column(name = "voterimage")
    private byte[] voterimage;

    public byte[] getVoterimage() {
        return voterimage;
    }

    public void setVoterimage(byte[] voterimage) {
        this.voterimage = voterimage;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWordno() {
        return wordno;
    }

    public void setWordno(String wordno) {
        this.wordno = wordno;
    }

    public String getCitycorporation() {
        return citycorporation;
    }

    public void setCitycorporation(String citycorporation) {
        this.citycorporation = citycorporation;
    }
    
    

}
