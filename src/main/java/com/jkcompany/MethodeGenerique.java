package com.jkcompany;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MethodeGenerique {

    static List<String> lectureFichier (String path)
    {
        List<String> data = new ArrayList<String>();
        BufferedReader br;
        String strLine;
        try {
            br = new BufferedReader( new
                    FileReader(path));
            while( (strLine = br.readLine()) != null) {
                data.add(strLine);

                //System.out.println("toto : " + strLine);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }

        return data;
    }

    static int recurrence(String mot, char car)
    {
        int count = 0;
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == car) {
                count++;
            }
        }
        return count;
    }
}
