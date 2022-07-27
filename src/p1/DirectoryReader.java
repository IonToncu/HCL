package p1;

import java.io.File;

public class DirectoryReader {
    public static void main(String[] args) {
        printContent("C:\\Projects\\untitled1", "");
    }
    public static void printContent(String pathname, String tabs){
        File[] files;

        File f = new File(pathname);

        files = f.listFiles();

        for (File file : files) {
            if(file.isDirectory()){
                System.out.println(tabs + "Directory:" + file.getName());
                printContent(pathname + "\\" + file.getName(), tabs +"\t");
            }else{
                System.out.println("File:" + file.getName());
            }
        }
    }
}
