package com.araeosia.Transit;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Transit extends JavaPlugin {

	static final Logger log = Logger.getLogger("Minecraft");
	public boolean debug=false;
	
	/**
	 * 
	 */
	@Override
	public void onEnable(){
		loadConfiguration();
		this.debug("[AraeosiaTransit] Debug mode enabled!");
		log.info("AraeosiaTransit Enabled!");
		this.getServer().getPluginManager().registerEvents(new TransitEventListener(this), this);
	}
	
	/**
	 * 
	 */
	@Override
	public void onDisable(){
		log.info("[AraeosiaTransit] Good night.");
	}
	
	/**
	 * 
	 */
	@Override
	public boolean onCommand(CommandSender sender,  Command cmd, String commandLabel, String[] args){
		if (cmd.getName().equalsIgnoreCase("TRANSIT")){
			// Admin commands only.
		}
		return false;	
	}
	
	/**
	 * 
	 */
	public void loadConfiguration(){
		boolean configIsCurrentVersion = getConfig().getDouble("AraeosiaTransit.technical.version")==0.1;
		if(!configIsCurrentVersion){
			getConfig().set("AraeosiaTransit.technical.debug", false);
			getConfig().set("AraeosiaTransit.technical.version", 0.1);
			saveConfig();
		}
		debug = getConfig().getBoolean("AraeosiaTransit.technical.debug");
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void debug(String msg) {
		if(debug){
			log.info( "[AraeosiaTransit]:" + msg);
		}	
	}
	
	/**
	 * 
	 * @param msg
	 * @return
	 */
	public String playerMsg(String msg){
		return ChatColor.GOLD + "[AraeosiaTransit]: " + ChatColor.YELLOW + msg;
	}
}
