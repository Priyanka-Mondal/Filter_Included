package atomicityChecker;

public class Value {
	
	int node = 0;
	int line = 0;
	int msg = 0; // added for filtering
	int accessType = 0; // added for filtering **READ = 1 **WRITE = 2 **UNLOCK = 3 **LOCK = 4 **POST = 5 **CALL = 6
	String obj = "dummy";
	String field = "dummy";
	public Value(int node, int line, int msg, int accessType, String obj , String field)
	{
    	this.node = node;
		this.line = line;
		this.msg = msg;
		this.accessType = accessType;
		this.obj = obj;
		this.obj = obj;
		this.field = field;
    }
	
	public Value()
	{
		
	}
	
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += node+line+msg+accessType;
		return hashcode;
	}
		     
	public boolean equalsValue(Object k){
		        
		if (k instanceof Value) {
			
			Value kk = (Value) k;
		    return (kk.node == this.node && kk.line == this.line && kk.msg == this.msg && kk.accessType == this.accessType && kk.obj.equals(this.obj) && kk.field.equals(this.field));
		} 
		else {
			
		    return false;
		}
	}
	public int getNode() {
		return this.node;
	}
	public void setNode(int node) {
		this.node = node;
    }
	public int getLine() {
		return this.line;
	}
	public void setLine(int node) {
		this.line = node;
    }
	public int getmsg() {
		return this.msg;
	}
	public void setmsg(int node) {
		this.msg = node;
    }
	public int getat() {
		return this.accessType;
	}
	public void setat(int node) {
		this.accessType = node;
    }
	public String toString(){
		        return node+" "+line+" "+msg+" "+accessType; 
	}
}