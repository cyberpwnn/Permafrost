package permafrost.core.module;

import org.bukkit.plugin.Plugin;

import permafrost.core.lang.GList;

public interface Module
{
	String getName();
	Plugin getPluginInterface();
	void onEnable();
	void onDisable();
	void onTick();
	Interval getInterval();
	GList<Class<? extends Module>> getDependencies();
}
