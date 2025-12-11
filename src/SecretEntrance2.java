import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecretEntrance2 {

    public static int findCode(String path) {
        File input = new File(path);
        int dialPos = 50;
        int zeroCount = 0;
        int oldDialPos = dialPos;

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int turn = Integer.parseInt(line.substring(1));

                if (line.charAt(0) == 'L') {
                    turn *= -1;
                }

                oldDialPos = dialPos;
                dialPos += turn;

                if (turn > 0){
                    zeroCount += Math.floorDiv(dialPos, 100) - Math.floorDiv(oldDialPos, 100);
                }
                if (turn < 0){
                    zeroCount += Math.floorDiv(oldDialPos-1, 100) -  Math.floorDiv(dialPos-1, 100);
                }

                dialPos = Math.floorMod(dialPos,100);
            }

        } catch (FileNotFoundException e) {
            System.out.println("FUCKKKK ITS ALL GONE WRONG: " + e.getMessage());
        }
        return zeroCount;
    }
}
