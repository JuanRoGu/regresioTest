package com.acc.regresiontest.com.api.bussineslogic;


import java.util.ArrayList;

import com.acc.regresiontest.com.domains.Error;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ModelError {

    private ArrayList<Error> errors;
    
    public ModelError(){
        errors = new ArrayList<>();
    }
    
    public void addModelError(String id, String message){
        Error e = new Error(id, message);
        errors.add(e);
    }

    public ArrayList<Error> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Error> errors) {
        this.errors = errors;
    }
    
    public boolean hasErrors(){
        return !this.errors.isEmpty();
    }
 
}


