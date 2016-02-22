package com.acc.regresiontest.com.domains;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
 public class Error {
     private String id;
     private String message;

     public Error() {
     }

     public Error(String id, String message) {
         this.id = id;
         this.message = message;
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getMessage() {
         return message;
     }

     public void setMessage(String message) {
         this.message = message;
     }
 }

