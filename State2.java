package atomicityChecker;
import java.util.*;


public class State2 {	
	//private static final int countLine = 0;
	HashMap<Integer,Value> C = new HashMap<Integer,Value>(); //tid is int
	HashMap<Integer,Value> L = new HashMap<Integer,Value>();
	// lock map to be coded 
	HashMap<String,Value> U = new HashMap<String,Value>();
	//HashSet<Node> H = new HashSet<Node>();
	HashMap<Integer,LinkedHashSet<Integer>> H = new HashMap<Integer,LinkedHashSet<Integer>>();
	HashMap<ReadKey,Value> R = new HashMap<ReadKey,Value>();
	HashMap<Key,Value> W = new HashMap<Key,Value>();
	HashMap<Integer,Value> F = new HashMap<Integer,Value>();
	HashMap<Integer,Value> P = new HashMap<Integer,Value>();
	
	
}