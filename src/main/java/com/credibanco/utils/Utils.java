package com.credibanco.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
public class Utils {

    public static Integer getNumber(){
        return number();
    }

    public static  String getReplaceChar(String str){
        return replaceChar(str);
    }
    private static Integer number(){
        Random r = new Random();
        return  r.nextInt(101);
    }

    private static String replaceChar(String str) {
        char ch ='*';
        int index =5;
        int ln = str.length();

        StringBuilder myString = new StringBuilder(str);
        for(int i=6; i<ln-4; i++){
            myString.setCharAt(i, ch);
        }
        return myString.toString();
    }
}
