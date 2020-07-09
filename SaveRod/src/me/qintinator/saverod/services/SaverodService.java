package me.qintinator.saverod.services;

import org.bukkit.inventory.ItemStack;

import me.qintinator.saverod.contracts.ISaverodRepository;
import me.qintinator.saverod.contracts.ISaverodService;
import me.qintinator.saverod.enums.ConfigProperty;
import me.qintinator.saverod.statics.ConfigPropertyMapper;

public class SaverodService implements ISaverodService{
	
	private final ISaverodRepository saverodRepository;
	
	public SaverodService(ISaverodRepository repository) {
		this.saverodRepository = repository;
	}
	
	@Override
	public ItemStack getSaveRod() {
		return saverodRepository.getSaveRod();
	}

	@Override
	public void setSaveRod(ItemStack saveRod) {
		saverodRepository.setSaveRod(saveRod);		
	}

	@Override
	public boolean isSaveRod(ItemStack itemStack) {

		if((boolean) ConfigPropertyMapper.get(ConfigProperty.MATERIAL_ONLY)) {
			// material only on
			if(itemStack.getType() == getSaveRod().getType())
				return true;		
		}
			
		if(itemStack.isSimilar(getSaveRod()))
				return true;
				
		return false;
	}
}
