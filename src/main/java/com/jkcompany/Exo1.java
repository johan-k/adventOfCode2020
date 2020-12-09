package com.jkcompany;

import java.util.List;
import static com.jkcompany.MethodeGenerique.lectureFichier;

import static java.lang.Integer.parseInt;

class Exo1 {

    static int exo011 ()
    {
        List<String> datas;
        datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle1.txt");
        int a;
        int b;

        for (String data : datas)
        {
            int nb = 1;
            a = parseInt(data);
            for (int i = nb; i < datas.size(); i++)
            {
                b = parseInt((datas.get(i)));
                if ((a + b) == 2020)
                {
                    //System.out.println("a :"+ a+ ", b : "+b+", tot : "+ (a*b));
                    return (a*b);
                }
            }
            nb ++;
        }
        return (-1);
    }

    static int exo012 ()
    {
        List<String> datas;
        datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle1.txt");
        int a;
        int b;
        int c;

        for (String data : datas)
        {
            int nb = 1;
            int nb2 = 2;
            a = parseInt(data);
            for (int i = nb; i < datas.size(); i++)
            {
                b = parseInt((datas.get(i)));
                for (int j = nb2; j< datas.size(); j++)
                {
                    c = parseInt((datas.get(j)));
                    if ((a + b + c) == 2020)
                    {
                        //System.out.println("a :"+ a +", b : "+ b +", c :"+ c +", tot : "+ (a*b*c));
                        return (a*b*c);
                    }
                }

            }
            nb ++;
        }
        return (-1);
    }
}
