package com.nhnacademy.springmvc.domain;

public enum Category {
     COMPLAINT("complaint"),
     OFFER("offer"),
     RETURN_AND_CHANGE("returnAndChange"),
     COMPLIMENT("compliment"),
     ETC("etc");

     private final String categoryName;
     Category(String categoryName){
          this.categoryName = categoryName;
     }

     public String getName() {
          return categoryName;
     }
}
