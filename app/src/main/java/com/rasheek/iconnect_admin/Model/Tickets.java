package com.rasheek.iconnect_admin.Model;

public class Tickets {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tickets(String title, String body, String type) {
        this.title = title;
        this.body = body;
        this.type = type;
    }

    public Tickets() {
    }

    String title;
    String body;
    String type;
}
