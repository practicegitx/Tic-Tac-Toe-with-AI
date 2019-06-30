import java.util.*;

public class Tic_Tac_Toe
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cells: ");
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();

        System.out.println("---------");

        System.out.print("| ");
        System.out.print(charArray[1] + " " + charArray[2] + " " + charArray[3]);
        System.out.println(" |");

        System.out.print("| ");
        System.out.print(charArray[4] + " " + charArray[5] + " " + charArray[6]);
        System.out.println(" |");

        System.out.print("| ");
        System.out.print(charArray[7] + " " + charArray[8] + " " + charArray[9]);
        System.out.println(" |");

        System.out.println("---------");



    }



}
