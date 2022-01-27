package com.marcos.demo.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola Mundo desde mi coponente");
        
    }
    
}
