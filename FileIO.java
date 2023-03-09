
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* Reading input from a file.
*
* @author  Keiden B
* @version 1.0
* @since   2023-03-08
*/

public final class FileIO {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    * @throws Exception thrown when making scanner for input file
    */
    public static void main(String[] args) throws Exception {
        final File path = new File("./Java-06-Input.txt");
        final FileWriter fileOut = new FileWriter("./Java-06-Output.txt");
        final Scanner get = new Scanner(path);

        boolean pushed = false;

        while (get.hasNextLine()) {
            final String txtString = get.nextLine();
            final String[] txtList = txtString.split(" ");

            int sum = 0;
            boolean noError = true;

            for (String valueStr : txtList) {
                try {
                    final int valueInt = Integer.parseInt(valueStr);

                    sum += valueInt;
                } catch (NumberFormatException error) {
                    noError = false;
                    if ("".equals(valueStr)) {
                        fileOut.write("Error: Empty line as input\n");
                    } else {
                        fileOut.write("Error: For value \""
                            + valueStr + "\"\n");
                    }
                    pushed = true;
                }
            }
            if (noError) {
                fileOut.write("       Sum of line is \"" + sum + "\"\n");
                pushed = true;
            }
        }
        if (pushed) {
            System.out.println("Successfully wrote to file!");
        } else {
            System.out.println("An error has occured!");
        }

        fileOut.close();
        get.close();
    }
}
