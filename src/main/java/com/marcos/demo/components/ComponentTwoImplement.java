package com.marcos.demo.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola mundo desde componente 2");
        
    }
    
}
