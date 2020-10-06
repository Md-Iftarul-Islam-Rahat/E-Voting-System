
package com.maven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parties")
public class Parties {
    
    @Id
    @Column(name = "id")
    private int id;
    
    
    @Column(name = "partycode")
    private String partycode;
    
    @Column(name = "partyname")
    private String partyname;
    
    @Column(name = "logoname")
    private String logoname;
    
    @Column(name = "imglogo")
    private byte[] imglogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartycode() {
        return partycode;
    }

    public void setPartycode(String partycode) {
        this.partycode = partycode;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getLogoname() {
        return logoname;
    }

    public void setLogoname(String logoname) {
        this.logoname = logoname;
    }

    public byte[] getImglogo() {
        return imglogo;
    }

    public void setImglogo(byte[] imglogo) {
        this.imglogo = imglogo;
    }

    
    
}
