package utils.errorlogging;

import java.util.Map;

/**
 * Created by Adam And Lauren on 6/6/2015.
 */
public class ErrorLogging
{
    public static void log(String functionName, Map<String, Object> inputs, Exception e){
        System.out.println(functionName + " Failed with input of: ");
        for (Map.Entry<String, Object> entry : inputs.entrySet())
        {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(e.getLocalizedMessage());
        System.out.println(e.getMessage());
        for (int i = 0; e.getStackTrace().length > i; i++) {
            System.out.println(e.getStackTrace()[i].toString());
        }
    }
}
