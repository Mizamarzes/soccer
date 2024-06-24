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
        Scanner sc = new Scanner(System.in);

        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");

            int choice = ConsoleUtils.verificarEntradaInt(1, 6);
            
            Team equipo = new Team();

            ArrayList<Player> jugadores = new ArrayList<>();
            ArrayList<Coach> entrenadores = new ArrayList<>();
            ArrayList<Doctor> masajistas = new ArrayList<>();

            switch (choice) {
                case 1:
                    crearEquipo(equipo, jugadores, entrenadores, masajistas);
                    break;
                case 2:
                    actualizarEquipo(sc);
                    break;
                case 3:
                    buscarEquipo(sc);
                    break;
                case 4:
                    eliminarEquipo(sc);
                    break;
                case 5:
                    listarEquipos();
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

    private void crearEquipo(Team equipo, ArrayList<Player> jugadores, ArrayList<Coach> entrenadores, ArrayList<Doctor> masajistas) {
        String codigoEquipo;

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del equipo :");
        codigoEquipo = ConsoleUtils.verificarEntradaString();

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese Nombre del equipo :");
        equipo.setNombre(ConsoleUtils.verificarEntradaString());

        ConsoleUtils.clearScreen();
        System.out.println("Ingrese la ciudad :");
        equipo.setCiudad(ConsoleUtils.verificarEntradaString());

        agregarJugadores(jugadores);
        equipo.setListJugadores(jugadores);

        agregarEntrenadores(entrenadores);
        equipo.setListEntrenadores(entrenadores);

        agregarMasajistas(masajistas);
        equipo.setListMasajistas(masajistas);

        controlador.equipos.put(codigoEquipo, equipo);
    }

    private void agregarJugadores(ArrayList<Player> jugadores) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del jugador: ");
            int idJugador = ConsoleUtils.verificarIntSinRango();
            Player jugador = new Player();
            jugador.setId(idJugador);
            jugadores.add(jugador);

            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro jugador? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarEntrenadores(ArrayList<Coach> entrenadores) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del entrenador");
            int idEntrenador = ConsoleUtils.verificarIntSinRango();
            Coach entrenador = new Coach();
            entrenador.setId(idEntrenador);
            entrenadores.add(entrenador);
            
            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro entrenador? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarMasajistas(ArrayList<Doctor> masajistas) {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el ID del masajista: ");
            int idMasajista = ConsoleUtils.verificarIntSinRango();
            Doctor masajista = new Doctor();
            masajista.setId(idMasajista);
            masajistas.add(masajista);

            ConsoleUtils.clearScreen();
            System.out.println("¿Quieres agregar otro masajista? \n 1. Si \n 2. No");
            int opcion = ConsoleUtils.verificarEntradaInt(1, 2);
            if (opcion == 2) {
                break;
            }
        }
    }

    private void actualizarEquipo(Scanner sc) {
        ConsoleUtils.clearScreen();
        System.out.println("Ingrese el codigo del equipo a actualizar: ");
        String codigoEquipo = sc.nextLine();

        if (controlador.equipos.containsKey(codigoEquipo)) {
            Team equipoAct = controlador.equipos.get(codigoEquipo);
            ConsoleUtils.clearScreen();
            System.out.println("""
                Que deseas actualizar?
                1. Nombre del equipo
                2. Ciudad del equipo
                3. Agregar(jugador, entrenador, masajista)
                4. Eliminar(jugador, entrenador, masajista)
                5. Salir
            """);
            int choice2 = sc.nextInt();
            sc.nextLine();

            switch (choice2) {
                case 1:
                    ConsoleUtils.clearScreen();
                    System.out.println("Ingresa el nuevo nombre del equipo");
                    equipoAct.setNombre(sc.nextLine());
                    break;
                case 2:
                    ConsoleUtils.clearScreen();
                    System.out.println("Ingresa la nueva ciudad del equipo");
                    equipoAct.setCiudad(sc.nextLine());
                    break;
                case 3:
                    // agregarEntidad(sc, equipoAct);
                    break;
                case 4:
                    eliminarEntidad(sc, equipoAct);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        } else {
            System.out.println("El equipo con el codigo " + codigoEquipo + " no existe.");
        }
    }

    private void buscarEquipo(Scanner sc) {
        boolean encontrado = false;

        while (!encontrado) {
            ConsoleUtils.clearScreen();
            System.out.println("Ingrese el codigo del equipo a buscar: ");
            System.out.println("Si desea salir ingrese el numero 0");
            String codeEquipo = sc.nextLine();

            if (codeEquipo.equals("0")) {
                System.out.println("Saliendo...");
                
                ConsoleUtils.waitWindow();
                break;
            }

            if (controlador.equipos.containsKey(codeEquipo)) {
                Team eq = controlador.equipos.get(codeEquipo);
                ConsoleUtils.clearScreen();
                System.out.println("Nombre: " + eq.getNombre());
                System.out.println("Ciudad: " + eq.getCiudad());
                System.out.println("Jugadores: " + eq.getListJugadores());
                System.out.println("Entrenadores: " + eq.getListEntrenadores());
                System.out.println("Masajistas: " + eq.getListMasajistas());
                encontrado = true;

                ConsoleUtils.waitWindow();
                break;
            } else {
                System.out.println("El equipo con el ID " + codeEquipo + " no existe.");

                ConsoleUtils.waitWindow();
                break;
            }
        }
    }

    private void eliminarEquipo(Scanner sc) {
        // Implementar lógica para eliminar equipo
    }

    private void listarEquipos() {
        ConsoleUtils.clearScreen();
        System.out.println("Lista de todos los equipos:");
        for (String codigo : controlador.equipos.keySet()) {
            Team eq = controlador.equipos.get(codigo);
            System.out.println("Codigo: " + codigo + ", Nombre: " + eq.getNombre() + ", Ciudad: " + eq.getCiudad());
        }
    }

    // private void agregarEntidad(Scanner sc, Team equipoAct) {
    //     ConsoleUtils.clearScreen();
    //     System.out.println("""
    //             Que deseas agregar?
    //             1. Jugador
    //             2. Entrenador
    //             3. Masajista
    //             4. Salir
    //             """);
    //     int choice = sc.nextInt();
    //     sc.nextLine();

    //     switch (choice) {
    //         case 1:
    //             ArrayList<Player> jugadores = equipoAct.getListJugadores();
    //             agregarJugadores(sc, jugadores);
    //             equipoAct.setListJugadores(jugadores);
    //             break;
    //         case 2:
    //             ArrayList<Coach> entrenadores = equipoAct.getListEntrenadores();
    //             agregarEntrenadores(sc, entrenadores);
    //             equipoAct.setListEntrenadores(entrenadores);
    //             break;
    //         case 3:
    //             ArrayList<Doctor> masajistas = equipoAct.getListMasajistas();
    //             agregarMasajistas(sc, masajistas);
    //             equipoAct.setListMasajistas(masajistas);
    //             break;
    //         case 4:
    //             break;
    //         default:
    //             System.out.println("Opcion invalida, intentelo de nuevo.");
    //     }
    // }

    private void eliminarEntidad(Scanner sc, Team equipoAct) {
        // Implementar   
    }
}