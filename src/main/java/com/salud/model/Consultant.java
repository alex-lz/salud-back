package com.salud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consultant")
public class Consultant {
	
    private long consultantID;
    private String mail;
    private String consultantPassword; 
    private String consultantName; 
    private String consultantLastName;
    private String sex;
    private String telephone;
    private boolean status;

 
    public Consultant() {
  
    }
 
    public Consultant(String mail, String consultantPassword, String consultantName, String consultantLastName, String sex, String telephone, boolean status) {
         this.mail = mail;
         this.consultantPassword = consultantPassword;
         this.consultantName = consultantName;
         this.consultantLastName = consultantLastName;
         this.sex = sex;
         this.telephone = telephone;
         this.status = status;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getConsultantID() {
        return consultantID;
    }
    public void setConsultantID(long consultantID) {
        this.consultantID = consultantID;
    }
    
    @Column(name = "mail", nullable = false)
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
 
    @Column(name = "consultantpassword", nullable = false)
    public String getConsultantPassword() {
        return consultantPassword;
    }
    public void setConsultantPassword(String consultantPassword) {
        this.consultantPassword = consultantPassword;
    }
 
    @Column(name = "consultantname", nullable = false)
    public String getConsultantName() {
        return consultantName;
    }
    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }
    
    @Column(name = "consultantlastname", nullable = false)
    public String getConsultantLastName() {
        return consultantLastName;
    }
    public void setConsultantLastName(String consultantLastName) {
        this.consultantLastName = consultantLastName;
    }
    
    @Column(name = "sex", nullable = false)
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Column(name = "telephone", nullable = false)
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name = "status", nullable = false)
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
 


    @Override
    public String toString() {
        return "Consultant [ consultantID=" + consultantID + ", mail=" + mail + ", consultantPassword=" + consultantPassword + 
        		", consultantName=" + consultantName + ", consultantLastName=" + consultantLastName + ", sex=" + sex + ", telephone=" +
        		telephone + ", status=" + status + "]";
    }

}
