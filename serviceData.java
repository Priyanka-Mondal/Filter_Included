package atomicityChecker;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class serviceData 
{
	String component = null;
	String state = null;
	int createService = -1;
	int bindService = -1;
	int service_args = -1;
	int service_connect = -1;
	//int id;
	LinkedHashSet<Integer> nodeIdList = new LinkedHashSet<Integer>();
	
	
	public serviceData()
	{
	}
	public serviceData(String com , String st, int f, int s, int t , int sc, LinkedHashSet<Integer> temp)
	{
		this.component = com;
		this.state = st;
		this.createService =f;
		this.bindService = s;
		this.service_args = t;
		this.service_connect = sc;
		this.nodeIdList = temp;
		//this.id = id;
	}
}