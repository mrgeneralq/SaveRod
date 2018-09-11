package me.qintinator.saverod.services;

import org.bukkit.inventory.ItemStack;

import me.qintinator.saverod.contracts.ISaverodRepository;
import me.qintinator.saverod.contracts.ISaverodService;

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
	

}
