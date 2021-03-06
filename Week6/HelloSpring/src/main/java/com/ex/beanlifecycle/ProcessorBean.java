package com.ex.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProcessorBean implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean,
			String beanName) throws BeansException {
		if(bean instanceof ParentBean){
			// do something special for parentbean
			System.out.println("AfterInitialization " + 
						beanName + " " + bean);
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean,
			String beanName) throws BeansException {
		if(bean instanceof ParentBean){
			// do something special for parentbean
			System.out.println("BeforeInitialization " + 
						beanName + " " + bean);
		}
		return bean;
	}

}
