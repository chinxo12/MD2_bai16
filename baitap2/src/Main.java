import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        displayData(readDataformFile("Country"));
    }

    public static List<String> readDataformFile(String path) {
        List<String> list = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return list;
    }

    public static void displayData(List<String> list) {
        for (String str : list) {
            String[] arrstr = str.split(",");
            System.out.println(
                    "Country [id= "
                            + arrstr[0]
                            + ", code= " + arrstr[1]
                            + " , name=" + arrstr[2]
                            + "]");
        }
    }
}