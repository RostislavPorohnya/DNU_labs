public class fibonacci {

    int recursionExecute(int n){
        if (n <= 1) return n;

        int curr = recursionExecute(n - 1);
        int prev = recursionExecute(n - 2);

        return curr + prev;
    }
    int cycleExecute(int n){
        int prev = 0;
        int curr = 1;
        for (int i = 0; i <= n; i++){
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }
}
