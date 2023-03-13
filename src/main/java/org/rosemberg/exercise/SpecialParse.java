package org.rosemberg.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecialParse {

    public static String wordParser(String input) {

        final char[] letters= input.toCharArray();

        final List<String> words= new ArrayList<>();

        int i=0;

        while(i<letters.length){

            final StringBuilder sb= new StringBuilder();
            sb.append(letters[i]);

            final Set<Character> intermedialLetters=new HashSet<>();

            i++;

            while(i<letters.length
                    && Character.isAlphabetic(letters[i])
                    && i+1<letters.length
                    && Character.isAlphabetic(letters[i+1]))
                intermedialLetters.add(letters[i++]);


            if(!intermedialLetters.isEmpty()){
                sb.append(intermedialLetters.size());
            }

            sb.append(letters[i++]);

            for(;i<letters.length && letters[i]!=' ';i++)
                sb.append(letters[i]);

            words.add(sb.toString());

            i++;

        }

        return String.join(" ", words);
    }

    public static void main (String[] args) {
        String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        assert "C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!".equals(output);
        System.out.println(output);
    }
}
