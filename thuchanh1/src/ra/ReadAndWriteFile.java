package ra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public static   List<Integer>  readFile(String path){
        List<Integer> integerList = new ArrayList<>();
        File file = null;
        FileInputStream  fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine())!=null){
                integerList.add(Integer.parseInt(line));
            }

        }catch (Exception ex1){

        }finally {
            try {
                if (fis!=null){
                    fis.close();
                }
                if (isr!=null){
                    isr.close();
                }
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return integerList;
    }
    public static void writeFile (String path, int max){
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Gia tri lon nhat la " + max + "\n");
            do {
                System.out.println("Nhap them 1 dong");
                int number = Integer.parseInt(scanner.nextLine()) ;
                bufferedWriter.write(number + "\n");
                System.out.println("Ban muon nhap tiep khong?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                String choice = scanner.nextLine();
                if (!choice.equals("1")){
                    break;
                }
            }while (true);

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (bufferedWriter!=null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    public static int findMax (List<Integer> listNumber ){
        int max = listNumber.get(0);
        for (Integer number :listNumber) {
            if (number>max){
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> number =  readFile("test.txt");
        int maxValue =  findMax(number);
        writeFile("test.txt",maxValue);
//        writeIntToFile(scanner,"test.txt");

    }
    public static void writeIntToFile (Scanner scanner,String path){
        FileWriter fileWriter = null;
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path,true);
            fileOutputStream = new FileOutputStream(String.valueOf(fileWriter));
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            do {
                System.out.println("Nhap mot so");
                int number = Integer.parseInt(scanner.nextLine());
                bufferedWriter.write(number);
                bufferedWriter.flush();
                bufferedWriter.newLine();
                System.out.println("Ban muon nhap tiep khong?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                String choice = scanner.nextLine();
                if (!choice.equals("1")){
                    break;
                }
            }while (true);


        } catch (IOException ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
                if (outputStreamWriter!=null){
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
