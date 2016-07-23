/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbertehlab2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author таня
 */
public class PatternExtends {
    
    static boolean schema1(String st) throws ExceptionFormat {
        try {
            st = st.trim();
            if (parseComment(st)) {
                return true;
            }
            String[] splitofVerticalLine = st.split("\\|");
            parseHouse(splitofVerticalLine[4]);
            parseFlat(splitofVerticalLine[5]);
            parseDate(splitofVerticalLine[6]);
            return true;
        } catch (ExceptionFormat e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    static boolean schema2(String st) throws ExceptionFormat {
        try {
            st = st.trim();
            if (parseComment(st)) {
                return true;
            }
            if (!st.substring(55, 56).equals(" ") || !st.substring(34, 35).equals(" ")) {
                throw new ExceptionFormat("Неверный формат данных (выход за границы столбца)");
            }
            parseDate(st.substring(56, 66));
            return true;
        } catch (ExceptionFormat pe) {
            System.out.println(pe.getMessage());
            return false;
        }
    }

    static boolean parseComment(String st) {
        if (st.isEmpty() || st.charAt(0) == '#') {
            return true;
        }        
        return false;
    }

    static boolean parseHouse(String house) throws ExceptionFormat {
        try {
            if (house.equals("")) {
                return true;
            }
            Integer.parseInt(house.substring(0, house.length() - 1));
            return true;
        } catch (NumberFormatException e) {
            throw new ExceptionFormat("Недопустимые символы в поле дом " + house);
        }
        
    }
    
    static boolean parseFlat(String flat) throws ExceptionFormat {
        try {
            if (flat.equals("")) {
                return true;
            }
            Integer.parseInt(flat);
            return true;
        } catch (NumberFormatException e) {
            throw new ExceptionFormat("Недопустимые символы в поле квартира " + flat);
        }
        
    }
    
    static boolean parseDate(String date) throws ExceptionFormat {
        try {
            if (date.equals("")) {
                return true;
            }
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
            Date valueOf = formatDate.parse(date);
            return true;
        } catch (ParseException e) {
            throw new ExceptionFormat("Неверный формат даты " + date);
        }
    }
}
