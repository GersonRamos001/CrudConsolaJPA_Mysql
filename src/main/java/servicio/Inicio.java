package servicio;

import controladorLogica.LogicaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Carrera;
import model.Credencial;
import model.Estudiante;
import model.Materia;

public class Inicio {

    public static void main(String[] args) {
        LogicaController controller = new LogicaController();
        Credencial cred = new Credencial();
        Carrera carr = new Carrera();

        while (true) {
            System.out.println("*****************MENU PRINCIPAL ********************* "
                    + "\n Ingrese su eleccion: "
                    + "\n 1. Operaciones Credencial"
                    + "\n 2. Operaciones Carrera"
                    + "\n 3. Crear Estudiante"
                    + "\n 4. Crear Materia"
                    + "\n 5. Salir"
                    + "\n"
                    + "\n*************************************************************");

            Scanner scan = new Scanner(System.in);
            int opcion;
            opcion = Integer.parseInt(scan.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Operaciones de Credencial: "
                            + "\n 1. Crear credencial"
                            + "\n 2. Leer credencial"
                            + "\n 3. Actualizar credencial"
                            + "\n 4. Eliminar credencial"
                            + "\n 5. Mostrar todas las credencial"
                            + "\n 6. Regresar al menú principal");
                    int opcionCredencial = Integer.parseInt(scan.nextLine());
                    switch (opcionCredencial) {
                        case 1:
                            System.out.println("Ingrese el nombre de la credencial:");
                            String username = scan.nextLine();
                            Credencial credencial = new Credencial();
                            credencial.setUsername(username);
                            controller.crearCredencial(credencial);
                            System.out.println("Ingresado exitosamente");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("Ingrese el ID de la credencial:");
                            int idCredencial = Integer.parseInt(scan.nextLine());
                            Credencial credencialLeida = controller.leerCredencial(idCredencial);
                            System.out.println("Nombre de la credencial: " + credencialLeida.getUsername());
                            System.out.println("ID de la credencial: " + credencialLeida.getIdCredencial());
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("Ingrese el ID de la credencial:");
                            int idCredencialAct = Integer.parseInt(scan.nextLine());
                            cred = controller.leerCredencial(idCredencialAct);
                            System.out.println("Ingrese el nuevo nombre de la credencial:");
                            String nuevoUsername = scan.nextLine();
                            cred.setUsername(nuevoUsername);
                            controller.modificarCredencial(cred);
                            System.out.println("La Credencial fue modificado exitosamente");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 4:
                            System.out.println("Ingrese el ID de la credencial:");
                            int idCredencialDel = Integer.parseInt(scan.nextLine());
                            controller.eliminarCredencial(idCredencialDel);
                            System.out.println("CREDENCIAL " + idCredencialDel + "ELIMINADA");
                            System.out.println("");
                            System.out.println("");
                            break;

                        case 5:
                            System.out.println("Estas son todas las credenciales:");
                            List<Credencial> listaCredenciales = null;

                            listaCredenciales = controller.leerTodasCredencial();
                            for (Credencial credencial1 : listaCredenciales) {
                                System.out.println(credencial1.toString());
                            }

                            System.out.println("");
                            System.out.println("");
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;

                ///CARRERAS
                case 2:
                    System.out.println("Operaciones de Carrera: "
                            + "\n 1. Crear carrera"
                            + "\n 2. Leer carrera"
                            + "\n 3. Actualizar carrera"
                            + "\n 4. Eliminar carrera"
                            + "\n 5. Mostrar todas las carrera"
                            + "\n 5. Regresar al menú principal");
                    int opcionCarrera = Integer.parseInt(scan.nextLine());
                    switch (opcionCarrera) {
                        case 1:
                            System.out.println("Ingrese el nombre de la carrera:");
                            String nombreCarrera = scan.nextLine();
                            System.out.println("Ingrese el codigo de la carrera:");
                            String codigoCrr = scan.nextLine();
                            System.out.println("Ingresado exitosamente");
                            System.out.println("");
                            System.out.println("");

                            carr.setNombres(nombreCarrera);
                            carr.setCodigo(codigoCrr);
                            controller.crearCarrera(carr);
                            break;
                        case 2:
                            System.out.println("Ingrese el ID de la carrera:");
                            int idCarrera = Integer.parseInt(scan.nextLine());
                            Carrera carrera = controller.leerCarrera(idCarrera);
                            System.out.println("Nombre de la carrera: " + carrera.getNombres());
                            System.out.println("Nombre de la carrera: " + carrera.getCodigo());
                            System.out.println("ID de la carrera: " + carrera.getIdCarrera());
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("Ingrese el ID de la carrera:");
                            int idCarreraAct = Integer.parseInt(scan.nextLine());
                            carr = controller.leerCarrera(idCarreraAct);
                            System.out.println("Ingrese el nuevo nombre de la carrera:");
                            String nombreCarreraAct = scan.nextLine();
                            carr.setNombres(nombreCarreraAct);
                            controller.modificarCarrera(carr);
                            controller.modificarCredencial(cred);
                            System.out.println("La carrera fue modificado exitosamente");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 4:
                            System.out.println("Ingrese el ID de la carrera:");
                            int idCarreraDel = Integer.parseInt(scan.nextLine());
                            controller.eliminarCarrera(idCarreraDel);
                            System.out.println("CREDENCIAL " + idCarreraDel + "ELIMINADA");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 5:
                            System.out.println("Estas son todas las Carreras:");
                            List<Carrera> listaCarreras = null;
                            listaCarreras = controller.leerTodasCarreras();
                            for (Carrera carrera1 : listaCarreras) {
                                System.out.println(carrera1.toString());
                            }
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;

                //ESTUDIANTE
                case 3:
                    System.out.println("Operaciones de Estudiante: "
                            + "\n 1. Crear estudiante"
                            + "\n 2. Leer estudiante"
                            + "\n 3. Actualizar estudiante"
                            + "\n 4. Eliminar estudiante"
                            + "\n 5. Regresar al menú principal");

                    int opcionEstudiante = Integer.parseInt(scan.nextLine());
                    switch (opcionEstudiante) {
                        case 1:
                            System.out.println("Ingrese el carnet del estudiante:");
                            String carnet = scan.nextLine();
                            System.out.println("Ingrese el nombre del estudiante:");
                            String nombre = scan.nextLine();
                            System.out.println("Ingrese el apellido del estudiante:");
                            String apellido = scan.nextLine();
                            List<Carrera> carrerasSeleccionadas = new ArrayList<>();
                            boolean bandera = true;
                            while (bandera) {

                                System.out.println("Ingrese el ID de la carrera:");
                                System.out.println("Estas son todas las Carreras:");
                                List<Carrera> listaCarreras = new ArrayList<>();
                                listaCarreras = controller.leerTodasCarreras();
                                for (Carrera carrera1 : listaCarreras) {
                                    System.out.println(carrera1.toString());
                                }
                                System.out.println("Ingrese el ID de la carrera:");
                                int idCarrera = Integer.parseInt(scan.nextLine());
                                Carrera carreraSe = new Carrera();
                                carreraSe = controller.leerCarrera(idCarrera);
                                carrerasSeleccionadas.add(carreraSe);
                                System.out.println("Desea Agregar otra carrera 1. SI 2. NO");
                                int seleccion = Integer.parseInt(scan.nextLine());
                                if (seleccion == 2) {
                                    bandera = false;
                                }
                            }

                            System.out.println("Ingrese el ID de la credencial del estudiante:");
                            System.out.println("Estas son todas las credenciales:");
                            List<Credencial> listaCredenciales = null;

                            listaCredenciales = controller.leerTodasCredencial();
                            for (Credencial credencial1 : listaCredenciales) {
                                System.out.println(credencial1.toString());
                            }
                            System.out.println("");
                            System.out.println("");
                            int idCredencial = Integer.parseInt(scan.nextLine());
                            cred = controller.leerCredencial(idCredencial);

////////////////Cambiar version 2
                            //CREO LISTA DE ESTUDIANTES VACIOS
                            List<Estudiante> listaEstudiante = new ArrayList();

                            //        Create Materia Entity
                            Materia materia1 = new Materia();
                            materia1.setCodigo("POO01");
                            materia1.setNombre("Programacion Orientada a objetos");
                            materia1.setListaEstudiantes(listaEstudiante);

                            Materia materia2 = new Materia();
                            materia2.setCodigo("FE2022");
                            materia2.setNombre("Framework empresariales");
                            materia2.setListaEstudiantes(listaEstudiante);

                            Materia materia3 = new Materia();
                            materia3.setCodigo("EL2023");
                            materia3.setNombre("Empredimiento y liderazgo");
                            materia3.setListaEstudiantes(listaEstudiante);

                            //        Store materia1
                            controller.crearMateria(materia1);
                            controller.crearMateria(materia2);
                            controller.crearMateria(materia3);

                            //        Creo lista de materias
                            List<Materia> listaMaterias = new ArrayList();
                            listaMaterias.add(materia2);
                            listaMaterias.add(materia1);
                            listaMaterias.add(materia3);
                            ///////////////////////////////////////////////

                            Estudiante estudiante = new Estudiante(carnet, nombre, apellido, carr, cred, listaMaterias);
                            controller.crearEstudiante(estudiante);
                            System.out.println("Estudiante ingresado exitosamente");
                      
                            break;
                        case 2:

                            break;
                        case 3:
                            break;

                        case 4:

                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;

                default:
                    throw new AssertionError();
            }

        }
    }

}
