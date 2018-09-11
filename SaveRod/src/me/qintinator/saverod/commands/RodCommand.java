package me.qintinator.saverod.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.qintinator.saverod.contracts.ISaverodService;
import me.qintinator.saverod.statics.SaverodMessages;

public class RodCommand implements CommandExecutor {
	
	private final ISaverodService saverodService;
	public RodCommand(ISaverodService saverodService) {
		this.saverodService = saverodService;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	
		
		if(args.length == 0) {
		// execute only for players
		
			
		if(!(sender instanceof Player))
			return true;
		
		
		Player player = (Player) sender;
				
		if(!player.hasPermission("saverod.rod")) {
			player.sendMessage(SaverodMessages.noPermissionToCommand);
			return true;
		}
		
		
		player.getInventory().addItem(saverodService.getSaveRod());
		player.sendMessage(SaverodMessages.givenSaveRod);		
		return false;
		
		}else{
		
		
		if(!sender.hasPermission("saverod.rod.other")) {
			sender.sendMessage(SaverodMessages.noPermissionToCommand);
			return false;	
		}

				
		if(Bukkit.getServer().getPlayer(args[0]) == null) {
			sender.sendMessage(SaverodMessages.playerNotOnline);
			return false;
		}
		
			Player target = Bukkit.getServer().getPlayer(args[0]);
			sender.sendMessage(SaverodMessages.givenSaveRodOther);
			target.sendMessage(SaverodMessages.receivedSaveRod);	
			target.getInventory().addItem(saverodService.getSaveRod());

		}
		
		
		return false;
	}
		
		
}
