package p2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVFileReader {
    static String line = "";
    static String splitBy = ",";

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<>();

//        Scanner sc = new Scanner(new File("Repo/mapdemo.csv"));
//        sc.useDelimiter(",");
//        while (sc.hasNext()){
//            System.out.print(sc.next() + ": " + sc.next());
//        }
//        sc.close();
        BufferedReader br = new BufferedReader(new FileReader("Repo/mapdemo.csv"));

        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] str = line.split(splitBy);    // use comma as separator
           // System.out.println(str[0] + ":" + str[1]);

            try {
                int index = Integer.parseInt(str[0]);
                if(!map.containsKey(index)){
                    map.put(index, Integer.parseInt(str[1]));
                }else{
                    map.put(index, Integer.parseInt(str[1]) + map.get(index));
                }

            } catch(NumberFormatException e){
                //System.out.println(str[0]);
            }
        }
        System.out.println(map);
    }
}

