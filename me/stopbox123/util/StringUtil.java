package me.stopbox123.util;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class StringUtil {

	 private static Random r;

	    public static Random r() {
	        if (r == null) {
	            r = new Random();
	        }
	        return r;
	    }

	    public static boolean isInt(String string) {
	        try {
	            Integer.parseInt(string);
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	        return true;
	    }

	    public static String capitalise(String s) {
	        String finalString = "";
	        if (s.contains(" ")) {
	            StringBuilder builder = new StringBuilder();
	            String[] sp = s.split(" ");
	            for (String string : sp) {
	                string = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	                builder.append(string);
	                builder.append(" ");
	            }
	            builder.deleteCharAt(builder.length() - 1);
	            finalString = builder.toString();
	        } else {
	            finalString = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	        }
	        return finalString;
	    }

	    public static String combineSplit(int startIndex, String[] string, String separator) {
	        if (string == null) {
	            return "";
	        } else {
	            StringBuilder builder = new StringBuilder();
	            for (int i = startIndex; i < string.length; i++) {
	                builder.append(string[i]);
	                builder.append(separator);
	            }
	            builder.deleteCharAt(builder.length() - separator.length());
	            return builder.toString();
	        }
	    }
	
	    public static Location parseStringToLocation(String world, String x, String y, String z) {
			World w = Bukkit.getWorld(world);
			double x1 = Double.valueOf(x);
			double y1 = Double.valueOf(y);
			double z1 = Double.valueOf(z);
	    	return new Location(w, x1, y1, z1);
	    }
}
