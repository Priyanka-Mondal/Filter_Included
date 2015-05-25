package atomicityChecker;

public class LifeValues {
	
	int tid = 0;
	int id = 0;
	String component = null;
	String state = null;
	
	public LifeValues()
	{
		
	}
	
	public LifeValues(int tid, int id, String component, String state)
	{
		this.tid = tid;
		this.id = id;
		this.component = component;
		this.state = state;
	}
	
	public int hashCode()
	{
		int hashcode = 0;
		hashcode += component.hashCode();
		hashcode += state.hashCode();
		return hashcode;
	}
		     
	public boolean equalsNode(Object k){
		        
		if (k instanceof LifeValues) {
			
			LifeValues kk = (LifeValues) k;
		    return (kk.tid == this.tid && kk.id == this.id && kk.component.equals(this.component) && kk.state.equals(this.state) );
		} 
		else {
			
		    return false;
		}
	}
	public int getTid() 
	{
		return tid;
	}
	public void setTid(int tid) 
	{
		this.tid = tid;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
    }
	public String getComponent() 
	{
		return component;
	}
	public void setComponent(String component) 
	{
		this.component = component;
    }
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
    }
	
	public String toString()
	{
		return "tid:"+tid+" id:"+id+" component:"+component+" state:"+state;
	}
	
/*	public int getnode()
	{
		return node;
	}
	public void setnode(int node)
	{
		this.node = node;
	}*/
	
	
}
