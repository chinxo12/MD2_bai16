package ra;

import java.io.*;

import static java.awt.SystemColor.text;

public class ReadFileExample {
    public static void readFileText(String path) {
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isw = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isw = new InputStreamReader(fis);
            br = new BufferedReader(isw);
            System.out.println("Du lieu trong file");
            String line = br.readLine();
            int sum=0;
            while ((line = br.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            System.out.println("Tong = " + sum);


        } catch (RuntimeException ex1) {
            ex1.printStackTrace();
        } catch (FileNotFoundException ex2) {
            System.err.println("file trống!!!");
        } catch (IOException ex3) {
            throw new RuntimeException(ex3);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (isw != null) {
                    isw.close();
                }
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        readFileText("test.txt");
    }


}

