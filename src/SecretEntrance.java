import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecretEntrance {

    public static int findCode(String path) {
        File input = new File(path);
        int dialPos = 50;
        int zeroCount = 0;

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int turn = Integer.parseInt(line.substring(1));

                if (line.charAt(0) == 'L') {
                    dialPos = (dialPos-turn)%100;

                } else  {
                    dialPos = (dialPos+turn)%100;
                }

                if (dialPos == 0){
                    zeroCount++;
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("FUCKKKK ITS ALL GONE WRONG: " + e.getMessage());
        }
        return zeroCount;
    }
}
