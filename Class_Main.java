package Clases_Proyecto;

import java.util.Scanner;

import static Clases_Proyecto.Class_GhostGame.*;
import static Clases_Proyecto.Class_Player.*;

public class Class_Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Ghost");
        int menuI, menuP; //menu inicial y menu principal

        do { //Menu inicial
            System.out.print(
                    "Menu de Inicio"+
                    "\n1. Login"+
                    "\n2. Crear Player"+
                    "\n3. Salir"+
                    "\nIngrese una opción:\t");
            menuI = leer.nextInt();

            switch (menuI) { // Acciones del menu inicial
                case 1: //Login
                    System.out.println("Ingrese su nombre de usuario");
                    String user = leer.next();
                    System.out.println("Ingrese su contraseña");
                    String pass = leer.next();
                    verify_Player(user, pass); // Verifica si el usuario existe
                    if (verify_Player(user, pass)) { // Si el usuario existe
                        System.out.println("Bienvenido " + user);

                        do { //Menu principal
                            System.out.println(
                                    "Menu Principal"+
                                    "\n1. Jugar Ghosts"+
                                    "\n2. Configuración"+
                                    "\n3. Reportes"+
                                    "\n4. Mi Perfil"+
                                    "\n5. Salir"+
                                    "\nIngrese una opción:\t");
                            menuP = leer.nextInt();

                            switch (menuP) { // Acciones del menu principal
                                case 1: // Jugar
                                    setPlayer2();
                                    System.out.println("¡A jugar!");
                                    play_Game();
                                    break;

                                case 2: // Configuración
                                    int menuC; //Menu de configuración
                                    do { //Menu de configuración
                                        System.out.println("Configuraciones");
                                        System.out.println(
                                                "\n1. Dificultad"+
                                                "\n2. Modo de juego"+
                                                "\n3. Volver al menu principal"+
                                                "Ingrese una opción:\t");
                                        menuC = leer.nextInt();

                                        switch (menuC) { // Acciones del menu de configuración
                                            case 1: // Dificultad del juego
                                                System.out.println(
                                                        "\nSeleccione la dificultad"+
                                                        "\n1. NORMAL – 8 fantasmas"+
                                                        "\n2. EXPERT – 4 fantasmas"+
                                                        "\n3. GENIUS – 2 fantasma"+
                                                        "\nIngrese una opción:\t");
                                                int dificultad = leer.nextInt();
                                                Dificultad(dificultad); // Cambia la dificultad del juego
                                                break;

                                            case 2: // Modo de juego
                                                System.out.println(
                                                        "\nSeleccione el modo de juego"+
                                                        "\n1. Aleatorio"+
                                                        "\n2. Manual"+
                                                        "\nIngrese una opción:\t");
                                                int modo = leer.nextInt();
                                                ModoG(modo); // Cambia el modo de juego
                                                break;

                                            case 3: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;

                                        }
                                    } while (menuC != 3);
                                    break;
                                case 3:
                                    int menuR; //Menu de reportes
                                    do { //Menu de reportes
                                        System.out.println(
                                                "\nReportes"+
                                                "\n1. Reporte de los últimos 10 juegos"+
                                                "\n2. Ranking de jugadores"+
                                                "\n3. Volver al menu principal"+
                                                "\nIngrese una opción:\t");
                                        menuR = leer.nextInt();

                                        switch (menuR) { // Acciones del menu de reportes
                                            case 1: // Reporte de los últimos 10 juegos
                                                System.out.println("Reporte de los últimos 10 juegos");
                                                reportes();
                                                break;
                                            case 2: // Ranking de jugadores
                                                System.out.println("Ranking de jugadores");
                                                Ranking();
                                                break;
                                            case 3: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;
                                        }
                                    } while (menuR != 3);
                                    break;

                                case 4:
                                    int menuU; //Menu de usuarios
                                    do { //Menu de usuarios
                                        System.out.println(
                                                "Mi Perfil"+
                                                "\n1. Ver mis datos"+
                                                "\n2. cambiar Contraseña"+
                                                "\n3. Eliminar mi cuenta"+
                                                "\n4. Volver al menu principal"+
                                                "\nIngrese una opción:\t");
                                        menuU = leer.nextInt();

                                        switch (menuU) { // Acciones del menu de usuarios
                                            case 1: // Ver mis datos
                                                Perfil();
                                                break;

                                            case 2: // Cambiar contraseña
                                                System.out.println("Ingrese su usuario:");
                                                String usuario = leer.next();
                                                System.out.println("Ingrese su contraseña:");
                                                String password = leer.next();
                                                cambiarC(usuario, password);
                                                break;

                                            case 3: // Eliminar mi cuenta
                                                System.out.println("Ingrese su usuario:");
                                                String usuario1 = leer.next();
                                                System.out.println("Ingrese su contraseña:");
                                                String password1 = leer.next();
                                                Delete_Player(usuario1, password1);
                                                break;

                                            case 4: // Volver al menu principal
                                                System.out.println("Volviendo al menu principal...");
                                                break;
                                        }
                                    } while (menuU != 4);
                                    break;

                                case 5:
                                    System.out.println("Cerrando sesión...");
                                    break;
                            }

                        } while (menuP != 5);

                    } else { // Si el usuario no existe, si la contraseña es incorrecta o si el usuario es incorrecto
                        System.out.println("Usuario o contraseña incorrectos");
                    }
                    break;

                case 2: // Registrarse
                    System.out.println("Ingrese el nombre de usuario:");
                    user = leer.next();
                    buscar_Player(user); // Busca si el usuario existe
                    Register_Player(user); // Si el usuario no existe, lo registra
                    break;

                case 3: // Salir
                    System.out.println("Gracias por Jugar...");
                    break;
            }

        } while (menuI != 3);
    }
}
