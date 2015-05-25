package atomicityChecker;

public class ReadKey {
	private String objectId;
	private String fieldId;
	private int tId;
	private int treeRoot;
	
		
    public ReadKey(String obj, String fld, int t, int tr){
    	this.objectId = obj;
		this.fieldId = fld;
		this.tId = t;
		this.treeRoot = tr;
		
		
    }
		
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += objectId.hashCode();
		hashcode += fieldId.hashCode();
		hashcode += tId;
		hashcode += treeRoot;
		return hashcode;
	}
		     
	public boolean equals(Object k){
		        
		if (k instanceof ReadKey) {
			
			ReadKey kk = (ReadKey) k;
		    return (kk.objectId.equals(this.objectId) && kk.fieldId.equals(this.fieldId) && kk.tId == this.tId && kk.treeRoot == this.treeRoot);
		} 
		else {
			
		    return false;
		}
	}
		     
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String obj) {
		this.objectId = obj;
    }
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fld) {
		this.fieldId = fld;
    }
	public int gettId() {
		return tId;
	}
	public void settId(int t) {
		this.tId = t;
    }
	public int getTreeRoot()
	{
		return treeRoot;
	}
	public void setTreeRoot(int tree)
	{
		this.treeRoot = tree;
	}
	public String toString(){
		        return "ObjectId: "+objectId+"  FieldId: "+fieldId+" Tid: "+tId +"treeRoot:" + treeRoot ; 
	}
		
}