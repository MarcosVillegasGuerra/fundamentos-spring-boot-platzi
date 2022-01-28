package com.marcos.demo.bean;


public class BeanPersonalizadoImplement implements BeanPersonalizado {
    private MyOperation myoperation;

    public BeanPersonalizadoImplement(MyOperation myoperation) {
        this.myoperation = myoperation;
    }

    @Override
    public void suma(int numeroUno, int numeroDos){
        int suma = numeroUno + numeroDos;
        System.out.println(suma);
        System.out.println(myoperation.sum(suma));
    }
}
