public class digitsSum {
    int execute(int number){
        if (number == 0){
            return 0;
        }

        return (number % 10) + execute(number/10);
    }
}
