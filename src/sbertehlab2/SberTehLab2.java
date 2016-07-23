/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbertehlab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author таня
 */
public class SberTehLab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String encoding = sc.nextLine();
        ReaderFile rf = new ReaderFile(path, encoding);
        rf.parserFile();
    }
}
