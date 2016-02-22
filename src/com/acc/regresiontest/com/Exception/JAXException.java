package com.acc.regresiontest.com.Exception;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class JAXException extends Exception {
    private String missatge;

    public JAXException(String message) {
        super(message);
        this.missatge = message;
    } 
    
    public JAXException() {
    }

    public String getMissatge() {
        return missatge;
    }

    public void setMissatge(String missatge) {
        this.missatge = missatge;
    }
    
    
}
