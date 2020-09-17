package com.zubrmobile.censure.service;

import com.zubrmobile.censure.constant.Constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class CensureServiceImpl implements CensureService {

    @Override
    public String censure(String text) {
        return getCensured(text, Constants.abuses);
    }

    private static String getCensured(String text, String[] abuses) {
        for (String ab : abuses) {
            text = censure(text, ab);
        }
        return text;
    }

    private static String censure(String text, String abuse) {
        ArrayList<String> abuseVarieties = getWordVarieties(abuse);
        if (abuse.length() > text.length()) {
            return text;
        }
        for (String variety : abuseVarieties) {
            while (text.toLowerCase().contains(variety.toLowerCase())) {
                int index = text.toUpperCase().indexOf(variety.toUpperCase());
                for (int i = index; i < index + abuse.length(); i++) {
                    text = replaceCharAt(text, i, '*');
                }
            }
        }
        return text;
    }

    private static ArrayList<String> getWordVarieties(String word) {
        ArrayList<String> wordVarieties = new ArrayList<>();
        wordVarieties.add(word);
        for (Map.Entry<String, String> symbolSet : Constants.symbols.entrySet()) {
            for (int i = 0; i < wordVarieties.size(); i++) {
                if (wordVarieties.get(i).toLowerCase().contains(symbolSet.getKey())) {
                    wordVarieties.add(wordVarieties.get(i).replaceAll("(?i)" + symbolSet.getKey(), symbolSet.getValue()));
                }
            }
        }
        return wordVarieties;
    }

    private static String replaceCharAt(String text, int pos, char replacement) {
        return text.substring(0, pos) + replacement + text.substring(pos + 1);
    }
}
