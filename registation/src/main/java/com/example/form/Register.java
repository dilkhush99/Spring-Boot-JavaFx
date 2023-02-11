package com.example.form;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Register {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty college;
    private StringProperty email;
    private LongProperty phone;

    public IntegerProperty idProp(){
        if(id==null)
        id = new SimpleIntegerProperty();
        return id;

    }

    public StringProperty nameProp(){
        if(name==null)
        name = new SimpleStringProperty();
        return name;

    }

    public StringProperty collegeProp(){
        if(college==null)
        college = new SimpleStringProperty();
        return college;

    }

    public StringProperty emailProp(){
        if(email==null)
        email = new SimpleStringProperty();
        return email;
    }

    public LongProperty phoneProp(){
        if(phone==null)
        phone = new SimpleLongProperty();
        return phone;

    }

    public Integer getId() {
        
        return idProp().get();
    }
   
    public String getName() {
        return nameProp().get();
    }
 
    public String getCollege() {
        return collegeProp().get();
    }
   
    public String getEmail() {
        return emailProp().get();
    }
 
    public Long getPhone() {
        System.out.println("phone"+phone);
        return phoneProp().get();
    }

    
   
    public Register(Integer id, String name, String college,
    String email, Long phone) {
        setId(id);
        setName(name);
        setCollege(college);
        setEmail(email);
        setPhone(phone);
    }
    private void setPhone(Long phone) {
        System.out.println("phone"+phone);
        phoneProp().setValue(phone);
    }
    private void setCollege(String college) {
        collegeProp().setValue(college);
    }
    private void setEmail(String email) {
        emailProp().setValue(email);
    }
    private void setName(String name) {
        nameProp().setValue(name);
    }
    private void setId(Integer id) {
        idProp().setValue(id);
    }

    @Override
    public String toString() {
        return "Register [id=" + id + ", name=" + name + ", college=" + college + ", email=" + email + ", phone="
                + phone + "]";
    }
    
}
