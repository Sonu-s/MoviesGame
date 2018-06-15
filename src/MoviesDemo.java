import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MoviesDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("Movies.txt");
        Scanner in = new Scanner(file);
        ArrayList<String> str = new ArrayList<String>();
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            str.add(line);
        }

        Random r = new Random();
        String randomString = str.get(r.nextInt(str.size()));
        System.out.println("Let's Play a game.You have guess the name of Movies.");
        System.out.println("Number of characters in a Movie is equal to (_).");
        System.out.println("In the place of space you are requested to write Underscore (_).");
        int count = 10;
        System.out.println("You are guessing : ");

        for (int i = 0; i < randomString.length(); i++) {
            System.out.print("_ ");
        }
        System.out.println();
       // System.out.println(randomString);

        //  char ch;
        int l = randomString.length();
        Scanner scanner = new Scanner(System.in);
        String[] Newstr = new String[l];
        for (int i = 0; i < l; i++) {
            Newstr [i] = "-";
        }
        String oldstr = new String(randomString);
        int c=0;
        ArrayList<String> wrstr=new ArrayList<String>();

        while (count != 0) {
            System.out.println("You have left " + count + " chance.");
            System.out.println("Guess a letter : ");
            String ch=scanner.next();
            int a = randomString.indexOf(ch);
            if (a != -1) {
                Newstr[a] =ch;

                c++;
                randomString = randomString.replaceFirst(ch, "-");

                for (int i = 0; i < l; i++)
                    System.out.print(Newstr[i]);
                System.out.println();
                if (c==l) {
                    System.out.println("You have Won the Game :)");
                    break;
                }

            } else {
                count--;

                wrstr.add(ch);
              //  String wrstr=new String(ch);
                for (int i = 0; i < l; i++)
                    System.out.print(Newstr[i]);
                System.out.println();
                System.out.println(wrstr.size());
                System.out.print("Worng letter(s) is/are : "+wrstr+" ");



            }
            System.out.println();
        }
        if(count==0)
        {
            //System.out.println("Sorry you lost the game.");
            System.out.println("Name of movies was : "+oldstr);
        }
        System.out.println();

    }
}

