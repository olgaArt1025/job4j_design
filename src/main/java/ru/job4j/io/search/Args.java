package ru.job4j.io.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Args {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Arrays.stream(args)
                .filter(this::check)
                .forEach(line -> {
                    line = line.substring(1);
                    line = line.trim();
                    String[] words = line.split("=");
                    values.put(words[0], words[1]);
                });
    }

    public static Args of(String[] args) {
       Args names = new Args();
        names.parse(args);
        return names;
    }

    private boolean check(String words) {
        if (!words.startsWith("-") || !words.contains("=") || words.startsWith("-=")
                || words.indexOf("=") != words.lastIndexOf("=") || words.endsWith("=")) {
            throw new IllegalArgumentException("The pattern doesn't match : -key=value");
        }
        return true;
    }
}


