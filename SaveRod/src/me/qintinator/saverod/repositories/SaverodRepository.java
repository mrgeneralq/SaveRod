package me.qintinator.saverod.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.qintinator.saverod.contracts.ISaverodRepository;
import me.qintinator.saverod.enums.ConfigProperty;
import me.qintinator.saverod.statics.ConfigPropertyMapper;

public class SaverodRepository implements ISaverodRepository {
	


	@Override
	public ItemStack getSaveRod() {
	
		ItemStack saverod = new ItemStack(Material.getMaterial((String) ConfigPropertyMapper.get(ConfigProperty.SAVEROD_MATERIAL)));
		ItemMeta meta  = saverod.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',(String) ConfigPropertyMapper.get(ConfigProperty.SAVEROD_ITEMNAME)));
		List<String> lore = new ArrayList<>();
		
		if(ConfigPropertyMapper.get(ConfigProperty.SAVEROD_LORE) != null){
		lore.add(ChatColor.translateAlternateColorCodes('&', (String) ConfigPropertyMapper.get(ConfigProperty.SAVEROD_LORE)));
		meta.setLore(lore);
		}
		
		saverod.setItemMeta(meta);			
		return saverod;
	}

	@Override
	public void setSaveRod(ItemStack saveRod) {
		// TODO Auto-generated method stub
		
	}

}
