package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegularExpression {
    String text;
    String REPLACE = " * ";
    Pattern pattern = Pattern.compile("(\\d)\\1");

    public void inputText(String str){
        if (str.charAt(str.length() - 1) != ' ')
            str += ' ';
        text = str;
    }

    public String ghetText(){return text;}

    public void changeNum(){
        Matcher m = pattern.matcher(text);
        text = m.replaceAll(REPLACE);
    }
}
