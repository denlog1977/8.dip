package com.example.a8dip;


import java.util.Date;

class Note {

    String headLine;
    String body;
    boolean hasDeadLine;
//    Date deadLineDay;
    String deadLineDay;

//    public Note(String headLine, String body, boolean hasDeadLine, Date deadLineDay) {
//        this.headLine = headLine;
//        this.body = body;
//        this.hasDeadLine = hasDeadLine;
//        this.deadLineDay = deadLineDay;
//    }
    public Note(String headLine, String body, boolean hasDeadLine, String deadLineDay) {
        this.headLine = headLine;
        this.body = body;
        this.hasDeadLine = hasDeadLine;
        this.deadLineDay = deadLineDay;
    }

    public Note(String headLine, String body, boolean hasDeadLine) {
        this.headLine = headLine;
        this.body = body;
        this.hasDeadLine = hasDeadLine;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getHasDeadLine() {
        return hasDeadLine;
    }

    public void setHasDeadLine(boolean hasDeadLine) {
        this.hasDeadLine = hasDeadLine;
    }

//    public Date getDeadLineDay() {
//        return deadLineDay;
//    }
//
//    public void setDeadLineDay(Date deadLineDay) {
//        this.deadLineDay = deadLineDay;
//    }

    public String getDeadLineDay() {
        return deadLineDay;
    }

    public void setDeadLineDay(String deadLineDay) {
        this.deadLineDay = deadLineDay;
    }

}