package com.soccer.view;

import java.util.Scanner;
import com.soccer.Controller;
import com.soccer.entity.Player;
import com.soccer.util.ConsoleUtils;

public class viewPlayer {
    public static Controller controlador = new Controller();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        int op;
        do {
            ConsoleUtils.clearScreen();
            System.out.println(" Menu Jugadores ");
            System.out.println(" ");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Listar todos los Jugadores");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            op = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (op) {
                case 1:
                    crearJugador();
                    break;

                case 2:
                    actualizarJugador();
                    break;

                case 3:
                    eliminarJugador();
                    break;

                case 4:
                    listarJugadores();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (op != 5);

        sc.close(); // Cerrar el scanner al salir del bucle
    }

    private void crearJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del Jugador: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()

        System.out.print("Ingrese el Nombre del Jugador: ");
        String nombre = sc.nextLine();

        ConsoleUtils.clearScreen();
        System.out.print("Ingrese Apellidos del Jugador: ");
        String apellido = sc.nextLine();

        ConsoleUtils.clearScreen();
        System.out.print("Ingrese la Edad del Jugador: ");
        int edad = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()

        ConsoleUtils.clearScreen();
        System.out.print("Ingrese la dorsal: ");
        int dorsal = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()

        ConsoleUtils.clearScreen();
        System.out.print("Ingrese la posición: ");
        String posicion = sc.nextLine();

        Player nuevoJugador = new Player(id, nombre, apellido, edad, dorsal, posicion);
        controlador.jugadores.put(id, nuevoJugador);
        System.out.println("Jugador creado exitosamente.");
    }

    private void actualizarJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del jugador a actualizar: ");
        int codigoJugador = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()

        if (controlador.jugadores.containsKey(codigoJugador)) {
            Player jugadorAct = controlador.jugadores.get(codigoJugador);
            ConsoleUtils.clearScreen();
            System.out.println("Jugador: " + jugadorAct.getNombre() + " " + jugadorAct.getApellido());
            System.out.println();
            System.out.println("""
                    ¿Qué deseas actualizar?
                    1. Nombre del Jugador
                    2. Apellido del Jugador
                    3. Edad del Jugador
                    4. Dorsal del Jugador
                    5. Posición del Jugador
                    6. Salir
                    """);

            int choice2 = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (choice2) {
                case 1:
                    actualizarNombre(jugadorAct);
                    break;

                case 2:
                    actualizarApellido(jugadorAct);
                    break;

                case 3:
                    actualizarEdad(jugadorAct);
                    break;

                case 4:
                    actualizarDorsal(jugadorAct);
                    break;

                case 5:
                    actualizarPosicion(jugadorAct);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } else {
            System.out.println("El jugador con código " + codigoJugador + " no existe!");
        }
    }

    private void actualizarNombre(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo nombre del Jugador: ");
        String nuevoNombre = sc.nextLine();
        jugador.setNombre(nuevoNombre);
    }

    private void actualizarApellido(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa el nuevo apellido del Jugador: ");
        String nuevoApellido = sc.nextLine();
        jugador.setApellido(nuevoApellido);
    }

    private void actualizarEdad(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva edad del Jugador: ");
        int nuevaEdad = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()
        jugador.setEdad(nuevaEdad);
    }

    private void actualizarDorsal(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva dorsal del Jugador: ");
        int nuevaDorsal = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()
        jugador.setDorsal(nuevaDorsal);
    }

    private void actualizarPosicion(Player jugador) {
        ConsoleUtils.clearScreen();
        System.out.print("Ingresa la nueva posición del Jugador: ");
        String nuevaPosicion = sc.nextLine();
        jugador.setPosicion(nuevaPosicion);
    }

    private void eliminarJugador() {
        ConsoleUtils.clearScreen();
        System.out.print("Ingrese el código del jugador a Eliminar: ");
        int codigoJugadorElim = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de nextInt()

        if (controlador.jugadores.containsKey(codigoJugadorElim)) {
            Player jugadorElim = controlador.jugadores.get(codigoJugadorElim);
            ConsoleUtils.clearScreen();
            System.out.println("Jugador: " + jugadorElim.getNombre() + " " + jugadorElim.getApellido());
            System.out.println("Edad: " + jugadorElim.getEdad() + " Posición: " + jugadorElim.getPosicion() + " Dorsal: " + jugadorElim.getDorsal());
            System.out.print("¿Seguro quieres eliminarlo? (Si/No): ");

            String conf = sc.nextLine();

            if (conf.equalsIgnoreCase("si") || conf.equalsIgnoreCase("s")) {
                controlador.jugadores.remove(codigoJugadorElim);
                System.out.println("Jugador eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El jugador con código " + codigoJugadorElim + " no existe!");
        }
    }

    private void listarJugadores() {
        ConsoleUtils.clearScreen();
        System.out.println("Listado de jugadores: ");
        for (Integer key : controlador.jugadores.keySet()) {
            Player currentPlayer = controlador.jugadores.get(key);
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentPlayer.getNombre());
            System.out.println("Apellido: " + currentPlayer.getApellido());
            System.out.println("Edad: " + currentPlayer.getEdad());
            System.out.println("Dorsal: " + currentPlayer.getDorsal());
            System.out.println("Posición: " + currentPlayer.getPosicion());
            System.out.println("-----------------------------------");
            sc.nextLine();
        }
    }
}
