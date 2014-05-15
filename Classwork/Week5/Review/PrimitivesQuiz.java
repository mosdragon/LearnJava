import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A simple console IO based quiz designed to review
 * Java primitive types and variable assignments.
 * @author Evan Cahill
 * @version 1.0.0
 */
public class PrimitivesQuiz {
    public static void main(String[] args) {

        //Open the questions.txt file for reading
        Scanner data = null;
        try {
            data = new Scanner(new File("questions.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Unable to locate questions.txt file:");
            System.err.println("Please make sure it is in the same folder.");
            System.exit(-1);
        }
        //A Regular Expression string (regex) to match the seperators
        data.useDelimiter("(\\s*\\|\\s*)|(\\s*\\n)");

        //Open a Scanner to read user input from the console
        Scanner user = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println(" Welcome to the Java Primitive Types Quiz");
        System.out.println("-------------------------------------------");

        //Statistics for the quiz
        int questionNum = 0;
        int correct = 0;
        int incorrect = 0;

        String statement, result;
        boolean compiles;

        //Loop over the questions in the file
        while (data.hasNextLine()) {
            //Read in question
            statement = data.next();
            compiles = Boolean.parseBoolean(data.next());
            if (compiles) {
                result = data.next();
            } else {
                result = "";
                for (int i = 0; i < 5; i++) {
                    result += data.next() + "\n";
                }
            }

            System.out.printf("Question #%d: %s%n", questionNum++, statement);

            //Get user input
            boolean answer = promptYesNo("Does the statement compile: ", user);

            //Check correctness of response
            if (answer) {
                if (compiles) {
                    System.out.println("Correct! Now what is its value: ");
                    correct++;
                    
                    String value = user.nextLine();
                    if (value.equals(result)) {
                        System.out.println("Correct!");
                        correct++;
                    } else {
                        System.out.println("Incorrect. The correct value is: " + 
                                result); 
                        incorrect++;
                    }
                } else {
                    System.out.println("Incorrect. It results in the following error:");
                    System.out.println(result);
                    incorrect++;
                }
            } else {
                if (!compiles) {
                    System.out.println("Correct! It results in the following error:");
                    System.out.println(result);
                    correct++;
                } else {
                    System.out.println("Incorrect. This is a valid statement " +
                            "which results in the follwing value: " + result);
                    incorrect++;
                }
            }


            data.nextLine();
            System.out.println("-------------------");
        }

        System.out.println("Game Over");
        int score = (int)((double) correct / (correct + incorrect) * 100);
        System.out.print("Your Score: " + score + "% ");
        if (score == 100) {
            System.out.println("Perfect job! Nicely done.");
        } else if (score >= 90) {
            System.out.println("So close! Just a bit off.");
        } else if (score >= 80) {
            System.out.println("You're getting there!");
        } else if (score >= 50) {
            System.out.println("Your knowledge of primitives is... primitive.");
        } else if (score == 0) {
            System.out.println("wat");
        } else {
            System.out.println("How did you even get here?");
        }
    }

    /**
     * Prompts for a yes or no response using the given prompt.
     * @param prompt A string representing the prompt to print to stdout.
     * @param input A scanner used to get the input from the user. 
     * @returns true if the response is yes, false if it is no
     */
    private static boolean promptYesNo(String prompt, Scanner input) {
        System.out.print(prompt);

        boolean valid = false;
        boolean answer = false;
        String response;
        do {
            response = input.nextLine().toLowerCase();
            if (response.equals("y") || response.startsWith("yes") || 
                response.startsWith("yeah") || response.startsWith("aye") ||
                response.startsWith("yep")) {
                answer = true;
                valid = true;
            } else if (response.equals("n") || response.startsWith("no")) {
                valid = true;
            } else {
                System.out.print("Input not understood, try again: ");
            } 
        } while (!valid);
        return answer;
    }
}
