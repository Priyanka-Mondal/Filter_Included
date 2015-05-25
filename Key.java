package atomicityChecker;

public class Key {
	private String objectId;
	private String fieldId;
	
		
    public Key(String obj, String fld){
    	this.objectId = obj;
		this.fieldId = fld;
		
    }
		
	public int hashCode(){
		//System.out.println("In hashcode");
		int hashcode = 0;
		hashcode += objectId.hashCode();
		hashcode += fieldId.hashCode();
		return hashcode;
	}
		     
	public boolean equals(Object k){
		        
		if (k instanceof Key) {
			
			Key kk = (Key) k;
		    return (kk.objectId.equals(this.objectId) && kk.fieldId.equals(this.fieldId));
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
	public String toString(){
		        return "ObjectId: "+objectId+"  FieldId: "+fieldId;
	}
		
}
