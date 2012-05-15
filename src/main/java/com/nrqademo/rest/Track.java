/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrqademo.rest;

/**
 *
 * @author qa
 */
public class Track {
    
    private String title;

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private String singer;

    @Override
    public String toString() {
        return "Track{" + "title=" + title + ", singer=" + singer + '}';
    }
    
}
