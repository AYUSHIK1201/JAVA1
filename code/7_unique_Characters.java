/*
Write a Java program to print the unique characters present in the given string in the same sequence as they appear(the first occurrence) in the input.

Condition
All the characters should be in lowercase only.

*/
//==============================================================================================================================================
//==============================================================================================================================================

package javacode;
import java.util.*;

public class myclass{
    public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         sc.close();
         input = input.toLowerCase();
         String temp = "";
         for(int i =0;i<input.length();i++){
             if(!temp.contains(Character.toString(input.charAt(i)))){
                 temp = temp+input.charAt(i);
             }
         }
         System.out.println(temp);
    }
}

//==============================================================================================================================================
//==============================================================================================================================================

/*

Input==>
xperience

Output==>
xperinc

*/