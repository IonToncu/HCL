import java.util.HashMap;
import java.util.Map;

public class MainExecution {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();
        String cityCodes[] = service.getEmployeeCityCode();
        String codes[] = service.getEmployeeCodes();

        Map<String, String> cityCode = new HashMap<>();
        cityCode.put("011", "Delhi");
        cityCode.put("022", "Mumbai");
        cityCode.put("080", "Banglore");
        cityCode.put("020", "Pune");

        for(int i = 0; i < codes.length; i++)
            System.out.println( codes[i] +  " : " + cityCode.get(cityCodes[i]));

        }


}//end main


