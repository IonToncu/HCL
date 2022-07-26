package p2;

import java.util.HashMap;
import java.util.Map;

public class EmailFilters {
    public static void main(String[] args) {
        String emails[] = {
                "ramesh@gmail.com",
                "rakesh@outlook.com",
                "lokesh@linkedin.com",
                "mahesh@gmail.com",
                "ganesh@gmail.com",
                "rajesh@outlook.com"
        };
        Map<String, Integer> domains = new HashMap<>();
        for(int i = 0; i < emails.length; i++){
            String s = emails[i].substring(emails[i].indexOf("@") + 1);
            s = s.substring(0, s.indexOf("."));
            if(!domains.containsKey(s)){
                domains.put(s, 1);
            }else{
                domains.put(s, domains.get(s) + 1);
            }
        }

        System.out.println(domains);

    }
}
