import java.util.*;

public class Main {
    
    public static void findMinPath(int[] arr, int n){
        int[] steps = new int[n];
        int[] parent = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+arr[j] >= i){          // checking if in range
                    int min = steps[j]+1;   // if in range then steps req. --> (steps to current position_j + 1 step)
                    if(steps[i]>min){       // if we already have lesser step  --> skip otherwise update steps[] and parent[]
                        steps[i] = min;
                        parent[i] = j;
                    }
                }
            }
        }
        System.out.println("min steps: "+steps[n-1]);   // printing min steps to end
        
        // printing path
        int i = n-1;
        StringBuilder sb= new StringBuilder();
        sb.append(i+">--");
        while(i!=0){                                   // reverse tracking parents to get the path
            sb.append(parent[i]+">--");
            i = parent[i];
        }
        System.out.println("path: "+sb.reverse());     // printing path
    }
    
    public static void main(String[] args) throws Exception {
        int arr[] = {1,2,1,4,3,5};
        findMinPath(arr, arr.length);
    }
}



/*
OUTPUT  -- 

min steps: 3
path: -->0-->1-->3-->5

*/
