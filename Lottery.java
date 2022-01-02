import java.util.Scanner;

public class Lottery {
    public static void main(String[] args){
        int lottery = (int)(Math.random() * 100);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery number (two digits)");
        int guess = input.nextInt();
        //Get digits from lottery
        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;

        //Get digits from lottery
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("The lottery number is " + lottery);

        //check 
        if (guess == lottery)
            System.out.println("Exact match");
        else if (guessDigit1 == lotteryDigit2
                && guessDigit2 == lotteryDigit1)
            System.out.println("Match all digits");
        else if (guessDigit1 == lotteryDigit1
                || guessDigit1 == lotteryDigit2
                || guessDigit2 == lotteryDigit1
                || guessDigit2 == lotteryDigit2)
            System.out.println("Match one digit");
        else 
            System.out.println("No match");
    }
}
