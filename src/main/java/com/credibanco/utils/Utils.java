package com.credibanco.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@AllArgsConstructor
public class Utils {

    public static Integer getNumber(){
        return number();
    }

    public static  String getReplaceChar(String str){
        return replaceChar(str);
    }
    public static Long getMinutes(Date inicio, Date fin){
        return  minutes(inicio,fin);
    }

    private static Integer number(){
        Random r = new Random();
        return  r.nextInt(101);
    }

    private static String replaceChar(String str) {
        char ch ='*';
        int ln = str.length();

        StringBuilder myString = new StringBuilder(str);
        for(int i=6; i<ln-4; i++){
            myString.setCharAt(i, ch);
        }
        return myString.toString();
    }

    private static Long minutes(Date inicio, Date fin){
        long value = fin.getTime()-inicio.getTime();
        long difference_In_Minutes
                = (value
                / (1000 * 60))
                % 60;
        return difference_In_Minutes;
    }
}
