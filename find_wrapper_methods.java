package atomicityChecker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class find_wrapper_methods 
{
	int countLine;
	int again;
	HashMap<Integer, Integer> prevM =new HashMap<Integer, Integer>();
	HashMap<Integer, Pair> Tree = new HashMap<Integer, Pair>();
	ArrayList<Integer> ls = new ArrayList<Integer>();
	String tid = null;
	String src = null;
	public  void phaseTree(String concat) throws IOException
	  {
		BufferedReader br = new BufferedReader(new FileReader(concat));
		  String line;
		  int flag = 0;	
		  countLine =0;
		  try 
		  {
			  line = br.readLine();
			  flag =0;
			  while (line != null)
			  {
				  //System.out.println(line);
				  flag=0;
				  countLine++;
				  if (line.contains("RET") )
				  {
					  String p=line.substring((line.indexOf("msg")),(line.length()));
					  p = p.substring(4);
					  int p1 = Integer.valueOf(p);
					  String t = line.substring(line.indexOf("tid"), line.indexOf("msg")-1);
					  t = t.substring(4);
					  int t1 = Integer.valueOf(t);
					  if (p1 == (prevM.get(t1)))
					  {
						  prevM.put(t1,-1);
					  }
					  Pair pair = Tree.get(p1);
					  if (pair.tree != -1)
					  {
						  int d = pair.depth;
					  }
				  }
				  if (line.contains("POST"))
				  {
					  Pair pair = new Pair();
					  String p = line.substring((line.indexOf("msg")),(line.indexOf("dest")-1));
					  p = p.substring(4);
					  int p1 = Integer.valueOf(p);
					  String t = line.substring(line.indexOf("src"), line.indexOf("msg")-1);
					  t = t.substring(4);
					  int t1 = Integer.valueOf(t);
					  String delay = line.substring(line.indexOf("delay")+6, line.length());
					  int Delay = Integer.valueOf(delay);
					  pair.source = t1;
					  if (Delay == 0)
					  {
						  if(prevM.containsKey(t1) && prevM.get(t1)!=-1)
							  pair.parent=prevM.get(t1);
						  else
		        			pair.parent=0;
					  }
					  else
					  {
						  pair.parent=0;
					  }
					  Tree.put(p1, pair);
				  }
				  else if(line.contains(" CALL "))
				  {
					  String dep = null;
					  int D=-1;
					  String p=line.substring((line.indexOf("msg")),(line.length()));
					  p = p.substring(4);
					  int p1 = Integer.valueOf(p);
					  String t = line.substring(line.indexOf("tid"), line.indexOf("msg")-1);
					  t = t.substring(4);
					  int t1 = Integer.valueOf(t);	        			
					  Pair pair=new Pair();
					  Pair pair2 = new Pair();
					  if(/*line.contains("beginAtomic") &&*/ !Tree.containsKey(p1))
					  {
						  pair.tree=p1; //t1
						  dep = line.substring(line.indexOf("Depth")+6, line.length());
						  D =Integer.valueOf(dep);
						  pair.depth=D;
					  }
					  if(Tree.containsKey(p1))
					  {
						  pair=Tree.get(p1);
						  pair.target=t1;
		        			
						  if(pair.source!=t1) // what if the tid is two dig
						  {
							  pair.parent=0;
							  pair.tree=p1;
						  }
						  else if(pair.source==t1)
						  {
							  pair2=Tree.get(pair.parent);
							  if(!line.contains("beginAtomic"))
							  {
								  if(pair.parent!=0)
								  {
									  pair2=Tree.get(pair.parent);
									  pair.depth=pair2.depth-1;
									  pair.tree = pair2.tree;
								  }
								  else
								  {
									  pair.tree=p1;
								  }
							  }
						  }
						  Tree.put(p1, pair); ////CHECK 1
					  }
					  else 
					  {
						  pair.source=-1;
						  pair.target=p1;
						  pair.parent=0;
						  pair.depth=D;
						  Tree.put(p1, pair); //// CHECK 2
					  }
					  Tree.put(p1, pair);  ///// CHECK 3
					  prevM.put(t1, p1);
				  }
				  
				  line=br.readLine();
			  }
	          printMap(concat);   
	          System.out.println();
	          System.out.println();
		  }
		  catch (IOException e) 
		  {
			  e.printStackTrace();
		  } finally 
		  {
			  br.close();
		  }
	  }
	public void printMap(String args0 ) throws IOException
	  {
		  Set<Integer> keys = Tree.keySet();
		  for(Integer kk:keys)
		  {
			  System.out.println(kk+"==> Source:"+Tree.get(kk).source+"  target:"+Tree.get(kk).target+"  Parent:"+Tree.get(kk).parent+"  Depth:"+Tree.get(kk).depth+"  Tree of:"+Tree.get(kk).tree);
			 // treeFile.write(kk+"==> Source:"+Tree.get(kk).source+"  target:"+Tree.get(kk).target+"  Parent:"+Tree.get(kk).parent+"  Depth:"+Tree.get(kk).depth+"  Tree of:"+Tree.get(kk).tree+"\n");
		  }
	  }
	public int function(String args0 , String args1, String args2) throws IOException
	{
		//String output = args0.substring(0, args0.indexOf("abc_log.txt"));
		//output = output+args1;
		
		BufferedReader br = new BufferedReader(new FileReader(args0));
		BufferedReader br2 = new BufferedReader(new FileReader(args0));
		//BufferedWriter brw = new BufferedWriter(new FileWriter(output));
		int lineNumber = 0;
		int accessLine = Integer.valueOf(args2);
		System.out.println(accessLine);
		HashMap<String,ArrayList<Integer>> methods = new HashMap<String,ArrayList<Integer>>();
		HashMap<Integer,Integer> msgs = new HashMap<Integer,Integer>();
		//Stack<String> stack_method = new Stack<String>();
		//Stack<Integer> stack_line = new Stack<Integer>();
		String line = br.readLine();
		String match;
		int count = 1;
		while(line!=null)
		{
			if(line.contains("METHOD ENTRY")  /*&& count < accessLine*/)
			{
				match = line.substring(line.indexOf("tid:"),line.length());
				match = "METHOD EXIT "+match;
				ArrayList<Integer> hs = new ArrayList<Integer>();
				if(methods.containsKey(match))
					hs = methods.get(match);
				hs.add(count);
				ArrayList<Integer> hs2 = new ArrayList<Integer>();
				Collections.sort(hs);
				methods.put(match, hs);
			}
			else if(line.contains("METHOD EXIT")   && methods.containsKey(line))
			{
				ArrayList<Integer> hs = new ArrayList<Integer>();
				if(count > accessLine  && methods.get(line).size()>0)
				{
					hs = methods.get(line);
					int add = hs.get(hs.size()-1);
					int r = hs.size()-1;
					if(add<accessLine)
					{
						ls.add(add);
						hs.remove(r);
						ls.add(count);
						if(hs.size()>=1)
							methods.put(line, hs);
						else
							methods.remove(line);
					}
					else if(add > accessLine)
					{
						hs.remove(r);
						if(hs.size()>=1)
							methods.put(line, hs);
						else
							methods.remove(line);
					}
				}
				else if(count < accessLine && methods.get(line).size()>0)
				{
					hs = methods.get(line);
					//System.out.println(line+" "+hs);
					//int rem = hs.get(hs.size()-1);
					int r = hs.size()-1;
					hs.remove(r);
				}
			}
			else if(line.contains("CALL") && count < accessLine)
			{
				int taskid = Integer.valueOf(line.substring(line.indexOf("msg:")+4));
				msgs.put(taskid,count);
			}
			else if(line.contains("RET") && count > accessLine && line.contains(tid))
			{
				int taskid = Integer.valueOf(line.substring(line.indexOf("msg:")+4));
				if(msgs.containsKey(taskid))
				{
					ls.add(msgs.get(taskid));
					ls.add(count);
					if(Tree.get(taskid).parent!=0)
					{
						again =taskid;
					}
					else
					{
						again =0;
					}
				}
			}
			if(count == accessLine)
			{
				String temp = line.substring(line.indexOf("tid:"));
				tid = temp.substring(temp.indexOf("tid:"),temp.indexOf(" "));
				src = temp.substring(temp.indexOf("tid:")+4,temp.indexOf(" "));
				tid = tid+" ";
				src = "src:"+src;
				//System.out.println("----------"+src+" "+temp);
				ls.add(count);
			}
			
			line = br.readLine();
			count++;
		}
		
		Collections.sort(ls);
		int i =0;
		while(ls.get(i) != accessLine)
		{
			i++;
		}
		int ent = ls.get(i-1);
		int ex = ls.get(i+1);
		System.out.println("ls: "+ls.toString());
		//System.out.println(ent+" "+ex);
		line = br2.readLine();
		lineNumber++;
		while(line!=null && lineNumber < ex)
		{
			if(lineNumber > ent && lineNumber < ex && line.contains("rwId"))
			{
				ls.add(lineNumber);
			}
			line = br2.readLine();
			lineNumber++;
		}
		//brw.close();
		br.close();
		br2.close();
		return again;
	}
	
	
	public void post_func1(String args0,int args2) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(args0));
		int accessLine = args2;
		System.out.println(accessLine);
		HashMap<String,ArrayList<Integer>> methods = new HashMap<String,ArrayList<Integer>>();
		HashMap<Integer,Integer> msgs = new HashMap<Integer,Integer>();
		//Stack<String> stack_method = new Stack<String>();
		//Stack<Integer> stack_line = new Stack<Integer>();
		String line = br.readLine();
		String match;
		int count = 1;
		while(line!=null)
		{
			if(line.contains("METHOD ENTRY")  /*&& count < accessLine*/)
			{
				match = line.substring(line.indexOf("tid:"),line.length());
				match = "METHOD EXIT "+match;
				ArrayList<Integer> hs = new ArrayList<Integer>();
				if(methods.containsKey(match))
					hs = methods.get(match);
				hs.add(count);
				Collections.sort(hs);
				methods.put(match, hs);
			}
			else if(line.contains("METHOD EXIT")   && methods.containsKey(line))
			{
				ArrayList<Integer> hs = new ArrayList<Integer>();
				if(count > accessLine  && methods.get(line).size()>0)
				{
					hs = methods.get(line);
					int add = hs.get(hs.size()-1);
					int r = hs.size()-1;
					if(add<accessLine)
					{
						ls.add(add);
						hs.remove(r);
						ls.add(count);
						if(hs.size()>=1)
							methods.put(line, hs);
						else
							methods.remove(line);
					}
					else if(add > accessLine)
					{
						hs.remove(r);
						if(hs.size()>=1)
							methods.put(line, hs);
						else
							methods.remove(line);
					}
				}
				else if(count < accessLine && methods.get(line).size()>0)
				{
					hs = methods.get(line);
					//System.out.println(line+" "+hs);
					//int rem = hs.get(hs.size()-1);
					int r = hs.size()-1;
					hs.remove(r);
				}
			}
			else if(line.contains("CALL") && count < accessLine)
			{
				int taskid = Integer.valueOf(line.substring(line.indexOf("msg:")+4));
				msgs.put(taskid,count);
			}
			else if(line.contains("RET") && count > accessLine )
			{
				int taskid = Integer.valueOf(line.substring(line.indexOf("msg:")+4));
				
				if(msgs.containsKey(taskid))
				{
					ls.add(msgs.get(taskid));
					ls.add(count);
					if(Tree.get(taskid).parent!=0)
					{
						again =taskid;
					}
					else
					{
						again =0;
					}
				}
			}
			if(count == accessLine)
			{
				ls.add(count);
				//System.out.println(count+" The post::"+line);
			}
			line = br.readLine();
			count++;
		}
		br.close();
	}
	public void post_func0(String args0 , int taskid) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(args0));
		String line = br.readLine();
		int flag = 0;
		String msg = "msg:";
		String ti = String.valueOf(taskid);
		msg = msg+ti;
		int cl =1;
		while(line != null && flag == 0)
		{
			if(line.contains("POST") && line.contains(msg))
			{
				flag = cl;
				ls.add(cl);
				
			}
			line = br.readLine();
			cl++;
		}
		post_func1(args0,flag);
	}
	public void printls(String args0, String args1) throws IOException
	{
		String output = args0.substring(0, args0.indexOf("abc_log.txt"));
		output = output+args1;
		BufferedReader br = new BufferedReader(new FileReader(args0));
		BufferedWriter brw = new BufferedWriter(new FileWriter(output));
		int lineNumber = 0;
		String line = br.readLine();
		lineNumber++;
		while(line!=null)
		{
			if(ls.contains(lineNumber) && (line.contains(tid) || line.contains(src)))
			{
				String ln = String.valueOf(lineNumber);
				brw.write(ln+" "+line+"\n");
			}
			line = br.readLine();
			lineNumber++;
		}
		brw.close();
		br.close();
	}
	
	public static void main(String args[]) throws IOException
	{
		find_wrapper_methods fwm = new find_wrapper_methods();
		fwm.phaseTree(args[0]);
		int ret = fwm.function(args[0] , args[1] , args[2]);
		while(fwm.again != 0)
		{
			fwm.post_func0(args[0],fwm.again);
		}
		fwm.printls(args[0],args[1]);
	}
}