import java.util.*;

public class Tic_Tac_Toe
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int gameState = 0;
        int exit = 0;
        int done;
        char[] charArray = {' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' '};
        char playerWillPlayX = 'X';
        char playerWillPlayO = 'O';

        do {
            System.out.println("Input command:");
            String  gameStartExit = scanner.nextLine();
            done = 1;
            switch (gameStartExit) {
                case "start user user":
                    printBlankBoard();
                    while (true) {
                        humanMove(charArray, playerWillPlayX);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                        humanMove(charArray, playerWillPlayO);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                    }
                    break;

                case "start user easy":
                    printBlankBoard();
                    while (true) {
                        humanMove(charArray, playerWillPlayX);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                        CompEasyMove(charArray, playerWillPlayO);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                    }
                    break;

                case "start easy user":
                    printBlankBoard();
                    while (true) {
                        CompEasyMove(charArray, playerWillPlayX);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                        humanMove(charArray, playerWillPlayO);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                    }
                    break;

                case "start easy easy":
                    printBlankBoard();
                    while (true) {
                        CompEasyMove(charArray, playerWillPlayX);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                        CompEasyMove(charArray, playerWillPlayO);
                        gameState = checkGameState(charArray);
                        if (gameState != 0)
                            break;
                    }
                    break;


                case "exit":
                    gameState = 6;
                    break;

                default:
                    System.out.println("Bad parameters!");
                    done = 0;
                    continue;

            }
        }   while (done == 0);

        //System.out.println("Enter cells: ");
        //String str = scanner.nextLine();
        //charArray = str.toCharArray();

        // Add switch (int gamestate = enumerator)
        if (gameState == 6)
            return;
        else if (gameState == 1)
            System.out.println("X wins");

        else if (gameState == 2)
            System.out.println("O wins");

        else if (gameState == 3)
            System.out.println("Draw");

        else if (gameState == 4)
            System.out.println("Impossible");

        else if (gameState == 5)
            System.out.println("Game not finished");



    }

    public enum gameState {
        Game_not_finished,
        Draw,
        X_wins,
        O_wins,
        Impossible
    }
    public static int checkGameState(char charArray[])
    {
        // Game State:
        boolean isWinX = false;
        boolean isWinO = false;
        boolean isImpossible = false;
        boolean isNotFinished = false;
        boolean isDraw = false;
        int rowMax = 9;
        int countX = 0;
        int countO = 0;
        // "X wins" - when the field has three X in a row;
        if (
                        ( charArray[1] == 'X' && charArray[2] == 'X' && charArray[3] == 'X') ||
                        ( charArray[4] == 'X' && charArray[5] == 'X' && charArray[6] == 'X') ||
                        ( charArray[7] == 'X' && charArray[8] == 'X' && charArray[9] == 'X') ||

                        ( charArray[1] == 'X' && charArray[4] == 'X' && charArray[7] == 'X') ||
                        ( charArray[2] == 'X' && charArray[5] == 'X' && charArray[8] == 'X') ||
                        ( charArray[3] == 'X' && charArray[6] == 'X' && charArray[9] == 'X') ||

                        ( charArray[1] == 'X' && charArray[5] == 'X' && charArray[9] == 'X') ||
                        ( charArray[3] == 'X' && charArray[5] == 'X' && charArray[7] == 'X')
        )
        { isWinX = true;
            return 1;
        }
        // "O wins" - when the field has three O in a row;
        if (
                ( charArray[1] == 'O' && charArray[2] == 'O' && charArray[3] == 'O') ||
                        ( charArray[4] == 'O' && charArray[5] == 'O' && charArray[6] == 'O') ||
                        ( charArray[7] == 'O' && charArray[8] == 'O' && charArray[9] == 'O') ||

                        ( charArray[1] == 'O' && charArray[4] == 'O' && charArray[7] == 'O') ||
                        ( charArray[2] == 'O' && charArray[5] == 'O' && charArray[8] == 'O') ||
                        ( charArray[3] == 'O' && charArray[6] == 'O' && charArray[9] == 'O') ||

                        ( charArray[1] == 'O' && charArray[5] == 'O' && charArray[9] == 'O') ||
                        ( charArray[3] == 'O' && charArray[5] == 'O' && charArray[7] == 'O')
        )
        {
            isWinO = true;
            return 2;
        }
        // "Impossible" - when the field has three X in a row as well as three O in a row.
        // Or the field has a lot more X's that O's or vice versa (if the difference is 2 or more, should be 1 or 0).

        if (isWinX == true && isWinO == true)
        {
            isImpossible = true;
            isWinX = false;
            isWinO = false;
        }

        for (int row = 1; row <= rowMax; row++ )
        {
            if (charArray[row] == 'X')
                countX++;
            if (charArray[row] == 'O')
                countO++;
        }
        if (countX >= countO + 2 || countO >= countX + 2)
        {
            isImpossible = true;
            isWinX = false;
            isWinO = false;
            return 4;
        }

        // "Draw" - when no side has a three in a row and the field has no empty cells;
        if (countX + countO == 9 && isWinX == false && isWinO == false) //&& isImpossible == false)
        {
            isDraw = true;
            return 3;
        }
        return 0;

        // "Game not finished" - when no side has a three in a row but the field has empty cells;
        //if (countX + countO < 9 && isWinX == false && isWinO == false && isImpossible == false)
        //   isNotFinished = true;
    }
    public static void CompEasyMove(char charArray[], char XorO)
    {
        System.out.println("Making move level \"easy\"");
        int[] freeFields = new int [10];
        // charArray = {' ', ' ', ' ',' ',' ',' ',' ',' ',' ',' '}; ima ih 10, od 0 do 9
        int countFreeField = 0;
        for (int i = 1; i <= 9; i++)
        {
            if (charArray[i] == ' ')
            {
                freeFields [countFreeField] = i;
                countFreeField++;
            }
        }
        Random random = new Random();
        int randomNumber = random.nextInt(countFreeField);
        int randomNum = freeFields[randomNumber];
        charArray[randomNum] = XorO;

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
     public static void humanMove(char[] charArray, char XorO)
    {
         // Human Move, user input coordinates
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Enter the coordinates:");

        String userCoord1 = scanner.next();
        String userCoord2 = scanner.next();

        while (!userCoord1.matches("\\d+") || !userCoord2.matches("\\d+"))
        {
            System.out.println("You should enter numbers!");
            userCoord1 = scanner.next();
            userCoord2 = scanner.next();
        }
        int userCoordLeftToRight = Integer.parseInt(userCoord1);
        int userCoordBotToTop = Integer.parseInt(userCoord2);

        int conversionCoord = 0;

        while (
                ((userCoordBotToTop < 1) || (userCoordBotToTop > 3)) ||
                        ((userCoordLeftToRight < 1) || (userCoordLeftToRight > 3))
        )
        {
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.println ("Enter the coordinates:");
            userCoordLeftToRight = scanner.nextInt();
            userCoordBotToTop = scanner.nextInt();
        }



        switch (userCoordBotToTop)
        {
            case 1:
                conversionCoord = userCoordLeftToRight + 6;
                break;
            case 2:
                conversionCoord = userCoordLeftToRight + 3;
                break;
            case 3:
                conversionCoord = userCoordLeftToRight;
                break;
        }


        // This cell is occupied! Choose another one!

        while (charArray[conversionCoord] != ' ')
        {
            System.out.println("This cell is occupied! Choose another one!");
            userCoordLeftToRight = scanner.nextInt();
            userCoordBotToTop = scanner.nextInt();
            switch (userCoordBotToTop)
            {
                case 1:
                    conversionCoord = userCoordLeftToRight + 6;
                    break;
                case 2:
                    conversionCoord = userCoordLeftToRight + 3;
                    break;
                case 3:
                    conversionCoord = userCoordLeftToRight;
                    break;
            }
        }


        charArray[conversionCoord] = XorO;

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
    public static void printBlankBoard()
    {
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
    }
}
