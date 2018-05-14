import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {

/* PRETTY-PRINT method - Checkpoint 2 */

 public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        
        ArrayList<ArrayList<Integer>> retArray = new ArrayList<ArrayList<Integer>>();
        int n = A;
        
        if (n == 1) {
            ArrayList<Integer> one = new ArrayList<>();
            one.add(1);
            retArray.add(one);
            
            return retArray;
        }
		int x = 2*n-1;
		int y=2*n;
		int j = 0;
		int u = x-1;
		int v = x-1;
		int myArray[][] = new int[x][x];
		
		for(int i=0;i<=x-2;i++) {
		y=y-1;
		v=u;
		for (j=i; j<y; j++) {	
						if (i==j){ 
							myArray[i][j]=n;
							myArray[u][v]=n;
						}
				        else {
				         myArray[i][j]=n;
						 myArray[j][i]=n;
						 myArray[u][v]=n;
						 myArray[v][u]=n;
				        }
						v--;
		  }
		n=n-1;
		u--;
		}
		
	 for(int r = 0; r < x; r++)
		   {
		    List<Integer> list = new ArrayList<Integer>(myArray[r].length);
            list= (Arrays.stream(myArray[r]).boxed().collect(Collectors.toList()));
            retArray.add((ArrayList<Integer>)list);
		   }
	
		
      return retArray;  
    }
    
    /* Numrange - Checkpoint 3 */
    
        public int numRange(ArrayList<Integer> A, int B, int C) {
        Integer[] A1 = A.toArray(new Integer[A.size()]);
        int seqCounter=0;
    for (int i=0; i<= A1.length-1;i++) {
        if (A1[i] <= C) {
            int j = i + 1;
            int sum =A1[i];
            if (sum >= B) {seqCounter ++;}
            while (j < A1.length ) {

                if (A1[j] <= C) {
                    sum+=A1[j];

                    if (sum <= C) {
                        if (sum >=B) seqCounter++;
                    }
                    else {
                     //break out
                        break;
                    }
                }
                else{
                    break;
                }
                j++;
            }
    }
    }    
    return seqCounter;
    }
    
    /* SUBTRACT - LinkedLists - Checkpoint 4 */
     class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) { val = x; next = null; }
    }
    
    public ListNode subtract(ListNode A) {
        
        if (A.next!=null){
        int count = 1;
            ListNode h = A;
            while (h.next != null){
                h= h.next;
                count++;
            }

            ListNode m = A;
            ListNode n = A;
            int mid;

            if (count %2 ==0) mid =count /2;
            else mid = count/2 + 1;

            for (int j=0;j<mid;j++){
                n=n.next;
            }

            Stack st = new Stack();
            while (n!=null && n.next != null) {
                st.push(n.val);
                n=n.next;
            }
            st.push(n.val);

            for (int i=0;i<count/2;i++){
                m.val = ((int)st.pop()-m.val);
                m=m.next;
                //if (n.next != null)
                //n=n.next;
            }
        }
        return A;
    }
    
    /* LongestSequence - Checkpoint 5 */
    
    public int longestConsecutive(final List<Integer> A) {
        
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : A) {
            num_set.add(num);
        }

        int longestSeq = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentSeq = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentSeq += 1;
                }

                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }

    return longestSeq;
    }
 }
