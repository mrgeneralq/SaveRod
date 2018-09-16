package me.qintinator.saverod.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.qintinator.saverod.Main;
import me.qintinator.saverod.commands.SaveRodSubCommand.Reload;
import me.qintinator.saverod.contracts.ISaveRodSubCommand;
import me.qintinator.saverod.statics.SaverodMessages;

public class SaveRodCommand implements CommandExecutor {

	
	private final HashMap<String, ISaveRodSubCommand> subCommands = new HashMap<>();
	private final Main main;
	
	public SaveRodCommand(Main main) {
		this.main = main;
		
		subCommands.put("reload", new Reload(this.main));
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if(args.length == 0) {
			
			if(!sender.hasPermission("saverod.menu")) {
				sender.sendMessage(SaverodMessages.noPermissionToCommand);
				return true;
			}

			return true;
		}
		
		subCommands.getOrDefault(args[0].toLowerCase(),new ErrorCommand()).execute(sender,cmd,commandLabel,args);		
		return false;
	}

}
