package edu.eloy.entornoServidor.SpringMvc.util;
import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

    public static String guardarArchivo(MultipartFile multipart, String ruta) {
        //Obtenemos el nombre original del archivo
        String nombreOriginal = multipart.getOriginalFilename();
        //reemplazamos posibles espacios por -
        nombreOriginal.replace(" ", "-");
        String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
        try {
            //Formamps el nombre del archivo para guardarlo en el disco duro.
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            //Guardamos fisicamente el archivo en HD.
            multipart.transferTo(imageFile);
            return nombreFinal;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    //METODO PARA AÑADIR CARACTERES ALEATORIOS AL NOMBRE DEL ARCHIVO PARA EVITAR DUPLICADOS
    //ESTE MÉTODO RECIBE COMO PARÁMETRO UN ENTERO Y GENERA UNA CADENA DE TANTOS CARACTERES COMO MARQUE EL NUMOERO DEL PARAMETRO
    //USAREMOS ESTE METODO EN GUARDARARCHIVO()
    public static String randomAlphaNumeric(int count) {
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * CARACTERES.length());
            builder.append(CARACTERES.charAt(character));
        }
        return builder.toString();
    }

}