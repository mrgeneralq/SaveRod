package me.qintinator.saverod.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.qintinator.saverod.contracts.ISaveRodSubCommand;

public class ErrorCommand implements ISaveRodSubCommand {

	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		sender.sendMessage(ChatColor.RED + "Invalid command!");

	}

}
