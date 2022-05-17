import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File myfile = new File("GG.txt");
        ArrayList<String> doc = new ArrayList<String>();

        var reservedWords = new ArrayList<String>(Arrays.asList(
                "and", "file", "mod", "repeat",
                "array", "for", "nil", "set",
                "begin", "forward", "not", "then",
                "case", "function", "of", "to",
                "const", "goto", "or", "type",
                "div", "if", "packed", "until",
                "do", "in", "procedure", "var",
                "downto", "label", "program",
                "while", "else", "main", "record",
                "with"
        ));
        var specialSymbols = new ArrayList<String>(Arrays.asList(
                "+","-","*","/","=","<", ">","[","]",
                ".",",",":=",":",";", "(",")","<>",
                "<=",">=","..","^"
        ));

        compare(reservedWords,myfile);
    }

    public static void compare(ArrayList<String> keyword,File myfile) throws FileNotFoundException {
        Scanner scan = new Scanner(myfile);

        ArrayList<String> a = new ArrayList<String>();

        while (scan.hasNext()) {
            String word = scan.next();
            a.add(word);
        }

        int[] id = new int[a.size()];
        String[] resWords = new String[a.size()];
        for (int j = 0; j < a.size(); j++) {
            for (int i = 0; i < keyword.size(); i++) {
                if (Objects.equals(keyword.get(i), a.get(j))) {
                    System.out.println("Yes");
                    id[j] = 100;
                    resWords[j] = a.get(j);
                }
            }
        }

        for (int i = 0; i < id.length; i++) {
            if (resWords[i] == null && id[i] == 0) {
                continue;
            }
            System.out.println("ID : " + id[i] + "| Word : " + resWords[i]);

        }
    }
}
