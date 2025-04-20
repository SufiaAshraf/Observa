package com.observa.util;

import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PromptLoader {

    /**
     * Loads a prompt template file from the /resources/prompts/ directory.
     *
     * @param filename The name of the file (e.g., "SingleLogPrompt.txt")
     * @return String content of the prompt template
     */
    public static String load(String filename) {
        String path = "/prompts/" + filename;

        try (InputStream inputStream = PromptLoader.class.getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Prompt file not found: " + path);
            }
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
                return scanner.useDelimiter("\\A").next();  // Reads full file content
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load prompt file: " + path, e);
        }
    }
}
