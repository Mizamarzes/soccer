package com.soccer.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.entity.Coach;
import com.soccer.entity.Doctor;
import com.soccer.entity.Player;
import com.soccer.entity.Team;

import com.soccer.util.ConsoleUtils;

public class viewTeam {
    public static Controller controlador;
    
    public void start() {
        ConsoleUtils.clearScreen();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");

            int choice = sc.nextInt();
            sc.nextLine(); 

            Team equipo = new Team();

            ArrayList<Player> jugadores = new ArrayList<>();
            ArrayList<Coach> entrenadores = new ArrayList<>();
            ArrayList<Doctor> masajistas = new ArrayList<>();

            switch (choice) {
                case 1:
                    String codigoEquipo = null;

                    ConsoleUtils.clearScreen();
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = sc.nextLine();

                    ConsoleUtils.clearScreen();
                    System.out.println("Ingrese Nombre del equipo :");
                    equipo.setNombre(sc.nextLine());

                    ConsoleUtils.clearScreen();
                    System.out.println("Ingrese la ciudad :");
                    equipo.setCiudad(sc.nextLine());

                    do {
                        ConsoleUtils.clearScreen();
                        System.out.println("Ingrese el ID del jugador: ");
                        int idJugador = sc.nextInt();
                        Player jugador = new Player();
                        jugador.setId(idJugador);
                        jugadores.add(jugador);

                        ConsoleUtils.clearScreen();
                        System.out.println("¿Quieres agregar otro jugador? \n 1. Si \n 2. No");
                        int opcion = sc.nextInt();
                        if (opcion == 2) {
                            break;
                        }
                        sc.nextLine();
                    } while (true); 

                    equipo.setListJugadores(jugadores);
                    
                    do {
                        ConsoleUtils.clearScreen();
                        System.out.println("Ingrese el ID del instructor");
                        int idEntrenador = sc.nextInt();
                        Coach entrenador = new Coach();
                        entrenador.setId(idEntrenador);
                        entrenadores.add(entrenador);

                        ConsoleUtils.clearScreen();
                        System.out.println("¿Quieres agregar otro instructor? \n 1. \n 2.");
                        int opcion = sc.nextInt();
                        if (opcion == 2) {
                            break;
                        }
                        sc.nextLine();
                    }while (true);

                    equipo.setListEntrenadores(entrenadores);

                    do {
                        ConsoleUtils.clearScreen();
                        System.out.println("Ingrese el ID del masajista: ");
                        int idMasajita = sc.nextInt();
                        Doctor masajista = new Doctor();
                        masajista.setId(idMasajita);
                        masajistas.add(masajista);

                        ConsoleUtils.clearScreen();
                        System.out.println("¿Quieres agregar otro masajista? \n 1. \n 2.");
                        int opcion = sc.nextInt();
                        if (opcion == 2) {
                            break;
                        }
                        sc.nextLine();
                    } while (true);

                    equipo.setListMasajistas(masajistas);

                    controlador.equipos.put(codigoEquipo, equipo);
                    break;

                case 2:
                    ConsoleUtils.clearScreen();
                    System.out.println("Ingrese el codigo del equipo a actualizar: ");
                    codigoEquipo = sc.nextLine();

                    if (controlador.equipos.containsKey(codigoEquipo)) {
                        ConsoleUtils.clearScreen();
                        Team equipoAct = controlador.equipos.get(codigoEquipo);

                        System.out.println("""
                                Que deseas actualizar?
                                1. Nombre del equipo
                                2. Ciudad del equipo
                                3. Agregar(jugador, entrenador, masajista)
                                4. Eliminar(jugador, entrenador, masajista)
                                5. Salir
                                """);
                        int choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                ConsoleUtils.clearScreen();
                                System.out.println("Ingresa el nuevo nombre del equipo");
                                String nuevoNombre = sc.nextLine();
                                equipoAct.setNombre(nuevoNombre);
                                break;
                            
                            case 2:
                                ConsoleUtils.clearScreen();
                                System.out.println("Ingresa la nueva ciudad del equipo");
                                String nuevaCiudad = sc.nextLine();
                                equipoAct.setCiudad(nuevaCiudad);
                                break;
                            
                            case 3:
                                ConsoleUtils.clearScreen();
                                System.out.println("""
                                        Que deseas agregar?
                                        1. Jugador
                                        2. Entrenador
                                        3. Masajista
                                        """);
                                int choice3 = sc.nextInt();
                                switch (choice3) {
                                    case 1:
                                        ConsoleUtils.clearScreen();
                                        System.out.println("MONDA 1");
                                        break;
                                    case 2:
                                        ConsoleUtils.clearScreen();  
                                        System.out.println("MONDA 2");
                                        break;
                                    case 3:
                                        ConsoleUtils.clearScreen();
                                        System.out.println("MONDA 3");
                                        break;
                                
                                    default:
                                        break;
                                }
                            default:
                                break;
                        }

                    }
                    

                case 3:
                    Team eq = new Team();
                    String codigoE = "001";
                    eq = controlador.equipos.get(codigoE);
                    System.out.println("Mi equipo" + eq.getNombre());
                    break;
                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}