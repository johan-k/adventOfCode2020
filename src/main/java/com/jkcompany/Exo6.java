package com.jkcompany;

import java.util.*;

import static com.jkcompany.MethodeGenerique.lectureFichier;
import static java.lang.Integer.parseInt;

// entrée : le doc
// sortie : somme des nombres de lettre "unique" par groupe;
// au mileiu; clé valeur à init

public class Exo6 {
    public static final List<String> datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle6.txt");; // donnée d'entrée
    //datas = lectureFichier ("C:/Users/Utilisateur/Documents/git/adventOfCode2020/src/puzzle6.txt");
    static int Exo061(){

        HashSet<Character> repYes = new HashSet<>();
        int score = 0;

        for (String data:datas
             ) {
            if (data.isEmpty())
            {
                score += repYes.size();
                repYes.clear();
            }
            else
            {
                for (char rep : data.toCharArray()
                     ) {
                    repYes.add(rep);
                }
            }
        }
        score += repYes.size();

        return score;
    }


    static int Exo062(){
        HashMap<Character, Integer> repYes = new HashMap();
        int score = 0;
        int scoreIntermediaire;
        int nombrePersonne = 0;

        for (String data:datas
        ) {
            if (data.isEmpty())
            {
                scoreIntermediaire = nbElementTousOk(repYes, nombrePersonne);
                score += scoreIntermediaire;
                repYes.clear();
                nombrePersonne = 0;
            }
            else
            {
                for (char rep : data.toCharArray()
                ) {
                    if (repYes.containsKey(rep))
                    {
                        scoreIntermediaire = repYes.get(rep);
                        repYes.put(rep, scoreIntermediaire+1);
                    } else {
                        repYes.put(rep, 1);
                    }
                }
                nombrePersonne++;
            }
        }
        scoreIntermediaire = nbElementTousOk(repYes, nombrePersonne);
        score += scoreIntermediaire;

        return score;
    }

    private static int nbElementTousOk(HashMap<Character, Integer> mp, int nb) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (parseInt(pair.getValue().toString()) != nb)
            {
                it.remove();
            }
        }
        return mp.size();
    }
}
