package atomicityChecker;

public class Edge 
{
	Value source;
	Value dest;
	public Edge(Value s, Value d){
    	this.source = s;
		this.dest = d;
    }
	
	public Edge()
	{
		
	}
	
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += source.hashCode();
		hashcode += dest.hashCode();
		return hashcode;
	}
		     
	public boolean equalsNode(Object k){
		        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.node == this.source.node && kk.dest.node == this.dest.node);
		} 
		else {
			
		    return false;
		}
	}
	public boolean equalsmsg(Object k){
        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.msg == this.source.msg && kk.dest.msg == this.dest.msg);
		} 
		else {
			
		    return false;
		}
	}
	public boolean equalsObj(Object k){
        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.obj.equals(this.source.obj) && kk.dest.obj.equals(this.dest.obj));
		} 
		else {
			
		    return false;
		}
	}
public boolean equalsField(Object k){
        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.field.equals(this.source.field) && kk.dest.field.equals(this.dest.field));
		} 
		else {
			
		    return false;
		}
	}
public boolean equalsAt(Object k){
        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.accessType == this.source.accessType && kk.dest.accessType == this.dest.accessType);
		} 
		else {
			
		    return false;
		}
	}
	
	public boolean equalsLine(Object k){
        
		if (k instanceof Edge) {
			
			Edge kk = (Edge) k;
		    return (kk.source.line == this.source.line && kk.dest.line == this.dest.line);
		} 
		else {
			
		    return false;
		}
	}
		     
	public Value getSource() {
		return source;
	}
	public void setsource(Value obj) {
		this.source = obj;
    }
	public Value getdest() {
		return dest;
	}
	public void setdest(Value fld) {
		this.dest = fld;
    }
	
	public String toString(){
		        return "(Source: "+source.node+","+source.line+","+source.msg+","+source.accessType+","+source.obj +","+source.field +" ->Dest: "+dest.node +"," + dest.line+","+dest.msg+","+dest.accessType +","+dest.obj +","+dest.field +")"; 
	}
}