package com.codinghive.ticketMonster.jee.model;

import java.io.Serializable;
//import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({
@NamedQuery(name = "User.getAll", query = "SELECT e FROM User e")})
public class User implements Serializable {

    @Id
    @Column
    private String u_Name;
    @Column
    private int u_Id;
    @Column
    private String u_Pw;
    @Column
    private String u_Fname;
    
//    private boolean u_Admin;
//    private ArrayList<Ticket> u_Tickets;


    //GETTERS START HERE
    public String getU_Name() {
        return u_Name;
    }
    
    public int getU_id() {
        return u_Id;
    }
    
    public String getU_Pw() {
        return u_Pw;
    }

    private String getU_Fname(){
        return u_Fname;
    }
    //GETTERS END HERE

    
    //SETTERS START HERE
    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }
    
    public void setU_id(int u_id) {
        this.u_Id = u_id;
    }

    public void setU_Pw(String u_Pw) {
        this.u_Pw = u_Pw;
    }
     
    public void setU_Fname(String u_Fname) {
        this.u_Fname = u_Fname;
    }
    //SETTERS END HERE

   

    
    public void isU_Admin() {
        //to DO
    }

    public void setU_Admin(int u_id) {
        //to DO
    }

    public void addTicketToArray(Ticket ticket) {
        //to DO
    }
    
    
    public User(String u_Name, int u_Id, String u_Pw, String u_Fname) {
        this.u_Name = u_Name;
        this.u_Id = u_Id;
        this.u_Pw = u_Pw;
        this.u_Fname = u_Fname;
    }
    
    public User() {
    }
    
    
    @Override
    public String toString() {
        return "User{ " + "u_Id= " + u_Id + ", u_name= " + u_Name + ", u_Fname= " + u_Fname + '}';
    }


}


