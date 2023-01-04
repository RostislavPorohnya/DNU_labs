public class sum {
    public int execute(int x, int y){
        if (y == 0) return x;

        return execute(x ^ y, (x & y) << 1);
    }
}
