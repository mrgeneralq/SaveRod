package me.qintinator.saverod.commands;

import me.qintinator.saverod.contracts.IMessageService;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.qintinator.saverod.contracts.ISaverodService;
import me.qintinator.saverod.statics.SaverodMessages;

public class RodCommand implements CommandExecutor {

	private IMessageService messageService;
	private final ISaverodService saverodService;
	public RodCommand(ISaverodService saverodService, IMessageService messageService) {
		this.saverodService = saverodService;
		this.messageService = messageService;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	
		
		if(args.length == 0) {
		// execute only for players
		
			
		if(!(sender instanceof Player))
			return true;
		
		
		Player player = (Player) sender;
				
		if(!player.hasPermission("saverod.rod")) {
			messageService.sendMessage(player, SaverodMessages.noPermissionToCommand);
			return true;
		}

		player.getInventory().addItem(saverodService.getSaveRod());
		messageService.sendMessage(player, SaverodMessages.givenSaveRod);
		return true;
		
		}else{

		if(!sender.hasPermission("saverod.rod.other")) {
			messageService.sendMessage(sender, SaverodMessages.noPermissionToCommand);
			return false;	
		}

				
		if(Bukkit.getServer().getPlayer(args[0]) == null) {
			messageService.sendMessage(sender, SaverodMessages.playerNotOnline);
			return false;
		}
		
			Player target = Bukkit.getServer().getPlayer(args[0]);
			messageService.sendMessage(sender,SaverodMessages.givenSaveRodOther);
			messageService.sendMessage(target,SaverodMessages.receivedSaveRod);
			target.getInventory().addItem(saverodService.getSaveRod());
		}
		
		
		return false;
	}
}
