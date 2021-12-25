package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            sources.forEach(file -> {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.putNextEntry(new ZipEntry(file.toFile().getPath()));
                    zip.write(out.readAllBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void isValidPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

    public static void main(String[] args) {
        ArgsName arguments = ArgsName.of(args);
        isValidPath(String.valueOf(arguments.get("d")));
        if (arguments.get("d") == null || arguments.get("e") == null || arguments.get("o") == null) {
            throw new IllegalArgumentException("The arguments are zero. Fill in all the arguments");
        }
        try  {
            List<Path> paths = Search.search(new File(arguments.get("d")).toPath(), p -> p.toFile().getName().endsWith(arguments.get("e")));
            packFiles(paths, new File(arguments.get("o")));
            packSingleFile(
                    new File("./pom.xml"),
                    new File("./pom.zip")
            );
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
