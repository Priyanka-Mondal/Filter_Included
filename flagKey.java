package atomicityChecker;

public class flagKey {
	
	int tid;
	int treeRootid;

	public flagKey(int tid, int root){
    	this.tid = tid;
		this.treeRootid = root;
		
    }
		
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += tid;
		hashcode += treeRootid;
		return hashcode;
	}
		     
	public boolean equals(Object k){
		        
		if (k instanceof flagKey) {
			
			flagKey kk = (flagKey) k;
		    return ((kk.tid == this.tid) && (kk.treeRootid == this.treeRootid));
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
	public int getTreeRootId() {
		return treeRootid;
	}
	public void setTreeRootId(int root) {
		this.treeRootid = root;
    }
	public String toString(){
		        return "Tid: "+tid+"  Root: "+treeRootid;
	}
		
}
