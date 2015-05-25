package atomicityChecker;

public class flagKeyLife 
{
	int tid;
	int id;

	public flagKeyLife(int tid, int id){
    	this.tid = tid;
		this.id = id;
		
    }
		
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += tid;
		hashcode += id;
		return hashcode;
	}
		     
	public boolean equals(Object k){
		        
		if (k instanceof flagKeyLife) {
			
			flagKeyLife kk = (flagKeyLife) k;
		    return ((kk.tid == this.tid) && (kk.id == this.id));
		} 
		else {
			
		    return false;
		}
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
    }
	public int getid() {
		return id;
	}
	public void setidd(int id) {
		this.id = id;
    }
	public String toString(){
		        return "Tid: "+tid+"  id: "+id;
	}
		
}