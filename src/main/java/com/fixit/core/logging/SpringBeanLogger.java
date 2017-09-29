/**
 * 
 */
package com.fixit.core.logging;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/15 21:56:33 GMT+3
 */
//@Component
public class SpringBeanLogger implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	//	FILog.i("Created bean " + beanName + " for class " + bean.getClass().getName());
		return bean;
	}

}
