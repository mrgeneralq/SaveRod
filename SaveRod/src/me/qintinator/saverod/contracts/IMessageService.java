package me.qintinator.saverod.contracts;

import org.bukkit.command.CommandSender;

public interface IMessageService {

    void sendMessage(CommandSender sender, String message);

}
