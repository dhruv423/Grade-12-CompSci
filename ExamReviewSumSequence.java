/**
 * Exam Review question 9. Write a program that starts by requesting an integer in the range 0 < N < 20. Numbers outside this range are rejected and a new request is made. Output the sum of the sequence of numbers starting at 1 and ending with N. The program then exits. Use the format shown in the example below:

With N = 5, the output will be

1 + 2 + 3 + 4 + 5 = 15
*/

class ExamReviewSumSequence{
  public static void main(String[] args){
    System.out.println("Please enter an int from 0-20");
    int n = In.getInt();
    
    while(n < 1 || n > 19) // request a new int
    {
      System.out.println("Please enter an int from 0-20");
      n = In.getInt();
    }
    int sum = 0;
    for(int i = 1; i <= n; i++)
      sum += i;
    
    System.out.print("The sum of the sequence from 1 to " + n + " is " + sum);
    System.out.println(543521);
    System.out.print(543521);
  }
}