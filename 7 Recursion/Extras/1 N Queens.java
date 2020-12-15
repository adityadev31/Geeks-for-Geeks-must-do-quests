class NQueens{
    
    private final int N;
    private char[][] mat;
    
    /* ============ CONSTRUCTOR ================== */ 
    NQueens(int n){
        N = n;
        mat = new char[N][N];
        initMat();
        fillMat(0);
    }
    
    /* ============ INIT MATRIX ================== */
    void initMat(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) mat[i][j] = '-';
        }
    }
    
    /* ============ SAFE ========================= */
    boolean safe(int r, int c){
        
        for(int i=0; i<r; i++){                        // checking col
            if(mat[i][c] == 'Q') return false;
        }
        
        for(int i=r-1, j=c+1; i>=0 && j<N; i--, j++){  // checking diagonal '/'
            if(mat[i][j] == 'Q') return false;
        }
        
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){ // checking diagonal '\'
            if(mat[i][j] == 'Q') return false;
        }
        return true;
    }
    
    /* ============ FILL MATRIX ================== */
    void fillMat(int r){
        if(r == N){      // stopping case
            printMat();
            return;
        }
        for(int c=0; c<N; c++){
            if(safe(r, c)){
                mat[r][c] = 'Q';
                fillMat(r+1);
                mat[r][c] = '-';
            }
        }
    }
    
    /* ============ PRINTING MATRIX ============== */
    void printMat(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) System.out.print(mat[i][j]+" ");
            System.out.println();
        }
        System.out.println();
    }
}

public class Main{
    
    public static void main(String[] args){
        NQueens ob = new NQueens(5);
    }
}


/*

- Q - - 
- - - Q 
Q - - - 
- - Q - 

- - Q - 
Q - - - 
- - - Q 
- Q - - 


*/
