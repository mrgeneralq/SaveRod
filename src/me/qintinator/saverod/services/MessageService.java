package me.qintinator.saverod.services;

import me.qintinator.saverod.contracts.IMessageService;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageService implements IMessageService {
    @Override
    public void sendMessage(CommandSender sender, String message) {
        if(message.length() == 0)
            return;

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
