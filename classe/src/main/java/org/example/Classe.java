package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class Classe {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }
        String className = args[0];
        File dir = new File(args[1]);
        boolean shouldUseParallelStream = args[2].equals("-p");

        long startTime = System.nanoTime();
        List<File> classFiles = findClassFiles(dir, className, shouldUseParallelStream);
        long endTime = System.nanoTime();
        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        if (classFiles.isEmpty()) {
            System.out.println("Couldn't find class in any .class, .war or .jar");
        } else {
            System.out.println("Class found at:");
            for (File file : classFiles) {
                System.out.println(file.getAbsolutePath());
                System.out.println("\n");
            }
        }

        System.out.println(classFiles.size() + " files consulted");
        System.out.println(elapsedTime + "ms spent");

    }

    private static List<File> findClassFiles(File directory, String className, boolean shouldUseParallelStream) {
        List<File> result = new ArrayList<>();

        try (Stream<File> fileStream = getAllFilesStream(directory, shouldUseParallelStream)) {
            fileStream.forEach(file -> {
                if (file.getName().endsWith(".class")) {
                    String fileName = file.getName().substring(0, file.getName().length() - 6);
                    String filePath = file.getPath().replace(File.separator, ".");
                    if (filePath.contains(className) || fileName.contains(className)) {
                        result.add(file);
                    }
                }
                if (file.getName().endsWith(".war") || file.getName().endsWith(".jar")) {
                    try {
                        findJarWarClasses(file, result, className);
                    }
                    catch (IOException e){
                        System.out.println("IOException");
                    }
                }

            });
        } catch (IOException e) {
            System.out.println("Unable to get files");
        }
        return result;
    }

    private static Stream<File> getAllFilesStream(File directory, boolean shouldUseParallelStream) throws IOException {
        if (!shouldUseParallelStream) {
            return listAllFilesSequential(directory);
        }
        return listAllFilesParallel(directory);
    }

    private static Stream<File> listAllFilesSequential(File directory) throws IOException {
        return Stream.of(Objects.requireNonNull(directory.listFiles()))
                .flatMap(file -> {
                    if (file.isDirectory()) {
                        try {
                            return listAllFilesSequential(file);
                        } catch (IOException e) {
                            System.out.println("IOException");
                            return Stream.empty();
                        }
                    } else {
                        return Stream.of(file);
                    }
                });
    }

    private static Stream<File> listAllFilesParallel(File directory) throws IOException {
        return Stream.of(Objects.requireNonNull(directory.listFiles()))
                .parallel()
                .flatMap(file -> {
                    if (file.isDirectory()) {
                        try {
                            return listAllFilesParallel(file);
                        } catch (IOException e) {
                            System.out.println("IOException");
                            return Stream.empty();
                        }
                    } else {
                        return Stream.of(file);
                    }
                });
    }

    private static void findJarWarClasses(File file, List<File> result, String className) throws IOException {
        Set<String> classNames = new HashSet<>();

        try (JarFile jarFile = new JarFile(file)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String name = jarEntry.getName().replace("/", ".");
                    name = name.substring(0, name.length() - 6);
                    classNames.add(name);
                }
            }

            if (classNames.contains(className)) {
                result.add(file);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
