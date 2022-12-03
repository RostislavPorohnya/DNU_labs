public class factorial {
    int recursionExecute(int n){
        if (n < 1) return 1;

        return n * recursionExecute(n - 1);
    }
    int cycleExecute(int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            res *= i;
        }

        return res;
    }
}
