package util;

import java.util.HashMap;

public class GeradorIDs 
{
	private static HashMap<Integer,Integer> mapID;
	private static int maxID;
	public static int gerador()
	{
		if(mapID == null)
		{
			mapID = new HashMap<Integer,Integer>();
		}
	     if(mapID.isEmpty())
	     {
	    	 maxID = maxID + 1;
	    	 mapID.put(maxID, maxID);
		     return maxID;
	     }
	     maxID = maxID + 1;
	     if(mapID.containsKey(maxID))
	     {
	    	 gerador();
	     }
	     return maxID;
	}
}
