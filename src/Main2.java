public class Main2 {
    public static void main(String[] args) {
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

        /*Scanner scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\R");
        scanner.tokens()
                .map(s->s.replaceAll("\\p{Punct}",""))
                .forEach(System.out::println);
*/
        System.out.println(doesItMatches("^Hello,World!$","Hello,World!"));
        System.out.println(doesItMatches("^[A-Z][^A-Z].*[\\p{Punct}]","I am a new student?"));
        System.out.println(doesItMatches("^[A-Z][^A-Z].*[\\p{Punct}]","The bike is red, and has flat tires."));
        System.out.println(doesItMatches("^[A-Z][^A-Z].*[\\p{Punct}]","I love being a new L.P.A student!"));
        System.out.println(doesItMatches("^[A-Z][^A-Z].*[\\p{Punct}]","Hello,friends and family: welcome!"));


        String si = "[\\p{]";

    }



    /*  var s = formatString("%s %s","ciao","Matteo");
            System.out.println(s);*/
    public static String formatString(String regex, String...doubleStrings){
        int i=0;
       while (regex.contains("%s"))
       {
           System.out.println(regex);
           regex = regex.replaceFirst("%s",doubleStrings[i]);
           i++;
       }
       return regex;
    }

    public static boolean doesItMatches(String regex,String string){
        return string.matches(regex);
    }
}
