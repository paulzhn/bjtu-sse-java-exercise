package exercise1;

import java.io.*;


public class TestLineNumbering {
    public static void main(String[] args) throws IOException{
        File f = new File(args[0]);
        FileWriter writer = new FileWriter(f);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 1; ; i++) {
            String line = br.readLine();
            if(line.isEmpty() || line == null) {
                break;
            }
            writer.write(i + " " + line + "\n");
        }
        writer.close();

    }
}
