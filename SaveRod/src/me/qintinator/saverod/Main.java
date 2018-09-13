package me.qintinator.saverod;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.qintinator.saverod.commands.RodCommand;
import me.qintinator.saverod.commands.SaveRodCommand;
import me.qintinator.saverod.eventlisteners.OnPlayerDeath;
import me.qintinator.saverod.statics.Bootstrapper;
import me.qintinator.saverod.statics.ConfigPropertyMapper;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
			
		saveDefaultConfig();
		
		// running the bootstrapper
		Bootstrapper.run();
				
		// running the property mapper
		ConfigPropertyMapper.run(this);
		
		// loading the commands
		Bukkit.getPluginCommand("rod").setExecutor(new RodCommand(Bootstrapper.getSaverodService()));
		Bukkit.getPluginCommand("saverod").setExecutor(new SaveRodCommand(this));
		
		// loading all events
		Bukkit.getPluginManager().registerEvents(new OnPlayerDeath(Bootstrapper.getSaverodService(), Bootstrapper.getConfigPropertyService()), this);
	}	
}
