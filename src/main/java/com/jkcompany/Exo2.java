package com.jkcompany;

import java.util.List;

import static com.jkcompany.MethodeGenerique.recurrence;
import static com.jkcompany.MethodeGenerique.lectureFichier;
import static java.lang.Integer.parseInt;

class Exo2 {
    static int exo021 ()
    {
        List<String> datas;
        datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle2.txt");
        String[] parts;
        String password, tmp;
        int val1, val2;
        char carVerif;
        int countPassword = 0;
        long recurrence;

        for (String data : datas)
        {
            parts = data.split(":");
            password = parts[1];
            tmp = parts[0];
            parts = tmp.split("-");
            val1 = parseInt(parts[0]);
            tmp = parts[1];
            parts = tmp.split(" ");
            val2 = parseInt(parts[0]);
            carVerif = parts[1].charAt(0);
            //System.out.println("val1 : "+ val1 +", val2 : "+ val2 +", carVerif :"+ carVerif +", password : "+ password);

            recurrence = recurrence(password, carVerif);
            if (recurrence >= val1 && recurrence <= val2)
            {
                countPassword++;
            }
        }
        return (countPassword);
    }

    static int exo022 ()
    {
        List<String> datas;
        datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle2.txt");
        String[] parts;
        String password, tmp;
        int val1, val2;
        char carVerif;
        int countPassword = 0;

        for (String data : datas)
        {
            parts = data.split(":");
            password = parts[1];
            tmp = parts[0];
            parts = tmp.split("-");
            val1 = parseInt(parts[0]);
            tmp = parts[1];
            parts = tmp.split(" ");
            val2 = parseInt(parts[0]);
            carVerif = parts[1].charAt(0);
            //System.out.println("val1 : "+ val1 +", val2 : "+ val2 +", carVerif :"+ carVerif +", password : "+ password);

            // la regle compte 1 le premier caractère et pas 0, mais comme on commence par un espace,
            // on ne fait pas de val--

            if (password.charAt(val1) == carVerif ^ password.charAt(val2) == carVerif)
            {
                countPassword++;
            }
        }
        return (countPassword);
    }
}
