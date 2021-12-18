package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Analizy {

    public void unavailable(String source, String target) {
        AtomicBoolean point = new AtomicBoolean(false);
        List<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines()
                    .forEach(line -> {
                        String[] words = line.split(" ");
                        if (("400".equals(words[0]) || "500".equals(words[0])) && !point.get()) {
                            rsl.add(words[1] + ";");
                            point.set(true);
                        }
                        if (("200".equals(words[0]) || "300".equals(words[0])) && point.get()) {
                            int index = rsl.size() - 1;
                            rsl.add(rsl.get(index) + words[1] + ";");
                            rsl.remove(index);
                            point.set(false);
                        }
                    });
        } catch (IOException e) {
             e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String line : rsl) {
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
