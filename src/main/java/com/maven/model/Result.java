/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
    
    //id, votername, nid, email, religion, sex, blood, area, wordno, citycorporation, fullname, partytype, status
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "votername")
    private String votername;
    
     @Column(name = "nid")
    private String nid;
     
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
    
//    @Column(name = "voterimage")
//    private byte[] voterimage;
    
    @Column(name = "fullname")
    private String fullname;
    
    
     @Column(name = "partytype")
    private String partytype;
     
//     @Column(name = "candidateimage")
//    private byte[] candidateimage;
//     
//    @Column(name = "logoimage")
//    private byte[] logoimage;
    
    
    @Column(name = "status")
    private int status;

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

//    public byte[] getVoterimage() {
//        return voterimage;
//    }
//
//    public void setVoterimage(byte[] voterimage) {
//        this.voterimage = voterimage;
//    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPartytype() {
        return partytype;
    }

    public void setPartytype(String partytype) {
        this.partytype = partytype;
    }

//    public byte[] getCandidateimage() {
//        return candidateimage;
//    }
//
//    public void setCandidateimage(byte[] candidateimage) {
//        this.candidateimage = candidateimage;
//    }
//
//    public byte[] getLogoimage() {
//        return logoimage;
//    }
//
//    public void setLogoimage(byte[] logoimage) {
//        this.logoimage = logoimage;
//    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVotername() {
        return votername;
    }

    public void setVotername(String votername) {
        this.votername = votername;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
