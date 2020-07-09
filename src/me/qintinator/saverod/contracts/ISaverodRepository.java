package me.qintinator.saverod.contracts;

import org.bukkit.inventory.ItemStack;

public interface ISaverodRepository {

	ItemStack getSaveRod();
	void setSaveRod(ItemStack saveRod);
	
}
