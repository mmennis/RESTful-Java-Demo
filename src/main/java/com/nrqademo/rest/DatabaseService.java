/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrqademo.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author qa
 */
@Path("/petclinic")
public class DatabaseService {
    
    @GET
    @Path("/sleep/{param}")
    public Response getSleep(@PathParam("param") String sleepTime) {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/PetclinicDB");
            
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SLEEP(" + sleepTime + ") ");
            
        } catch (SQLException ex) {
            Logger.getLogger(HelloWorldService.class.getName()).log(Level.SEVERE, "SQL Problem with database", ex);
        } catch (NamingException ex) {
            Logger.getLogger(HelloWorldService.class.getName()).log(Level.SEVERE, "Problem with context object", ex);
        }
        
        String output = "Slept for " + sleepTime + " seconds";
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/owners")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PetOwner> getPetOwners() {
        
        String query = "SELECT * FROM owners ";
        return getOwnerList(query);
    }
    
    @GET
    @Path("/owners/select/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PetOwner> getPetOwnersByName(@PathParam("param") String name) {
        
        String query = "SELECT * FROM owners where last_name like '%" + name + "%'";
        return getOwnerList(query);
    }
    
    
    private List<PetOwner> getOwnerList(String query) {
        
        List<PetOwner> owners = new ArrayList<PetOwner>();
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/PetclinicDB");
            
            Connection conn = ds.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                PetOwner o = new PetOwner();
                o.setFirstName(rs.getString("first_name"));
                o.setLastName(rs.getString("last_name"));
                o.setAddress(rs.getString("address"));
                o.setCity(rs.getString("city"));
                o.setTelephone(rs.getString("telephone"));
                owners.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, "SQL Problem with database", ex);
        } catch (NamingException ex) {
            Logger.getLogger(DatabaseService.class.getName()).log(Level.SEVERE, "Problem with context object", ex);
        }
        return owners;
    }
}
