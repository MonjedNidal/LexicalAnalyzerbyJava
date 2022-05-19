import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        File myFile = new File("GG.txt");
        var reservedWords = new ArrayList<>(Arrays.asList(
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
        ArrayList specialSymbols = new ArrayList(Arrays.asList(
                "+", "-", "*", "/", "=", "<", ">", "[", "]",
                ".", ",", ":=", ":", ";", "(", ")", "<>",
                "<=", ">=", "..", "^"
        ));

        ArrayList<String> words = new ArrayList<>();

        Cut(words, myFile);
//        for (String word : words) {
//            System.out.println(word);
//        }
        keywordsCheck(reservedWords, words);
//        for (String word : words) {
//            System.out.println(word);
//        }
        integerCheck(words);

        floatCheck(words);

        //Note:This method convert ArrayList of type String to Character.
        symbolCheck(specialSymbols, words);
    }

    public static void Cut(ArrayList<String> words, File myFile) throws FileNotFoundException {
        Scanner scan = new Scanner(myFile);
        while (scan.hasNext()) {
            String word = scan.next();
            words.add(word);
        }
    }

    public static void keywordsCheck(ArrayList<String> keyword, ArrayList<String> a) {
        Map<Integer, String> result = new HashMap<>();
        int[] id = new int[a.size()];
        String[] resWords = new String[a.size()];
        for (int j = 0; j < a.size(); j++) {
            for (int i = 0; i < keyword.size(); i++) {
                if (Objects.equals(keyword.get(i), a.get(j))) {
                    result.put(100, a.get(j));
                    id[j] = 100;
                    resWords[j] = a.get(j);
                    a.remove(j);
                }
            }
        }
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == 0 || resWords[i] == null) {
                continue;
            }
            System.out.println("ID : " + id[i] + "| Word : " + resWords[i]);
        }
//        System.out.println("------------------------------");
//        for (int i = 0; i < result.size(); i++) {
//            Set<Integer> key = result.keySet();
//            Set<String> word = Collections.singleton(result.get(key));
//            System.out.println("ID : " + key.toArray()[i] + "| Word : " + word.toArray()[i]);
//        }
//        System.out.println(Arrays.asList(result));
    }

    public static void integerCheck(ArrayList<String> words) throws FileNotFoundException {
        ArrayList<Integer> integersId = new ArrayList<>();
        ArrayList<String> integers = new ArrayList<>();

//        String num = "";
//        if (scanner.hasNextLine()) {
//
//                num = "4.8";
////            num=scanner.next();
//                try {
//                    Integer.parseInt(num);
//                    integersId.add(300);
//                    integers.add(scanner.nextInt());
//                } catch (NumberFormatException e) {
//                    System.out.println("yes");
//                }
//
//        }

//        while (scanner.hasNextLine()){
//            if (scanner.hasNextInt()){
//                System.out.println("Yes");
//                integersId.add(300);
//                integers.add(scanner.nextInt());
//            }else System.out.println("No");
//
//        }

        for (int i = 0; i < words.size(); i++) {
            Object obj = words.get(i);

            try {
                Integer.parseInt((String) obj);
//                System.out.println("Yes");
                integersId.add(300);
                integers.add((String) obj);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < integersId.size(); i++) {
            System.out.println("Id : " + integersId.get(i) + " | Integers : " + integers.get(i));
        }

    }

    public static void floatCheck(ArrayList<String> words) {
        ArrayList<Integer> floatsId = new ArrayList<>();
        ArrayList<String> floats = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            Object obj = words.get(i);

            try {
                Float.parseFloat((String) obj);
                floatsId.add(450);
                floats.add((String) obj);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < floatsId.size(); i++) {

            System.out.print("Id : " + floatsId.get(i) + " | Floats : ");
            System.out.printf("%.2f", Float.parseFloat(floats.get(i)));
            System.out.println();
        }
    }

    public static void symbolCheck(ArrayList specialSymbols, ArrayList words) {

        ArrayList<Character> charWords = new ArrayList<>();
        ArrayList<Integer> symbolId = new ArrayList<>();
        ArrayList<String> resultSymbol = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String t = (String) words.get(i);
            for (int j = 0; j < t.length(); j++) {
//                System.out.println("yes");
//                charWords.add(t.charAt(j));
                for (int k = 0; k < specialSymbols.size(); k++) {
                    String test1 = String.valueOf(t.charAt(j));

                    if (specialSymbols.get(k).equals(test1)) {
                        //System.out.println("Yes");
                        symbolId.add(200);
                        resultSymbol.add(test1);
                    } else {
                        continue;
                    }
                }
            }
        }

//        int[] symbolId = new int[charWords.size()];
//        String[] resultSymbol = new String[charWords.size()];

//        for (int i = 0; i < charWords.size(); i++) {
//            for (int j = 0; j < specialSymbols.size(); j++) {
//                if (specialSymbols.get(j).)) {
//                    System.out.println("yes");
//                    symbolId.add(200);
//                    resultSymbol.add(charWords.get(i));
//                } else {
//                    continue;
//                }
//            }
//        }
        for (int i = 0; i < symbolId.size(); i++) {
            System.out.println("Id : " + symbolId.get(i) + " | Symbols : " + resultSymbol.get(i));
        }
    }

}

