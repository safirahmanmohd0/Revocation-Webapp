/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.revocation;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Praveen
 */
public class KeyGenerator {

    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {        
        String key=new BigInteger(32, random).toString(32);        
        return key;
    }
   
    
    
}
