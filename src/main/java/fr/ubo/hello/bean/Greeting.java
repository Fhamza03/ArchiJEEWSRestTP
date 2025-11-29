package fr.ubo.hello.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

    @JsonProperty
    private String message;

    @JsonProperty
    private String auteur;

    public Greeting(String message, String auteur) {
        this.message = message;
        this.auteur = auteur;
    }

    public Greeting() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}
