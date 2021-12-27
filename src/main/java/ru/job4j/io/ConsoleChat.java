package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = readPhrases();
        List<String> log = new ArrayList<>();
        boolean workChat = true;
        String question = "";
        Scanner chat = new Scanner(System.in);
        while (!OUT.equals(question)) {
            System.out.print("User: ");
            question = chat.nextLine();
            log.add("User: " + question);
            if (STOP.equals(question)) {
                workChat = false;
                continue;
            }
            if (CONTINUE.equals(question)) {
                workChat = true;
            }
            if (workChat && (!OUT.equals(question))) {
                Random random = new Random();
                int index = random.nextInt(answers.size());
                String answer = answers.get(index);
                System.out.println(answer);
                log.add("Bot: " + answer);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases()  {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
           while (br.ready()) {
               rsl.add(br.readLine());
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log)  {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("logBot.txt", "botAnswers.txt");
        cc.run();
    }
}
