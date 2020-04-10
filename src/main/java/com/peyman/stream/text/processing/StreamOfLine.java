package com.peyman.stream.text.processing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLine {

    public static void main(String[] args) throws IOException {
        //Regex that matches one or more consecutive whitespace characters
        Pattern pattern = Pattern.compile("\\s+");

        Map<String, Long> wordCounts =
                Files.lines(Paths.get(".").resolve("paragraph.txt"))
                .map(line -> line.replaceAll("(?!')\\p{P}",""))
                .flatMap(line -> pattern.splitAsStream(line))
                .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new,Collectors.counting()));
    wordCounts.entrySet().stream()
            .collect(Collectors.groupingBy(entry ->entry.getKey().charAt(0),TreeMap::new,Collectors.toList()))
            .forEach((letter,worldList)-> {
                System.out.printf("&n%C%n",letter);
                worldList.stream().forEach(word -> System.out.printf("%13s: %d%n",word.getKey(),word.getValue()));
            });
    }

}
