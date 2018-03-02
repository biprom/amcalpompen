package com.biprom.amcal.amcalpompen.SubWindows;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class TestClass {

    private String message;

    public TestClass() {
        System.out.println( "Bram is een sexy mudderfucker!!!" );
    }

    public void setMessage(String message){
        this.message = message;
        System.out.println( "Dit heb je geschreven : " + message);
    }
}
