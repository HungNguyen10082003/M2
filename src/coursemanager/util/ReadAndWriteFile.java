package coursemanager.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            File f = new File(path);
            if (!f.exists()) return list;
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) if (!line.trim().isEmpty()) list.add(line);
            br.close();
        } catch (IOException e) { e.printStackTrace(); }
        return list;
    }

    public static void writeFile(String path, List<String> lines, boolean append) {
        try {
            File f = new File(path);
            File parent = f.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, append));
            for (String s : lines) { bw.write(s); bw.newLine(); }
            bw.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}