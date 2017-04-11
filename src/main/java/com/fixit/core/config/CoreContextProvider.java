package com.fixit.core.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.fixit.core.dao.mongo.MapAreaDao;
import com.fixit.core.dao.mongo.SynchronizationParamsDao;
import com.fixit.core.dao.mongo.impl.MapAreaDaoImpl;
import com.fixit.core.dao.mongo.impl.SynchronizationParamsDaoImpl;
import com.fixit.core.dao.sql.ReviewDao;
import com.fixit.core.dao.sql.impl.ReviewDaoImpl;
import com.fixit.core.search.SearchExecutor;

@Component
public class CoreContextProvider implements ApplicationContextAware {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	// Data Access Objects
	public static SynchronizationParamsDao getSynchronizationParamsDao() {
		return context.getBean(SynchronizationParamsDaoImpl.class);
	}
	
	public static MapAreaDao getMapAreaDao() {
		return context.getBean(MapAreaDaoImpl.class);
	}
	
	public static ReviewDao getReviewDao() {
		return context.getBean(ReviewDaoImpl.class);
	}
	
	// Services
	public static MongoClientManager getMongoClientManager() {
		return context.getBean(MongoClientManager.class);
	}
	
	public static GsonManager getGsonManager() {
		return context.getBean(GsonManager.class);
	}
	
	public static SearchExecutor getSearchExecutor() {
		return context.getBean(SearchExecutor.class);
	}
	
}
