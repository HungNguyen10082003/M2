package cm.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {


    public static String[] parseCsvLine(String line) {
        if (line == null) return new String[0];
        List<String> cols = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (inQuotes) {
                if (ch == '"') {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        cur.append('"'); i++;
                    } else {
                        inQuotes = false;
                    }
                } else {
                    cur.append(ch);
                }
            } else {
                if (ch == '"') inQuotes = true;
                else if (ch == ',') { cols.add(cur.toString()); cur.setLength(0); }
                else cur.append(ch);
            }
        }
        cols.add(cur.toString());
        return cols.toArray(new String[0]);
    }


    public static List<String> readAllLines(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) return new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
    public static void writeAllLinesAtomic(String path, List<String> lines) throws IOException {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) parent.mkdirs();

        File tmp = new File(path + ".tmp");
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(tmp), StandardCharsets.UTF_8))) {
            for (String l : lines) {
                bw.write(l == null ? "" : l);
                bw.newLine();
            }
        }
        if (file.exists()) Files.delete(file.toPath());
        if (!tmp.renameTo(file)) {
            try (InputStream in = new FileInputStream(tmp);
                 OutputStream out = new FileOutputStream(file)) {
                in.transferTo(out);
            }
            tmp.delete();
        }
    }

    public static String toCsvLine(String[] columns) {
        if (columns == null || columns.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            String value = columns[i];
            if (value == null) {
                value = "";
            }
            if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
                value = value.replace("\"", "\"\""); // escape dấu "
                value = "\"" + value + "\"";        // bao quanh bằng dấu "
            }
            sb.append(value);
            if (i < columns.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
