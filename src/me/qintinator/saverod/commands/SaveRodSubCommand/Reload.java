package me.qintinator.saverod.commands.SaveRodSubCommand;

import me.qintinator.saverod.contracts.IMessageService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.qintinator.saverod.Main;
import me.qintinator.saverod.contracts.ISaveRodSubCommand;
import me.qintinator.saverod.statics.SaverodMessages;

public class Reload implements ISaveRodSubCommand{

	
	private final Main main;
	private final IMessageService messageService;
	
	public Reload(Main main, IMessageService messageService) {
		this.main = main;
		this.messageService = messageService;
	}
	
	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {


		if(!sender.hasPermission("saverod.reload"))
		{
			messageService.sendMessage(sender,SaverodMessages.noPermissionToCommand);
			return;
		}
		
		main.reloadConfig();
		messageService.sendMessage(sender,SaverodMessages.configReloaded);
	}
}
