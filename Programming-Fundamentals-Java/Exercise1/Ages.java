import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
         int age = new Scanner(System.in).nextInt();
         String type;
        if (age >= 66 ){
            type = "elder";
        }else if(age >= 20){
            type = "adult";
        }else if(age >= 14){
            type = "teenager";
        }else if(age >= 3){
            type = "child";
        }else{
            type = "baby";
        }
        System.out.println(type);
    }
}
