package me.qintinator.saverod.contracts;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ISaveRodSubCommand {

	
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args);
	
	
}
