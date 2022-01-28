package com.marcos.demo.configuration;

import com.marcos.demo.bean.BeanPersonalizado;
import com.marcos.demo.bean.BeanPersonalizadoImplement;
import com.marcos.demo.bean.MyBean;
import com.marcos.demo.bean.MyBean2Implement;
import com.marcos.demo.bean.MyBeanImplement;
import com.marcos.demo.bean.MyBeanWithDependency;
import com.marcos.demo.bean.MyBeanWithDependencyImplement;
import com.marcos.demo.bean.MyOperation;
import com.marcos.demo.bean.MyOperationImplement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    
    @Bean
    public MyBean beanOperation() {
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myoperation) {
        return new MyBeanWithDependencyImplement(myoperation);
    }

    @Bean 
    public BeanPersonalizado beanOperationPersonalizado(MyOperation myoperation) {
        return new BeanPersonalizadoImplement(myoperation);
    }
}
