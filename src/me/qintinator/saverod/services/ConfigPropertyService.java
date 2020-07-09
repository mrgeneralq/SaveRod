package me.qintinator.saverod.services;

import me.qintinator.saverod.contracts.IConfigPropertyRepository;
import me.qintinator.saverod.contracts.IConfigPropertyService;

public class ConfigPropertyService implements IConfigPropertyService {

	private IConfigPropertyRepository configPropertyRepository;
	
	
	 public ConfigPropertyService(IConfigPropertyRepository configPropertyRepository) {
		this.configPropertyRepository = configPropertyRepository;
	}
	
	
	@Override
	public Boolean keepLevels() {
		return configPropertyRepository.keepLevels();
	}

	
	
}
