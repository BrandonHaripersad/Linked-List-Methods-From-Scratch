
public class IntListMethods {
	
	public static String getAuthorName() {
	    	
	    	return "Brandon Haripersad";
	    }
	    
	public static String getRyersonID() {
	    	
	    	return "500769285";
	   }
	
	public static int removeIfDivisible(int n, int k) {
		
		
        if (n == 0) { 
        
        	return 0; 
        }
        
        int head = n;
        int curr = IntList.getNext(n);
        int prev = n;
        
        while (IntList.getNext(curr) != 0) {
        	
        	if (IntList.getKey(curr) % k == 0) {
        		
        		IntList.setNext(prev, IntList.getNext(curr));
        		IntList.setNext(curr, 0);
        		IntList.release(curr);
        		
        		curr = IntList.getNext(prev);
        	} else {
        		
        		prev = curr;
        		curr = IntList.getNext(prev);
        	}
       }
       
      if (IntList.getKey(curr) % k == 0) {
     	   
     	   IntList.setNext(curr, 0);
     	   IntList.release(curr);
     	   IntList.setNext(prev, 0);
       }
        
       if (IntList.getKey(head) % k == 0) {
    	   
    	   head = IntList.getNext(head);
    	   IntList.setNext(n, 0);
    	   IntList.release(n);
       }
       
       return head;
        
	}
    
    public static int getMiddle(int n) {
		
		if (n == 0) {
			
			return n;
		}
		
		int slow = n;
		int fast = n;
		
		while ((IntList.getNext(fast) != 0) && (IntList.getNext(IntList.getNext(fast)) != 0)) {
			
			slow = IntList.getNext(slow);
			fast = IntList.getNext(IntList.getNext(fast));
		}
		
		return slow;
	}
    
    public static int sort(int n) {
		
		if ((n == 0) || (IntList.getNext(n) == 0)) {
			
			return n;
		}
		
		int mid = IntList.getMiddle(n);
		int left = n;
		int right = IntList.getNext(mid);
		IntList.setNext(mid, 0);
		
		return mergeList(sort(left), sort(right));
	}
    
    public static int mergeList(int a, int b) {
    	
    	int curr;
    	int head;
    	
    	if (IntList.getKey(a) <= IntList.getKey(b)) {
    		
    		head = a;
    		curr = head;
    		a = IntList.getNext(a);
    		IntList.setNext(head, 0);
    	
    	} else {
    		
    		head = b;
    		curr = head;
    		b = IntList.getNext(b);
    		IntList.setNext(head, 0);
    	}
    	
		while ((a != 0) && (b != 0)) {
    		
    		if (IntList.getKey(a) <= IntList.getKey(b)) {
    			
    			IntList.setNext(curr, a);
    			a = IntList.getNext(a);
    			curr = IntList.getNext(curr);
    			
    		} else {
    			
    			IntList.setNext(curr, b);
    			b = IntList.getNext(b);
    			curr = IntList.getNext(curr);
    		}
    	}
    	
    	if (a == 0) {
    		
    		IntList.setNext(curr, b);
    	
    	} else {
    		
    		IntList.setNext(curr, a);
    	}
    	
    	return head;
    }
}
