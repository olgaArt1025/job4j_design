package ru.job4j.io.search;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Find {
    private static List<Path> list = new ArrayList<>();

    static void find(Args args) throws Exception {
        isValidArgs(args);
        String directory = args.get("d");
        String out = args.get("o");
        SearchFiles searchFiles = typeOfFind(args);
        Files.walkFileTree(Paths.get(directory), searchFiles);
        list = searchFiles.getList();
        write(list, out);
    }

    private static  void write(List<Path> paths, String outFile) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(outFile))) {
            for (Path path : paths) {
                out.println(path);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static SearchFiles typeOfFind(Args args) {
        if ("name".equals(args.get("t"))) {
            return new SearchFiles(x -> x.endsWith(args.get("n")));
        }
        if ("mask".equals(args.get("t"))) {
            String name = args.get("n").replaceAll("\\*", "\\.*");
            Pattern pattern = Pattern.compile(name);
            return new SearchFiles(x -> pattern.matcher(x.toString()).find());
        }
        if ("regex".equals(args.get("t"))) {
            Pattern pattern = Pattern.compile(args.get("n"));
            return new SearchFiles(x -> pattern.matcher(x.toString()).find());
        }
        return null;
    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        private List<Path> list = new ArrayList<>();
        private Predicate<String> predicate;

        public SearchFiles(Predicate<String> predicate) {
            this.predicate = predicate;
        }

        public List<Path> getList() {
            return list;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (predicate.test(file.toString())) {
                list.add(file);
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void isValidArgs(Args args) {
        String[] parameters = {"d", "n", "t", "o"};
        for (String parameter : parameters) {
            if (args.get(parameter.toLowerCase()) == null) {
                throw new IllegalArgumentException(String.format("%s parameter not found.", parameter));
            }
        }
        if (!new File(args.get("d")).isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", new File(args.get("d")).getAbsoluteFile()));
        }
    }

    public static void main(String[] args) throws Exception {
        Args jvm = Args.of(new String[]{"-d=c:\\projects\\job4j_design", "-n=*.txt",  "-t=mask", "-o=log2.txt"});
        Find.find(jvm);
    }
}

