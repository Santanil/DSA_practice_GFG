//Boundary Traversal of binary tree
//https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21


//TC:O(N)
//SC: O(H) in case of skewed tree H=N [H=height if the tree & N=no. of nodes in the tree]
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res=new ArrayList<>();
	    if(node==null)
	        return res;
	    if(node.left==null && node.right==null){
	        res.add(node.data);    
	    }else if(node.left==null){
	       res.add(node.data);
	       roots(node,res);
	       rightElements(node.right,res);
	    }else if(node.right==null){
	       res.add(node.data);
	       leftElements(node.left,res);
	       roots(node,res);
	    }else{
	        res.add(node.data);
	        leftElements(node.left,res);
	        roots(node,res);
	        rightElements(node.right,res);
	    }
	    return res;
	}
	
	public static void leftElements(Node node,ArrayList<Integer> list){
	    while(node!=null){
	        if(!(node.left==null && node.right==null))
	            list.add(node.data);
            if(node.left!=null)
                node=node.left;
            else
                node=node.right;
	    }
	}
	public static void roots(Node node,ArrayList<Integer> list){
	    if(node==null)
	        return;
	    if(node.left==null && node.right==null)
	        list.add(node.data);
	    roots(node.left,list);
	    roots(node.right,list);
	}
	public static void rightElements(Node node,ArrayList<Integer> list){
	    ArrayList<Integer> tmp = new ArrayList<Integer>();
	    while(node!=null){
	        if(!(node.left==null && node.right==null))
                tmp.add(node.data);  
            if(node.right!=null)
                node=node.right;
            else
                node=node.left;
	    }
	    for (int i = tmp.size()-1; i >= 0; i--) {
            list.add(tmp.get(i));
        }
	}
	
}



