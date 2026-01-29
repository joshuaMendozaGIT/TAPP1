package org.example;

import java.util.Scanner;

public class Main {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int precio = 0;
            int totalIngresados = 0;
            int moneda;

            String producto;
            System.out.println("Producto A $270");
            System.out.println("Producto B $340");
            System.out.println("Producto C $390");

            System.out.println("Elija un producto");
            producto = sc.nextLine();

            switch (producto) {
                case "a":
                    precio = 270;
                    break;
                case "b":
                    precio = 340;
                    break;
                case "c":
                    precio = 390;
                    break;

            }


        }

    }
