package Program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphanumericSort {

	public static void main(String[] args) {
		
		String input = "A11a4";
        System.out.println("Output -> " + alphanumericSort(input));
	}
        public static String alphanumericSort(String input) {
            List<String> numbers = new ArrayList<>();
            List<Character> lowercase = new ArrayList<>();
            List<Character> uppercase = new ArrayList<>();
            List<Character> others = new ArrayList<>();
            StringBuilder numBuffer = new StringBuilder();

            for (char c : input.toCharArray()) {
                if (Character.isDigit(c)) {
                    numBuffer.append(c);
                } else {
                    if (numBuffer.length() > 0) {
                        numbers.add(numBuffer.toString());
                        numBuffer.setLength(0);
                    }
                    if (Character.isLowerCase(c)) lowercase.add(c);
                    else if (Character.isUpperCase(c)) uppercase.add(c);
                    else others.add(c);
                }
            }
            if (numBuffer.length() > 0) numbers.add(numBuffer.toString());

            numbers.sort(Comparator.comparingInt(Integer::parseInt));
            Collections.sort(lowercase);
            Collections.sort(uppercase);
            Collections.sort(others);

            StringBuilder result = new StringBuilder();
            numbers.forEach(result::append);
            lowercase.forEach(result::append);
            uppercase.forEach(result::append);
            others.forEach(result::append);

            return result.toString();

	}

}
