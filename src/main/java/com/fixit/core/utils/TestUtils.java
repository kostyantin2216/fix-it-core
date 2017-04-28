package com.fixit.core.utils;

import java.util.ArrayList;
import java.util.List;

import com.fixit.core.data.WorkingDay;
import com.fixit.core.data.WorkingHours;
import com.fixit.core.data.mongo.Tradesman;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/15 16:51:58 GMT+3
 */
public class TestUtils {
	
	public static List<Tradesman> createDummyTradesmen(int count) {
		List<Tradesman> tradesmen = new ArrayList<>();
		for(int i = 0; i < count; i++) {
			tradesmen.add(createDummyTradesman());
		}
		return tradesmen;
	}

	public static Tradesman createDummyTradesman() {
		Tradesman tradesman = new Tradesman();
		tradesman.setLeadId(123);
		tradesman.setProffesionId(1);
		tradesman.setContactName("Bob Test");
		tradesman.setCompanyName("Bob's Test Plumbers");
		tradesman.setEmail("kostya2216@gmail.com");
		tradesman.setTelephone("0502835431");
		tradesman.setPassword("123456");
		tradesman.setLogoUrl("https://thelogocompany.net/wp-content/uploads/2016/10/main_calltheplumber.jpg");
		tradesman.setWorkingDays(createWorkingDays());
		return tradesman;
	}
	
	public static WorkingDay[] createWorkingDays() {
		WorkingDay[] wokringDays = new WorkingDay[5];
		for(int i = 0; i < 5; i++) {
			wokringDays[i] = new WorkingDay(i + 1, createWorkingHours());
		}
		return wokringDays;
	}
	
	
	public static WorkingHours[] createWorkingHours() {
		return new WorkingHours[] {
				new WorkingHours(9.30, 13.0),
				new WorkingHours(15.00, 21.30)
		};
	}
}
