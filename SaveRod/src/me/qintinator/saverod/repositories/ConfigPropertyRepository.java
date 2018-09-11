package me.qintinator.saverod.repositories;

import me.qintinator.saverod.contracts.IConfigPropertyRepository;
import me.qintinator.saverod.enums.ConfigProperty;
import me.qintinator.saverod.statics.ConfigPropertyMapper;

public class ConfigPropertyRepository implements IConfigPropertyRepository {
	
	@Override
	public Boolean keepLevels() {
		return (Boolean) ConfigPropertyMapper.get(ConfigProperty.KEEP_LEVEL);
	}

}
