/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.model;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import com.codinghive.ticketMonster.jee.dao.TicketDaoLocal;
import com.codinghive.ticketMonster.jee.injection01.TicketServlet;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Ticket.getAll", query = "SELECT e FROM Ticket e") })
public class Ticket implements Serializable {
    
    // Create Columns
	@Id
    @Column
    private int ticketId;
        
    @Column
    private String t_title;
        
    @Column
    private String t_price;
        
    @Column
    private int user_Id; 
    
    @Column
    private int booked;

   

    
    
    
    

  
    //    Getters ------------------------

    public int getTicketId() {
        return ticketId;
    }

    public String getT_title() {
        return t_title;
    }

    public String getT_price() {
        return t_price;
    }

    public int getUser_Id() {
        return user_Id;
    }
      
    public int getBooked() {
        return booked;
    }
   //    END Getters ------------------------

 

    
    
   //    Setters ------------------------
    
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public void setT_price(String t_price) {
        this.t_price = t_price;
    }


    public void setUser_Id(int user_Id) {    
        this.user_Id = user_Id;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }
//   END  Setters ------------------------

    


//   Constructor ------------------------

    public Ticket(int ticketId, String t_title, String t_price, int user_Id, int booked) {
        this.ticketId = ticketId;
        this.t_title = t_title;
        this.t_price = t_price;
        this.user_Id = user_Id;
        this.booked = booked;
    }
    
    //Ticket t = new Ticket(1,"asfafas","21",1);
    
    public Ticket() {
    }
    
    public Ticket(int ticketId, int i) {
        this.ticketId = ticketId;
        this.booked=i;
    }
    
//   END  Constructor ------------------------
//    
    
    @Override
    public String toString() {
        return "Users{" + "ticketId=" + ticketId + ", t_title='" + t_title + '\'' + ", t_price='" + t_price + '\''
                + ", user_Id=" + user_Id  + ", booked=" + booked+ '}';
    }

    
   
    
    
}