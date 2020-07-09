package me.qintinator.saverod;
import me.qintinator.saverod.bstats.Metrics;
import me.qintinator.saverod.contracts.IMessageService;
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

		Metrics metrics = new Metrics(this);

		saveDefaultConfig();
		Bootstrapper bootstrapper = Bootstrapper.getBootstrapper();
		bootstrapper.run();

		IMessageService messageService = bootstrapper.getMessageService();

		// running the property mapper
		ConfigPropertyMapper.run(this);
		
		// loading the commands
		Bukkit.getPluginCommand("rod").setExecutor(new RodCommand(bootstrapper.getSaverodService(), messageService));
		Bukkit.getPluginCommand("saverod").setExecutor(new SaveRodCommand(this, messageService));
		
		// loading all events
		Bukkit.getPluginManager().registerEvents(new OnPlayerDeath(bootstrapper.getSaverodService(), bootstrapper.getConfigPropertyService()), this);
	}	
}
