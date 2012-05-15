/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrqademo.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author qa
 */
@Path("/json/music")
public class JSONService {
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getTracksInJSON() {
        
        List<Track> tracks = new ArrayList<Track>();
        Track track1 = new Track();
        track1.setTitle("Singing in the rain");
        track1.setSinger("Gene Kelly");
        
        tracks.add(track1);
        
        Track track2 = new Track();
        track2.setTitle("Wonderful Worlds");
        track2.setSinger("Louis Armstrong");
        tracks.add(track2);
        
        
        Track track3 = new Track();
        track3.setTitle("You'll never walk alone");
        track3.setSinger("Gerry and the Pacemakers");
        tracks.add(track3);
        
        
        Track track4 = new Track();
        track4.setTitle("My Way");
        track4.setSinger("Frank Sinatra");
        tracks.add(track4);
        
        return tracks;
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {
        
        Track track = new Track();
        track.setTitle("Singing in the rain");
        track.setSinger("Gene Kelly");
        
        return track;
    }
    
    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {
        
        String result = "Track saved: " + track;
        return Response.status(Response.Status.OK).entity(result).build();
    }
}
