package com.example.demotutorial;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

import java.util.Date;

@Entity
public class Note {
    @Id
    private long id;

    private String text;
    private String comment;
    private Date date;

    public Note() {
    }

    public Note(String text, String comment, Date date) {
        this.text = text;
        this.comment = comment;
        this.date = date;
    }

    public Note(long id, String text, String comment, Date date) {
        this.id = id;
        this.text = text;
        this.comment = comment;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
