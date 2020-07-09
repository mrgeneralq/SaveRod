package me.qintinator.saverod.statics;

import java.io.File;
import java.util.HashMap;
import org.bukkit.Bukkit;

import me.qintinator.saverod.enums.ConfigProperty;
import me.qintinator.saverod.model.ConfigProp;
import me.qintinator.saverod.Main;

public class ConfigPropertyMapper {
	
	
	private static Main instance;
	private static HashMap<ConfigProperty, ConfigProp> configProperties = new HashMap<ConfigProperty,ConfigProp>();

	
	public static void run(Main main) {
		instance = main;
		
		// start mapping of all properties
		mapAllProperties();				
	}
	
	
	public static Object get(ConfigProperty configProperty) {					
			return instance.getConfig().get(configProperties.get(configProperty).getPath());
		}	
	
	
	
	private static void map(ConfigProperty property, String path) {
		
		if(instance.getConfig().get(path) == null) {
			Bukkit.getLogger().warning("Invalid/missing path in config: [" + path + "]" + "creating new config....");
			restoreConfig();
			mapAllProperties();
			return;
		}
		
		ConfigProp prop = new ConfigProp(property, path);
		configProperties.put(property, prop);	
	}
		
	
	
	private static void restoreConfig() {
				
		File workingName = new File(instance.getDataFolder(), "config.yml");
				
		File brokenName = new File(instance.getDataFolder(),"config.yml.BROKEN");
		if(brokenName.exists())
			brokenName.delete();
		
		if(workingName.exists())
		workingName.renameTo(brokenName);
		
		instance.saveDefaultConfig();
		instance.reloadConfig();
	}
	
	private static void mapAllProperties() {
		
		configProperties.clear();
		
		// map here all properties for the config file		
		map(ConfigProperty.SAVEROD_ITEMNAME, "item.display-name");
		map(ConfigProperty.SAVEROD_LORE, "item.lore");
		map(ConfigProperty.SAVEROD_MATERIAL, "item.material");
		map(ConfigProperty.KEEP_LEVEL, "keep-levels");
		map(ConfigProperty.MATERIAL_ONLY, "item.material-only");

		
		
		// map here all the messages for the config file
		map(ConfigProperty.MSG_GIVE_OTHER_SAVEROD, "messages.give-other");
		map(ConfigProperty.MSG_GIVE_SAVEROD, "messages.give-yourself");
		map(ConfigProperty.MSG_ITEM_WERE_SAVED, "messages.items-saved");
		map(ConfigProperty.MSG_RECEIVED_ROD, "messages.received");
		map(ConfigProperty.MSG_CONFIG_RELOADED, "messages.config-reloaded");
		
		
	}


}
