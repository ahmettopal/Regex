
package regex;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Regex 
{
    public static int fonkCount = 0;
    public static void FindFunction(String funcFilter, String funcText) 
    {
        Pattern control = Pattern.compile(funcFilter);
        Matcher match = control.matcher(funcText);

        while (match.find()) 
        {
            if (match.group().length() != 0) 
            {
                fonkCount++;
                System.out.println(fonkCount + ".function = " + match.group().trim());
            }
        }
    }
    
    public static void FindParameter(String paraFilter, String paraText) 
    {
        Pattern kontrol1 = Pattern.compile(paraFilter);
        Matcher match = kontrol1.matcher(paraText);

        while (match.find()) 
        {
            if (match.group().length() != 0) 
            {
                
                System.out.println("Parameters = " + match.group().trim());
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        String Line;
        int Counter = 0;
        int Counter2 = 0;
        int Counter3 = 0;
        int Counter4 = 0;
        
        Scanner read = new Scanner(new File("program.c"));
        while (read.hasNext()) 
        {
            Line = read.nextLine();

            FindFunction("(bool|String|int|void)\\s+[a-zA-Z0-9_.-]\\w++\\(", Line);
            
            if (Line.contains("-=") || Line.contains("+=") || Line.contains("*=") || Line.contains("/=")) 
            {
                    Counter2 = Counter2+2;
            }
            
            if (Line.contains("++") || Line.contains("--") || Line.contains("&&") || Line.contains("||") ||Line.contains("<=") ||Line.contains(">=") || Line.contains("!=") || Line.contains("==")) 
            {
                    Counter3++;
            }
            
            for (int i = 0; i < Line.length(); i++) 
            {   
                if (Line.charAt(i) == '=') 
                {
                    if (Line.charAt(i-1) == '=') 
                    {
                        
                    }
                    else
                    {
                        Counter++;
                    }
                }
                
                if (Line.charAt(i) == '+' || Line.charAt(i) == '-' || Line.charAt(i) == '*' || Line.charAt(i) == '<' || Line.charAt(i) == '>' || Line.charAt(i) == '/') 
                {
                    if (Line.charAt(i-1) == '+' ||Line.charAt(i-1) == '-' )
                    {
                        
                    }
                    else
                    {   
                        Counter4++;
                    }
                }
            }
            FindParameter("\\(+(bool|string|int|void|double)\\s+.+",Line);
        }
    }
}
