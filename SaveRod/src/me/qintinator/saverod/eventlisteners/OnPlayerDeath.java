package me.qintinator.saverod.eventlisteners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.qintinator.saverod.contracts.IConfigPropertyService;
import me.qintinator.saverod.contracts.ISaverodService;
import me.qintinator.saverod.statics.SaverodMessages;


public class OnPlayerDeath implements Listener {
	
	private final ISaverodService saverodService;
	private final IConfigPropertyService configPropertyService;
	
	public OnPlayerDeath(ISaverodService saverodService, IConfigPropertyService configPropertyService) {
		this.saverodService = saverodService;
		this.configPropertyService = configPropertyService;
	}
	
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		Player player = e.getEntity();
		
		for(ItemStack item: player.getInventory().getContents()) {
			
			if(item == null)
				continue;
			
			if(!item.isSimilar(saverodService.getSaveRod()))
				continue;
			
			e.setKeepInventory(true);
			
			if(configPropertyService.keepLevels())
			e.setKeepLevel(true);
			
				
			if(item.getAmount() > 1)
				item.setAmount(item.getAmount() -1);
			else	
			player.getInventory().remove(saverodService.getSaveRod());		
			
			player.sendMessage(SaverodMessages.itemsSaved);
			break;
				
		}
		
	}

}
