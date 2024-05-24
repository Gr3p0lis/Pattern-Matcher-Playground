import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
    public static void main(String[] args) {

        String sentence = "I like B.M.W. motorcycles.";

        Pattern pattern = Pattern.compile("[A-Z].*?[.]");

        var matcher = pattern.matcher(sentence);

        matcher.matches();
        System.out.println("matcher() Lunghezza frase: " + matcher.end());

        matcher.lookingAt();
        System.out.println("lookingAt() Ending Index: " + matcher.end());
        matcher.reset();
        matcher.find();
        System.out.println("find() Ending Index: " + matcher.end());
        System.out.println("Matched on: " + sentence.substring(matcher.start(), matcher.end()));
        System.out.println("----------\n");

        String htmlSnippet = """
                <H1>My Heading</H1>
                <h2>Sub-Heading</h2>
                <p>This is a paragraph about something.</p>
                <p>This is another paragraph about something else.</p>
                <h3>Summary</h3>
                """;

        Pattern htmlPattern = Pattern.compile("<(?<numero>[Hh]\\d)>(?<stringa>.*?)</[Hh]\\d>");
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);
        while (htmlMatcher.find()) {
            System.out.println(htmlMatcher.group("stringa"));
        }
        /* System.out.println("\n");
       htmlMatcher.reset();
        htmlMatcher.results().forEach(matchResult -> System.out.println(
                matchResult.group(1) + " " + matchResult.group(2)
        ));*/


       /*  String tabbedText = """
                group1  group2  group3
                1   2   3
                a   b   c
                """;

       tabbedText.lines()
                .flatMap(s -> Pattern.compile("\\t").splitAsStream(s))
                .forEach(System.out::println);
*/


        String updateSnippet = htmlMatcher.replaceFirst(matchResult -> "<em>" + matchResult.group(2) + "</em>");

        System.out.println(updateSnippet);

        htmlMatcher.reset();
        System.out.println("\n");

      /*  htmlMatcher.usePattern(
                Pattern.compile("<[Hh](?<numero>\\d)>(?<stringa>.*?)</\\1>")
        );*/

        System.out.println("Utilizzo di back reference: " +"\n"
         + htmlMatcher.replaceFirst("<em>$2</em>"));

        String replacedHtml = htmlMatcher.replaceAll(matchResult -> "<em>" + matchResult.group(2) + "</em>");
        System.out.println(replacedHtml);

        System.out.println("\n");


        htmlMatcher.reset();
        while (htmlMatcher.find()){
            System.out.println(htmlMatcher.group("numero").toLowerCase());
        }

        System.out.println("\n");

        htmlMatcher.reset();

        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        while (htmlMatcher.find()) {
            htmlMatcher.appendReplacement(
                    stringBuilder,
                    switch (htmlMatcher.group("numero").toLowerCase()) {
                        case "h1" -> "<head>$2</head>";
                        case "h2" -> "<em>$2</em>";
                        default -> "<$1>" + index++ + ". $2</$1>";
                    });
        }
        System.out.println(stringBuilder + "---");
            htmlMatcher.appendTail(stringBuilder);

            System.out.println("String builder: \n" );
            while (htmlMatcher.find()){
                System.out.println(htmlMatcher.group());
            }

    }
}
