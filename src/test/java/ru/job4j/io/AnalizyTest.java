package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

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
}
