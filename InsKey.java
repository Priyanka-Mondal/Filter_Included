package atomicityChecker;

public class InsKey {
	int tid;
	int id;
	
	public InsKey()
	{
		
	}
	public InsKey(int tid, int id)
	{
		this.tid = tid;
		this.id =id;
	}
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += tid;
		hashcode += id;
		return hashcode;
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
	public String toString()
	{
		return "(tid:"+tid+" id:"+id+")";
	}

}
