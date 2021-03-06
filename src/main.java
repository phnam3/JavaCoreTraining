import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args){
        //Java Core Training B2
        /*
        // Exception not being handled but Son1 can still be initialized (runtime exception) -> code still compiled
//        Son son1 = new Son();

        // Exception being handle inside try/catch block (catch runtime exception)
        try {
            Son son2 = new Son();
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        // Exception not being handled hence cannot compile these lines (compile-time exception)
//        Son son3 = new Son(true);
//        Son son4 = new Son(false);

        // Exception being handled inside try/catch block
        try {
            Son son5 = new Son(true);
            // Comment out because son5 already throws another exception -> redundant
//            Son son6 = new Son(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        //display odd integer
        Consumer<Integer> oddInteger = (i -> {
            if(i%2!=0){
                System.out.println(i);
            }
        });
        oddInteger.accept(10);
        oddInteger.accept(9);

        //display if two strings are equal
        BiConsumer<String, String> equals = ((first, second) -> {
            if(first.equals(second)){
                System.out.println(first);
            }
        });
        equals.accept("NO", "NO");
        equals.accept("YES", "NO");

        //display the total sum of digits of an integer
        Function<Integer, Integer> digits = (i -> {
            int count = 0;
            while(i > 0){
                count += i%10;
                i /= 10;
            }
            System.out.println(count);
            return count;
        });
        digits.apply(123123);

        //display the multiplication of 2 integer as a string
        BiFunction<Integer, Integer, String> sumString = ((a,b) -> Integer.toString(a*b));
        System.out.println(sumString.apply(10,20) + 30);

        //Create a school with 100 students
        Random rand = new Random();
        List<Student> studentList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Integer age = rand.nextInt(25-18) + 18;
            Integer gpa = rand.nextInt(7-1) + 1;
            studentList.add(new Student(age, gpa));
        }
        School school = new School(studentList);
        for(Student s : school){
            System.out.println("student with age: " + s.getAge() + " and gpa: " + s.getGpa());
        }

        //Create new list of good student with gpa > 4 in descending order of age
        List<Student> goodStudent = school.getStudentList().stream()
                .filter(s -> s.getGpa()>4)
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .collect(Collectors.toList());
        for(Student s : goodStudent){
            System.out.println("student with age: " + s.getAge() + " and gpa: " + s.getGpa());
        }

        //Create list of 10 students that is youngest and have the highest gpa
        List<Student> youngStudent = school.getStudentList().stream()
                .sorted((s1,s2) -> s1.getAge()- s2.getAge()).limit(10)
                .sorted((s1,s2) -> s2.getGpa()-s1.getGpa())
                .collect(Collectors.toList());
        for(Student s : youngStudent){
            System.out.println("student with youngest age: " + s.getAge() + " and highest gpa: " + s.getGpa());
        }
    }
}
