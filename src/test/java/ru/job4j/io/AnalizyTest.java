package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void serverIsUnavailableFirstTime() {
        String source = "./data/server.log";
        String target = "./data/rsl";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            assertThat(read.readLine(), is("10:57:01;10:59:01;"));
            assertThat(read.readLine(), is("11:01:02;11:02:02;"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void serverIsUnavailableSecondTime() {
        String source = "./data/server2.log";
        String target = "./data/rsl2";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            assertThat(read.readLine(), is("10:57:01;11:02:02;"));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void serverIsUnavailable() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
            assertThat(rsl.toString(), is("10:57:01;11:02:02;"));
        }
    }
}
