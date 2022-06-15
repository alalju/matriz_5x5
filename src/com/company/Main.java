package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz1 = new int[5][5];
        int op = 1;
        int op1;
        System.out.println("Ingrese los elementos de la matriz: ");
        matriz1=llenarMatriz(matriz1);
        mostrarMatriz(matriz1);
        while (op != 2) {
            System.out.println("1. Media de la matriz \t 2. Número mayor \t 3. Números primos \t 4. Números pares");
            System.out.println("5. Suma de la diagonal");
            op1 = scanner.nextInt();
            switch (op1) {
                case 1:
                    float media=0;
                    mostrarMatriz(matriz1);
                    media=media(matriz1);
                    System.out.println("La media de la matriz es: "+media);
                    break;
                case 2:
                    int mayor= mayor(matriz1);
                    repetirMayor(mayor,matriz1);
                    repetirMayor(mayor,matriz1);
                    break;
                case 3:
                    primo(matriz1);
                    break;
                case 4:
                    par(matriz1);
                    break;
                case 5:
                    int sumaD=0;
                    mostrarMatriz(matriz1);
                    sumaD=sumarDiagonalP(matriz1);
                    System.out.println("La suma de la digonal es: "+sumaD );
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
            System.out.println("¿Desea continuar?: 1-si 2-no");
            op= scanner.nextInt();
        }






    }
    public static int[][] llenarMatriz(int [][]matriz){
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<matriz.length;i++){
            for(int j=0; j< matriz.length;j++){
                System.out.println("Ingrese el elemento [" +i+ "][" +j +"]");
                int elemento=scanner.nextInt();
                matriz[i][j]=elemento;
            }
        }
        return matriz;
    }
    public static void mostrarMatriz(int [][]matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0; j< matriz.length;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int sumarDiagonalP(int matriz[][]){
        int principal = 0;
        for (int i=0; i<4; i++) {
            principal = principal+matriz[i][i];
        }
        return principal;
    }
    public static float media(int matriz[][]){
        float media=0;
        int suma=0;

        for(int i=0;i<matriz.length;i++){
            for(int j=0;i<matriz.length;i++){
                suma=suma+matriz[i][j];
            }
        }

        media=suma/ (matriz.length* matriz[0].length);

        return media;
    }

    public static int mayor(int [][]matriz){
        int mayor=matriz[0][0];

        for(int i=0;i<matriz.length;i++){
            for (int j=0;j< matriz.length;j++){
                if( matriz[i][j]>=mayor){
                    mayor=matriz[i][j];
                }
            }
        }
        return mayor;

    }
    public static void repetirMayor(int mayor,int matriz[][]){
        int rep=0;
        for(int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if( matriz[i][j]==mayor){
                    rep++;
                }
            }
        }
        System.out.println("El número "+mayor+" se repite"+rep);
    }
    public static void primo(int matriz[][]){

        int divisores = 0;
        for(int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                for(int n=1; n<matriz[i][j]; n++){
                    int residuo=matriz[i][j]%n;
                    if(residuo==0){
                        divisores++;
                    }
                }
                if(divisores==2){
                    System.out.println("Num primo: " +matriz[i][j]);
                }
                divisores=0;
            }

        }
    }
    public static void par(int matriz[][]){
        for(int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if( matriz[i][j]%2==0){
                    System.out.println(matriz[i][j]);
                }
            }
        }
    }
}
