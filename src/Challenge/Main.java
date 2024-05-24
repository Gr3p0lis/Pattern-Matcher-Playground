package Challenge;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String emails = """
                john.boy@valid.com
                john.boy@invalid
                jane.doe-smith@valid.co.uk
                jane_Doe1976@valid.co.uk
                bob-1964@valid.net
                bob!@invalid.com
                elaine@valid-test.com.au
                elaineinvalid1983@.com
                david@valid.io
                david@invalid..com
                """;

        /* username.@domain. */
        Pattern emailPattern = Pattern.compile("(?<username>[\\w.—–-]+)[@](?<domain>([\\w-]+\\.)+[a-zA-Z]{2,})");
        Matcher emailMatcher = emailPattern.matcher(emails);
        emailMatcher.results()
                .forEach(matchResult ->
                        System.out.printf("[Username: %s Domain: %s]%n",
                                matchResult.group(1),
                                matchResult.group(2))
                );

        Arrays.stream(emails.split("\n"))
                .forEach(email -> {
                            Matcher matcher = emailPattern.matcher(email);
                            var isMatching = matcher.matches();
                            if (isMatching)
                                System.out.println("Username: " + matcher.group("username") + "\tDomain" + matcher.group("domain"));
                        }
                );
    }
}

