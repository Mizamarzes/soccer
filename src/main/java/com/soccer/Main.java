package com.soccer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.soccer.view.viewCoach;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewTeam;
import com.soccer.view.viewPlayer;

import com.soccer.util.ConsoleUtils;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Controller ctrlTeams = new Controller();
         Controller ctrlPlayers = new Controller();
        // Controller ctrlDoctor = new Controller();
        // Controller ctrlCoach = new Controller();

        viewTeam.controlador = ctrlTeams;
        viewPlayer.controlador = ctrlPlayers;
        // viewDoctor.controlador = ctrlCoach;
        // viewCoach.controlador = ctrlCoach;

        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        // viewDoctor vd = new viewDoctor();
        // viewCoach vc = new viewCoach();

        int opcion = 0;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("""

            Menu de gestion de la liga betplay

            Opciones: 
            1. Equipos  
            2. Jugadores 
            3. Masajistas 
            4. Entrenadores
            5. Salir
            """);

            try {
                opcion = sc.nextInt();
                sc.nextLine(); 
                if (opcion >= 1 && opcion <= 5) {
                    break; 
                } else {
                    System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                sc.nextLine(); 
            }
        }

        switch (opcion) {
            case 1:
                vt.start();
                break;
            case 2:
                vp.start();
                break;
            case 3:
                // vd.start();
                break;
            case 4:
                // vc.start();
                break;
            case 5:
                sc.close();
        }
    }
}



