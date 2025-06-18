package com.zzpzaf.se.blogbackdemo4.dbObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentType {

    @JsonProperty("cont_type_id")
    private int cont_type_id;
    @JsonProperty("cont_type_identifier")
    private String cont_type_identifier;

    // Default Constructor
    public ContentType() {}

    public int getCont_type_id() {
        return cont_type_id;
    }

    public void setCont_type_id(int cont_type_id) {
        this.cont_type_id = cont_type_id;
    }

    public String getCont_type_identifier() {
        return cont_type_identifier;
    }

    public void setCont_type_identifier(String cont_type_identifier) {
        this.cont_type_identifier = cont_type_identifier;
    }

    // Optional: Override toString for easy debugging
    @Override
    public String toString() {
        return "ContenTypes{" +
                "cont_type_id=" + cont_type_id +
                ", cont_type_identifier='" + cont_type_identifier + '\'' +
                '}';
    }
    
}
