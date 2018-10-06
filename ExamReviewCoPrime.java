/**
 * EXAM REVIEW Question 8: In mathematics, two integers a and b are said to be co-prime or relatively prime if they have no common factor other than 1 or, equivalently, if their greatest common factor is 1. For example, 6 and 35 are coprime, but 6 and 27 are not coprime because they are both divisible by 3.

Write a program that will read two integers, a and b, from the user and determine whether or not they are co-prime. If the two numbers are co-prime, output “co-prime” otherwise output “not co-prime”.
*/
class ExamReviewCoPrime{
  public static void main(String[] args){
    System.out.println("Enter the first int");
    int a = In.getInt();
    System.out.println("Enter the second int");
    int b = In.getInt();
    int i; // declare i before the loop so I can use it after the loop
    
    for(i = a; i > 1; i--) // start from one of the numbers and count backwards to 1
    {
      if( (a % i == 0) && (b % i == 0) )  // checking to see if i is a factor of a and b
      {
        System.out.println(a + " and " + b + " are not co-prime. They have a common factor of " + i);
        break; // no point to continue the loop once a common factor is found
      }
    }
    
    // If we get here and i is 1, that means no common factor (other than 1 was found)
    if(i == 1)
      System.out.println(a + " and " + b + " are co-prime.");
  }
}