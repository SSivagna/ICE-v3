package demo.security;

import java.util.ArrayList;
import java.util.List;

public class Authenticator 
{  
    private static final List<String> list = new ArrayList<String>();
    
    static { list.add("secret");}
    
    public static boolean validate(String password)
    {
        String validUserPassword = list.get(0);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}