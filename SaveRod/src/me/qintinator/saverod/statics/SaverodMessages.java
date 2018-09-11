package me.qintinator.saverod.statics;

import org.bukkit.ChatColor;
import me.qintinator.saverod.enums.ConfigProperty;

public class SaverodMessages {
		
	
	public static String givenSaveRod = getMessage(ConfigProperty.MSG_GIVE_SAVEROD);
	public static String givenSaveRodOther = getMessage(ConfigProperty.MSG_GIVE_OTHER_SAVEROD);	
	public static String itemsSaved = getMessage(ConfigProperty.MSG_ITEM_WERE_SAVED);
	public static String noPermissionToCommand = getMessage("&cYou don't have permission to that command!");
	public static String playerNotOnline = getMessage("&cInvalid player!");
	public static String receivedSaveRod = getMessage(ConfigProperty.MSG_RECEIVED_ROD);
	
	
	
	private static String getMessage(ConfigProperty property) {
		return ChatColor.translateAlternateColorCodes('&', (String) ConfigPropertyMapper.get(property));
	}
	
	private static String getMessage(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	

}
