import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String testString = "An1one can Learn abc'c,123, and any regular expr3ssion";
        String replacement = "(-)";
        String[] patterns = {
                "[a-zA-Z]*$",
                "[a-zA-Z]{3}",
                "[aA]ny\\b"
        };

        for (String pattern : patterns) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("pattern: " + pattern + " => " + output);
        }

        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake;
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and owlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;

        String[] lines = paragraph.split("\\s");
        System.out.println(paragraph.replaceAll("[a-zA-Z]+ble","[GRUB]"));

        Scanner scanner = new Scanner(paragraph);
        //System.out.println(scanner.delimiter());

        /*scanner.useDelimiter("\\s");*/
       /* scanner.tokens().forEach(System.out::println);*/

   /*     scanner.tokens()
                .map(s -> s.replaceAll("\\p{Punct}",""))
                .flatMap(s-> Arrays.stream(s.split("\\s+")))
                .filter(s->s.matches("[a-zA-Z]+ble"))
                .forEach(System.out::println);
*/

        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        scanner.nextLine();
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));

        /*while (scanner.hasNext()){
            String element = scanner.next();
            System.out.println(element);
        }*/
        scanner.close();



    }
    private static String format(String regexp, String...args){

        int index = 0;

        while(regexp.matches(".*%s*")){
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
/*
        while(regexp.contains("%s")){
            regexp = regexp.replaceFirst("%s", args[index++]);
        }*/

        return regexp;
    }
}