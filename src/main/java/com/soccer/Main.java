package com.soccer;

import com.soccer.view.viewCoach;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;

import com.soccer.util.ConsoleUtils;

public class Main {

    public static void main(String[] args) {
        
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();
        Controller ctrlDoctor = new Controller();
        Controller ctrlCoach = new Controller();

        viewTeam.controlador = ctrlTeams;
        viewPlayer.controlador = ctrlPlayers;
        viewDoctor.controlador = ctrlDoctor;
        viewCoach.controlador = ctrlCoach;

        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewDoctor vd = new viewDoctor();
        viewCoach vc = new viewCoach();

        int opcion = 0;

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("""
                Menu de gestion de la liga betplay

                Opciones: 
                1. Equipos  
                2. Jugadores 
                3. Doctores 
                4. Entrenadores
                5. Salir
                """);
                System.out.print("Ingrese una opción: ");

            opcion = ConsoleUtils.verificarEntradaInt(1, 5);

            switch (opcion) {
                case 1:
                    vt.start();
                    break;
                case 2:
                    vp.start();
                    break;
                case 3:
                    vd.start();
                    break;
                case 4:
                    vc.start();
                    break;
                case 5:
                    return;
            }
        }
    }
}
