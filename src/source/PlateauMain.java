package source;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Robert
 */
public class PlateauMain {
     public void ejecutarPrueba(String direccion_archivo) {

//        Plateau px = new Plateau(5, 5);
//        px.establecerPosicionRoverInicial(1, 2, 'N');
//        String movimientos = "LMLMLMLMM";
//        px.establecerMovimientosRover(movimientos);
//        px.obtenerDireccionFinal();
//        
//        px.establecerPosicionRoverInicial(3, 3, 'E');
//         movimientos = "MMRMMRMRRM";
//        px.establecerMovimientosRover(movimientos);
//        px.obtenerDireccionFinal();
//        
//        Plateau px = new Plateau(5, 5);
//        px.establecerPosicionRoverInicial(2, 3, "W");
//        String movimientos = "MRMRMRMMLMR";
//        px.establecerMovimientosRover(movimientos);
//        px.obtenerDireccionFinal();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {            
            archivo = new File(direccion_archivo);    
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);            
            String linea;
            int maxX, maxY = 0;
            int pos_rover_x = 0, pos_rover_y = 0;
            char direccion_rover = 0;
            String movimientos = "";
            
            int cont = 0;
            Plateau px = new Plateau();
            boolean inicio = true;
            while ((linea = br.readLine()) != null) {
                if (inicio) {
                    String[] linea_array = linea.split(" ");
                    maxX = Integer.valueOf(linea_array[0]);
                    maxY = Integer.valueOf(linea_array[1]);
                    inicio = false;
                    /**
                     * ESTABLECEMOS EL MAXIMO DEL PLATEAU
                     */
                    px = new Plateau(maxX, maxY);
                } else {
                    switch (cont) {
                        case 0: {                           
                            String[] linea_array = linea.split(" ");
                            pos_rover_x = Integer.valueOf(linea_array[0]);
                            pos_rover_y = Integer.valueOf(linea_array[1]);
                            direccion_rover = linea_array[2].charAt(0);
                            px.establecerPosicionRoverInicial(pos_rover_x, pos_rover_y, direccion_rover);
                            cont = 1;                            
                        }
                        break;
                        case 1: {                           
                            movimientos = linea;                            
                            px.establecerMovimientosRover(movimientos);
                            System.out.println(px.obtenerDireccionFinal());
                            cont = 0;                                                        
                        }
                        break;
                    }
                }               
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * cerrar el archivo
             */
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
     
     
    public static void main(String[] args) {
        PlateauMain plateauMain=new PlateauMain();
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca la direccion del archivo a leer");
        String direccion=sc.nextLine();
//        plateauMain.ejecutarPrueba("D:\\EntradaDeDatos.txt");
        plateauMain.ejecutarPrueba(direccion);
    }
}
