package me.qintinator.saverod.statics;

import me.qintinator.saverod.contracts.*;
import me.qintinator.saverod.repositories.ConfigPropertyRepository;
import me.qintinator.saverod.repositories.SaverodRepository;
import me.qintinator.saverod.services.ConfigPropertyService;
import me.qintinator.saverod.services.MessageService;
import me.qintinator.saverod.services.SaverodService;

public class Bootstrapper {

	private static Bootstrapper instance;

	private static ISaverodService saverodService;
	private static ISaverodRepository saverodRepository;
	private static IConfigPropertyService configPropertyService;
	private static IConfigPropertyRepository configPropertyRepository;
	private static IMessageService messageService;

	private Bootstrapper(){ }

	public static Bootstrapper getBootstrapper(){
		if(instance == null)
			instance = new Bootstrapper();
		return instance;
	}

	public static void run() {	
		saverodRepository = new SaverodRepository();
		saverodService = new SaverodService(saverodRepository);		
		messageService = new MessageService();
		
		configPropertyRepository = new ConfigPropertyRepository();
		configPropertyService = new ConfigPropertyService(configPropertyRepository);

	}

	public static IMessageService getMessageService() {
		return messageService;
	}

	public IConfigPropertyService getConfigPropertyService() {
		return configPropertyService;
	}
	public IConfigPropertyRepository getConfigPropertyRepository() {
		return configPropertyRepository;
	}
	public ISaverodRepository getSaverodRepository() {
		return saverodRepository;
	}
	public ISaverodService getSaverodService() {
		return saverodService;
	}
	

}
