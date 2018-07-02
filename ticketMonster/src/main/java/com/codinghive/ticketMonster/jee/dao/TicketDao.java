package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import com.google.gson.Gson;
import org.slf4j.Logger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;

@Stateless(name = "TicketDAO")
public class TicketDao {

    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);
    protected static final String STUDENT_PU = "mariaDB-eclipselink";
    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;


    ////////////////////////////////////////
    public void addTicket(Ticket ticket) {
        //communication with database is on
        em.getTransaction().begin();
        //add ticket
        em.persist(ticket);
        //communication with database is off
        em.getTransaction().commit();
        LOGGER.info("Created Ticket:" + ticket);
    }

    ////////////////////////////////////////
    public int reserveTicket(int id) {
        Ticket ticket = search(id);
        // if ticket id not found
        if ( ticket == null){
            LOGGER.info("Ticket with id:" + ticket.getUser_Id() + "doesn't exist.");
            return 0;
        }
        int bookedFlag = ticket.getT_booked();
        if (bookedFlag != 0) {
            LOGGER.info("Ticket:" + ticket + "is already reserved.");
            return 0;
        } else {
            //communication with database is on
            em.getTransaction().begin();
            ticket.setT_booked(1);
            LOGGER.info("Ticket:" + ticket + "is reserved now for user by ID: " + ticket.getT_id());
            //communication with database is of
            em.getTransaction().commit();
            return 1;
        }
    }

    ////////////////////////////////////////    
    public String getJsonsFromDB() {
        //necessary for appropriate json formating
        String returnString = "[";
        //Gson object initiation so i can call json methods
        Gson gson = new Gson();
        //list with tickets that i will store my ticket objects and toJson() transform them
        List<Ticket> ticketObj = getAllTicket();
        //loop for number of tickets found in database
        for (int i = 0; i < ticketObj.size(); i++) {
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketObj.get(i));
            //necessary for appropriate json formating
            if (i != ticketObj.size() - 1) {
                returnString = returnString.concat(jsonInString + ",");
            } else {
                returnString = returnString.concat(jsonInString);
            }
            //            LOGGER.info("Printing jsonString:" + jsonInString);
        }
        //necessary for appropriate json formating
        returnString = returnString.concat("]");
        LOGGER.info("Printing DATABASE Json:" + returnString);
        return returnString;
    }

    ////////////////////////////////////////            
    public List<Ticket> getAllTicket() {
        //returns all tickets in a List<ticket>
        return em.createNamedQuery("Ticket.getAll").getResultList();
    }

    ////////////////////////////////////////
    public Ticket search(int id) {
        //returns ticket entity by id  = this.id
        return em.find(Ticket.class, id);
    }
    
    ////////////////////////////////////////
    public void addTicketFromJson(String jsonStringData) {
        //Create Json Object from JsonStringData
        final JSONObject obj = new JSONObject(jsonStringData);
        //Create ticket object from JsonObject
        Ticket ticket = new Ticket(obj.getInt("t_id"), obj.getString("t_title"), obj.getInt("t_price"), obj.getInt("user_id"), obj.getInt("t_booked"));
        //Add Ticket Object to DB
        addTicket(ticket);
        LOGGER.info("Created and added ticket to database from REST endpoint");
    }
}
