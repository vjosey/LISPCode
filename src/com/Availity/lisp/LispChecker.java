package com.Availity.lisp;

import java.util.Scanner;
import java.util.logging.Logger;

public class LispChecker {

    private final static Logger LOGGER = Logger.getLogger(LispChecker.class.getName());

    public static void main(String arg[])
    {
         Scanner scan = new Scanner(System.in);
         String code = scan.next();

         System.out.println(checker(code));

    }


    private static boolean checker(String text)
    {
        boolean value = false;
        int openParentheses= 0;
        int endParentheses= 0;
        int pairs = 0;

        char[] chars = text.toCharArray();

        for(char c : chars )
        {
            if(c == '(')
            {
                openParentheses++;
            }

            if( c == ')'){
                endParentheses++;
            }

            if(c == ')' &&  openParentheses == 0)
            {
                value = false;
            } else if(c == ')' && openParentheses != 0 )
            {
               openParentheses--;
               endParentheses--;
               pairs++;
            }
        }

        if(openParentheses == 0 && endParentheses == 0)
        {
            value = true;
        }

        if(value == false)
        {
            LOGGER.warning(String.format("Missing %s open Parentheses and %s ending Parentheses! %s pairs in total.",openParentheses,endParentheses,pairs));
        }
        return value;
    }




}
