import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listChar = list("D:\\MD 2\\bai 16\\baitap1\\sourceFile.txt");
        for (int i = 0; i < listChar.size(); i++) {
            System.out.println(listChar.get(i));
        }
        int sum = 0;
        for (String str:listChar ) {
            sum += str.length();
        }
        System.out.println("Tong so ky tu la " + sum);
        copyFile(listChar,"D:\\MD 2\\bai 16\\baitap1\\targetFile");
    }

    public static List<String> list(String path) {
        List<String> list = new ArrayList<>();
        File file = null;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            file = new File(path);
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line =bufferedReader.readLine())!=null){
                list.add(line);
            }
        } catch (FileNotFoundException ex1) {
           ex1.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return list;
    }
    public static void copyFile (List<String> list ,String path){
        File file = null;
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (String str :list) {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }

                if (outputStreamWriter!=null){
                    outputStreamWriter.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}