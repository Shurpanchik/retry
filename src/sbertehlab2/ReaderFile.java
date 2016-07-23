/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbertehlab2;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.print.DocFlavor;
import sun.swing.FilePane;

/**
 *
 * @author таня
 */
public class ReaderFile {

    private String path;
    private BufferedReader bufRead;    

    public ReaderFile(String path, String encoding) throws IOException {
        this.path = path;
        this.bufRead = Files.newBufferedReader(Paths.get(path), Charset.forName(encoding));
    }

    void parserFile() throws IOException, ParseException {
        StringBuilder StringBuilder = new StringBuilder();
        String s = bufRead.readLine();
        while (s != null) {
            if (parseString(path.substring(path.lastIndexOf(".")), s)) {
                StringBuilder.append("\n");
                StringBuilder.append(s);
            } else {
                return;
            }
            s = bufRead.readLine();
        }
        System.out.println(StringBuilder);
    }

    private boolean parseString(String ext, String st) throws ParseException, ExceptionExtend, NumberFormatException, ExceptionFormat {
        try {
            if (ext.equals(".ext1")) {
                return PatternExtends.schema1(st);
            }
            if (ext.equals(".ext2")) {
                return PatternExtends.schema2(st);
            }
            throw new ExceptionExtend("Данное расширение не поддерживается системой");
        } catch (ExceptionExtend e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
