package me.qintinator.saverod.commands.SaveRodSubCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.qintinator.saverod.Main;
import me.qintinator.saverod.contracts.ISaveRodSubCommand;
import me.qintinator.saverod.statics.SaverodMessages;

public class Reload implements ISaveRodSubCommand{

	
	private final Main main;
	
	public Reload(Main main) {
		this.main = main;
	}
	
	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {


		if(!sender.hasPermission("saverod.reload"))
		{
			sender.sendMessage(SaverodMessages.noPermissionToCommand);
			return;
		}
		
		main.reloadConfig();
		sender.sendMessage(SaverodMessages.configReloaded);	
	}
}
