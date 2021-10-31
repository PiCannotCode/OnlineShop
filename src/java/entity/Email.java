/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author hanoon
 */
public class Email {
    private String from ;
    private String to ;
    private String fromPassword ; 
    private String content ;
    private String subject ;

    public Email() {
    }

    public Email(String from, String to, String fromPassword, String content, String subject) {
        this.from = from;
        this.to = to;
        this.fromPassword = fromPassword;
        this.content = content;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
