package ss8_qlptgt.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeListStringToCSV(String filePath, List<String> list, boolean append) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs(); // tạo thư mục nếu chưa có
        try (FileWriter fw = new FileWriter(file, append);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static List<String> readFileCSV(String filePath) throws IOException {
        List<String> rs = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return rs;
        try (FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) rs.add(line);
            }
        }
        return rs;
    }

    /** Split CSV cơ bản, hỗ trợ trường có ngoặc kép và dấu phẩy */
    // ReadAndWriteFile.java
    public static String[] splitCsvSmart(String line, int expectedCols) {
        if (line == null) return new String[Math.max(0, expectedCols)];

        // Bỏ BOM UTF-8 nếu có
        if (!line.isEmpty() && line.charAt(0) == '\uFEFF') {
            line = line.substring(1);
        }

        java.util.List<String> fields = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQuotes) {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        sb.append('"'); // "" → "
                        i++;
                    } else {
                        inQuotes = false;
                    }
                } else {
                    inQuotes = true;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        fields.add(sb.toString().trim());

        // Bù/trộn cột để đủ expectedCols
        if (expectedCols > 0) {
            if (fields.size() < expectedCols) {
                while (fields.size() < expectedCols) fields.add("");
            } else if (fields.size() > expectedCols) {
                StringBuilder last = new StringBuilder(fields.get(expectedCols - 1));
                for (int i = expectedCols; i < fields.size(); i++) {
                    last.append(',').append(fields.get(i));
                }
                while (fields.size() > expectedCols) fields.remove(fields.size() - 1);
                fields.set(expectedCols - 1, last.toString());
            }
        }

        // Bóc ngoặc kép ngoài và unescape ""
        for (int i = 0; i < fields.size(); i++) {
            String f = fields.get(i);
            if (f.length() >= 2 && f.startsWith("\"") && f.endsWith("\"")) {
                f = f.substring(1, f.length() - 1).replace("\"\"", "\"");
            }
            fields.set(i, f);
        }

        return fields.toArray(new String[0]);
    }



}
