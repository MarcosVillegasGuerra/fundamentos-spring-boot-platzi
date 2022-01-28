package com.marcos.demo.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int numero = 1;
        LOGGER.debug("El numero enviado como parametro a la dependecia operation es: "+ numero);
        System.out.println(myOperation.sum(numero));;
        System.out.println("Hola desde la implementacion de un bean con dependencia");
        
    }
    
}
