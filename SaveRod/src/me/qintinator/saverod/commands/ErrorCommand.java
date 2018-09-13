package me.qintinator.saverod.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.qintinator.saverod.contracts.ISaveRodSubCommand;
import net.md_5.bungee.api.ChatColor;

public class ErrorCommand implements ISaveRodSubCommand {

	@Override
	public void execute(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		sender.sendMessage(ChatColor.RED + "Invalid command!");

	}

}
