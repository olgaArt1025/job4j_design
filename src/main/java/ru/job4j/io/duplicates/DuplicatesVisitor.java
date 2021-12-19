package ru.job4j.io.duplicates;

import ru.job4j.map.Map;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private HashMap<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty newFile = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!files.containsKey(newFile)) {
            List<Path> paths = new ArrayList();
            paths.add(file);
            files.put(newFile, paths);

        } else {
            List<Path> paths = files.get(newFile);
            paths.add(file);
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
