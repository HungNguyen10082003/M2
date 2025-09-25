package employ_manager.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) return list;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(String path, List<String> data, boolean append) {
        try {
            File f = new File(path);
            File parent = f.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            FileWriter fw = new FileWriter(f, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : data) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
