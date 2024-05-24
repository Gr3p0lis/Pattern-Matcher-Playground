# Pattern-Matcher-Playground

Main 1:
This Java code snippet demonstrates various string manipulation operations using regular expressions and the `Scanner` class. Here's an explanation of what the code does:

1. **String Replacement using Regular Expressions**:
   - The `testString` contains a sample string.
   - An array of `patterns` is defined, each representing a regular expression pattern to match against the `testString`.
   - The code iterates through each pattern in the `patterns` array.
   - For each pattern, it uses `replaceFirst` method to replace the first occurrence of the pattern with the `replacement` string.
   - The original pattern and the modified string are printed to the console.

2. **Manipulating Paragraph String**:
   - The `paragraph` variable contains a multi-line string.
   - The `split` method is used to split the paragraph into individual words.
   - The `replaceAll` method replaces all occurrences of words ending with "ble" with "[GRUB]" and prints the modified paragraph.

3. **Using the `Scanner` Class**:
   - A `Scanner` object named `scanner` is created with the `paragraph` string as input.
   - The `findInLine` method is used multiple times to find the next occurrence of a word ending with "ble" in the paragraph.
   - After each `findInLine` call, the scanner moves to the next line using `nextLine`.
   - Finally, the `Scanner` object is closed to release system resources.

4. **Utility Method**:
   - The `format` method is defined to format a regular expression with dynamic arguments.

Overall, the code demonstrates how to use regular expressions to manipulate strings and how to utilize the `Scanner` class to parse input.


Main 2:

