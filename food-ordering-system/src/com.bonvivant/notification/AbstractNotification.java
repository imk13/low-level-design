package com.bonvivant.notification;

public abstract class AbstrsactNotification {
    String content;
    Boolean isSent;
    public Boolean getIsSent(){
        return isSent;
    }
    public void setIsSent(){
        isSent = true;
    }
    public abstract void send();
}