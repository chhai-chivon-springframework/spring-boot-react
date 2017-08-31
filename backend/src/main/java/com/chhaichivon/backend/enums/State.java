package com.chhaichivon.backend.enums;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/31/2017
 * TIME   : 9:03 AM
 */
public enum  State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;

    private State(final String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return this.state;
    }


    public String getName(){
        return this.name();
    }
}
