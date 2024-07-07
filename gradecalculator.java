import java.util.Scanner;

public class gradecalculator {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

        String[] subject ={"Math" , "physics" , "chemistry" , "operating system"};

        int[] mark = new int[subject.length];
       
        for(int i = 0; i < subject.length; i++)
        {
            System.out.println(subject[i]);
             mark[i] = scanner.nextInt();
        
        while (mark[i] < 0|| mark[i] > 100) {
               System.out.println(subject[i]);
               mark[i] = scanner.nextInt();
            }
        }
        int totalmarks =0;
        for(int i = 0; i<subject.length; i++)
        totalmarks += mark[i];

        double average = totalmarks/subject.length;
      
        char grade = 'f';
        if(average >=90 && average <=100){
            grade = 'a';
        }
        else if (average >=70 && average <90) {
            grade = 'b';
        }
        else if (average >= 50 && average <70) {
            grade = 'c';
        }
        
           for(int i = 0 ; i <subject.length; i++)
           {
             System.out.println(subject[i] + ": " + mark[i]);
           }
           System.out.println("Total marks: "+totalmarks);
           System.out.println("Average: "+average);
           System.out.println("Grade: "+grade);
    }
}