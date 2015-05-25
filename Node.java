package atomicityChecker;

public class Node {
	
		private int source;
		private int dest;
		
			
	    public Node(int s, int d){
	    	this.source = s;
			this.dest = d;
			
	    }
			
		public int hashCode(){
			//System.out.println("In hashcode");
			int hashcode = 0;
			hashcode += source;
			hashcode += dest;
			return hashcode;
		}
			     
		public boolean equals(Object n){
			        
			if (n instanceof Node) {
				
				Node node = (Node) n;
			    return (node.source == this.source && node.dest == this.dest);
			} 
			else {
				
			    return false;
			}
		}
			     
		public int getSource() {
			return source;
		}
		public void setObjectId(int s) {
			this.source = s;
	    }
		public int getDest() {
			return dest;
		}
		public void setDest(int d) {
			this.dest = d;
	    }
		public String toString(){
			        return "SourceNode: "+source+"  DestNode: "+dest;
		}
			
	}
