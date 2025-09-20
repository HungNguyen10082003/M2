package em.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCsv {
    private final Path path;

    public ReadWriteCsv(String filePath) {
        this.path = Paths.get(filePath);
    }

    public void ensureFileExistsWithHeader(String header) {
        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            if (Files.notExists(path)) {
                Files.write(path, (header + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE);
            } else {
                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                if (lines.isEmpty() || !lines.get(0).equals(header)) {
                    lines.add(0, header);
                    Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Không thể chạy file csv: " + e.getMessage(), e);
        }
    }

    public List<String> readAllLinesSkipHeader() {
        try {
            if (Files.notExists(path)) return new ArrayList<>();
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (!lines.isEmpty()) lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Lỗi đọc file: " + e.getMessage(), e);
        }
    }

    public void writeAllWithHeader(String header, List<String> bodyLines) {
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
            bw.write(header);
            bw.newLine();
            for (String line : bodyLines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Lỗi ghi file: " + e.getMessage(), e);
        }
    }
}
