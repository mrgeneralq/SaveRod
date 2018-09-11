package me.qintinator.saverod.statics;

import me.qintinator.saverod.contracts.IConfigPropertyRepository;
import me.qintinator.saverod.contracts.IConfigPropertyService;
import me.qintinator.saverod.contracts.ISaverodRepository;
import me.qintinator.saverod.contracts.ISaverodService;
import me.qintinator.saverod.repositories.ConfigPropertyRepository;
import me.qintinator.saverod.repositories.SaverodRepository;
import me.qintinator.saverod.services.ConfigPropertyService;
import me.qintinator.saverod.services.SaverodService;

public abstract class Bootstrapper {
	
	
	private static ISaverodService saverodService;
	private static ISaverodRepository saverodRepository;	
	private static IConfigPropertyService configPropertyService;
	private static IConfigPropertyRepository configPropertyRepository;

	
	
	public static void run() {	
		saverodRepository = new SaverodRepository();
		saverodService = new SaverodService(saverodRepository);		
		
		
		configPropertyRepository = new ConfigPropertyRepository();
		configPropertyService = new ConfigPropertyService(configPropertyRepository);

	}
	
	
	public static IConfigPropertyService getConfigPropertyService() {
		return configPropertyService;
	}


	public static IConfigPropertyRepository getConfigPropertyRepository() {
		return configPropertyRepository;
	}


	public static ISaverodRepository getSaverodRepository() {
		return saverodRepository;
	}
	
	public static ISaverodService getSaverodService() {
		return saverodService;
	}
	

}
