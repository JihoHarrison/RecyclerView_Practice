package com.jiho.recyclerview.model;

public class MainModel {
    private String id;
    private String statusMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "id='" + id + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
