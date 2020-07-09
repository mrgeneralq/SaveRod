package me.qintinator.saverod.commands;

import java.util.HashMap;

import me.qintinator.saverod.contracts.IMessageService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.qintinator.saverod.Main;
import me.qintinator.saverod.commands.SaveRodSubCommand.Reload;
import me.qintinator.saverod.contracts.ISaveRodSubCommand;
import me.qintinator.saverod.statics.SaverodMessages;

public class SaveRodCommand implements CommandExecutor {

	private IMessageService messageService;
	private final HashMap<String, ISaveRodSubCommand> subCommands = new HashMap<>();
	private final Main main;
	
	public SaveRodCommand(Main main, IMessageService messageService) {
		this.main = main;
		this.messageService = messageService;

		subCommands.put("reload", new Reload(this.main, messageService));
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(args.length == 0) {
			
			if(!sender.hasPermission("saverod.menu")) {
				messageService.sendMessage(sender, SaverodMessages.noPermissionToCommand);
				return true;
			}
			return true;
		}
		
		subCommands.getOrDefault(args[0].toLowerCase(),new ErrorCommand()).execute(sender,cmd,commandLabel,args);		
		return false;
	}

}
