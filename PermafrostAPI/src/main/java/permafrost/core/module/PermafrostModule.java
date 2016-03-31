package permafrost.core.module;

import org.bukkit.plugin.Plugin;

import permafrost.core.lang.GList;

public class PermafrostModule<P extends Plugin> implements Module
{
	private final String name;
	private final P pl;
	
	public PermafrostModule(P pl)
	{
		this.pl = pl;
		this.name = this.getClass().getSimpleName();
	}
	
	public void onEnable()
	{
		
	}
	
	public void onDisable()
	{
		
	}
	
	public void onTick()
	{
		
	}

	public String getName()
	{
		return name;
	}

	public Plugin getPluginInterface()
	{
		return pl;
	}
	
	public P getPl()
	{
		return pl;
	}
	
	public Interval getInterval()
	{
		return getClass().getDeclaredAnnotation(Interval.class);
	}
	
	public GList<Class<? extends Module>> getDependencies()
	{
		GList<Class<? extends Module>> modules = new GList<Class<? extends Module>>();
		Depend depend = getClass().getDeclaredAnnotation(Depend.class);
		
		if(depend != null)
		{
			for(Class<? extends Module> i : depend.value())
			{
				modules.add(i);
			}
		}
		
		return modules;
	}
}
