package com.ciandt.feedfront.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LimparRepositorio {
    public static void limparRepositorio(String path) throws IOException {
        Files.walk(Paths.get(path))
                .filter(p -> p.toString().endsWith(".byte"))
                .forEach(p -> {
                    new File(p.toString()).delete();
                });
    }
}
