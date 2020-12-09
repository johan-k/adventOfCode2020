package com.jkcompany;

import java.util.List;

import static com.jkcompany.MethodeGenerique.lectureFichier;

class Exo3 {

    static int Exo031(){
        List<String> datas;
        datas = lectureFichier("C:\\Users\\jojod\\Documents\\Advent of code\\2020\\AventOfCode2020\\src\\puzzle3.txt");

        // x et y sont les maxs, ligne et colonne sont les curseurs
        int y;
        int x;
        y = datas.size();
        x = datas.get(0).length();
        int nbArbre = 0;

        char[][] tabLigneColonne;
        tabLigneColonne = creationPlateau(datas);
        int moveRight = 3;
        int moveBottom = 1;

        nbArbre = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);

        return (nbArbre);
    }

    static int Exo032(){
        List<String> datas;
        datas = lectureFichier("C:\\Users\\jojod\\Documents\\Advent of code\\2020\\AventOfCode2020\\src\\puzzle3.txt");

        // x et y sont les maxs, ligne et colonne sont les curseurs
        int y, colonne;
        int x, ligne = 0;
        y = datas.size();
        x = datas.get(0).length();
        Boolean arbre;
        int nbArbre1 = 0;
        int nbArbre2 = 0;
        int nbArbre3 = 0;
        int nbArbre4 = 0;
        int nbArbre5 = 0;

        char[][] tabLigneColonne;
        tabLigneColonne = creationPlateau(datas);


        int moveRight = 1;
        int moveBottom = 1;
        nbArbre1 = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);
        moveRight = 3;
        moveBottom = 1;
        nbArbre2 = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);
        moveRight = 5;
        moveBottom = 1;
        nbArbre3 = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);
        moveRight = 7;
        moveBottom = 1;
        nbArbre4 = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);
        moveRight = 1;
        moveBottom = 2;
        nbArbre5 = countArbre(tabLigneColonne, moveRight, moveBottom, x, y);

        return (nbArbre1*nbArbre2*nbArbre3*nbArbre4*nbArbre5);
    }



    static char[][] creationPlateau(List<String> list)
    {
        int tailleLongueurY;
        int tailleStringX;
        tailleLongueurY = list.size();
        tailleStringX = list.get(0).length();
        int i=0;

        //System.out.println("x :" +tailleStringX+", y :"+tailleLongueurY);
        char[][] plateau ; //ligne puis colonne
        plateau = new char[tailleStringX][tailleLongueurY];

        for (String element : list){
            for (int j=0; j < tailleStringX; j++)
            {
                plateau[j][i] = element.charAt(j);
            }
            i++;
        }

        return plateau;
    }

    static int countArbre( char[][]plaine, int deplaceD, int deplaceB, int maxX, int maxY )
    {
        int nbArbre = 0;
        int ligne = 0;
        boolean arbre;
        for (int colonne = 0; colonne < maxY-1;)
        {
            ligne = (ligne + deplaceD)%maxX;
            colonne= colonne+deplaceB;
            if (colonne < maxY){
                arbre = plaine[ligne][colonne] == '#';
                if (arbre)
                {
                    nbArbre++;
                }
            }
            //System.out.println("score : "+nbArbre+ " [x][y] : ["+ligne+"]["+colonne+"], arbre? : "+arbre);
        }
        //System.out.println("table.length : " + tabLigneColonne.length);
        return nbArbre;
    }
}
