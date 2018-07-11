package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import org.slf4j.Logger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.LoggerFactory;

@Stateless(name = "TicketDAO")
public class TicketDao {

    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);
    protected static final String STUDENT_PU = "mariaDB-eclipselink";
    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;

    //add ticket entity to the database
    ///////////////////////////////////
    public void addTicket(Ticket ticket) {
        //communication with database is on
        em.getTransaction().begin();
        em.persist(ticket);
        //communication with database is off
        em.getTransaction().commit();
        LOGGER.info("Created Ticket:" + ticket);
    }
    
    //function that updates a registry into the db
    /////////////////////////////////
    public void dbUpdate(Ticket ticket){
        em.getTransaction().begin();
        LOGGER.info("ID:" + ticket.getT_booked());
        em.merge(ticket);
        em.getTransaction().commit();
        LOGGER.info("merge Ticket into db");       
    } 
   
    
    //function that returns Ticket Object found in DB with id = this.id
    /////////////////////////////////
    public Ticket getTicketById(int id) {
        //returns ticket entity by id  = this.id
        return em.find(Ticket.class, id);
    }
      
    //function that returns all tickets in DB in a List<Ticket>
    ////////////////////////////////            
    public List<Ticket> getAllTicketList() {
        //returns all tickets in a List<ticket>
        return em.createNamedQuery("Ticket.getAll").getResultList();
    }
    
    //function that returns all tickets in DB in a List<Ticket> that are Available
    /////////////////////////////////////    
    public List<Ticket> getAvailableTickets(){ 
        return em.createQuery(
            "SELECT u from Ticket u WHERE u.t_booked=0", Ticket.class).getResultList();
    }     
}
