package permafrost.core.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;

public class Format
{
	private static NumberFormat NF;
	private static DecimalFormat DF;
	
	private static void instantiate()
	{
		if(NF == null)
		{
			NF = NumberFormat.getInstance();
		}
	}
	
	public static String cname(String clazz)
	{
		String codeName = "";
		
		for(Character i : clazz.toCharArray())
		{
			if(Character.isUpperCase(i))
			{
				codeName = codeName + "-" + Character.toLowerCase(i);
			}
			
			else
			{
				codeName = codeName + i;
			}
		}
		
		if(codeName.startsWith("-"))
		{
			codeName = codeName.substring(1);
		}
		
		return codeName;
	}
	
	public static String mem(long mb)
	{
		if(mb < 1024)
		{
			return f(mb) + " MB";
		}
		
		else
		{
			return f(((double)mb / (double)1024), 1) + " GB";
		}
	}
	
	public static String f(long i)
	{
		instantiate();
		return NF.format(i);
	}
	
	public static String f(int i)
	{
		instantiate();
		return NF.format(i);
	}
	
	public static String f(double i, int p)
	{
		String form = "#";
		
		if(p > 0)
		{
			
			form = form + "." + StringUtils.repeat('#', p);
		}
		
		DF = new DecimalFormat(form);
		
		return DF.format(i);
	}
	
	public static String fd(double i, int p)
	{
		String form = "0";
		
		if(p > 0)
		{
			form = form + "." + StringUtils.repeat('0', p);
		}
		
		DF = new DecimalFormat(form);
		
		return DF.format(i);
	}
	
	public static String f(float i, int p)
	{
		String form = "#";
		
		if(p > 0)
		{
			form = form + "." + StringUtils.repeat('#', p);
		}
		
		DF = new DecimalFormat(form);
		
		return DF.format(i);
	}
	
	public static String f(double i)
	{
		return f(i, 1);
	}
	
	public static String f(float i)
	{
		return f(i, 1);
	}
	
	public static String pc(double i, int p)
	{
		return f(i * 100.0, p) + "%";
	}
	
	public static String pc(float i, int p)
	{
		return f(i * 100, p) + "%";
	}
	
	public static String pc(double i)
	{
		return f(i * 100, 0) + "%";
	}
	
	public static String pc(float i)
	{
		return f(i * 100, 0) + "%";
	}
	
	public static String pc(int i, int of, int p)
	{
		return f(100.0 * (((double)i) / ((double)of)), p) + "%";
	}
	
	public static String pc(int i, int of)
	{
		return pc(i, of, 0);
	}
	
	public static String pc(long i, long of, int p)
	{
		return f(100.0 * (((double)i) / ((double)of)), p) + "%";
	}
	
	public static String pc(long i, long of)
	{
		return pc(i, of, 0);
	}
}
