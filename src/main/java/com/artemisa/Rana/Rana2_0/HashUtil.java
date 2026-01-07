package com.artemisa.Rana.Rana2_0;

import java.security.MessageDigest;

/**
 * HashUtil se encarga de generar firmas unicas
 * a partir de datos binarios
 *
 * Estas firmas permiten identificar fragmentos iguales aunque provengan de archivos diferentes
 *
 * Rana usa estas firmas para agrupar datos repetidos
 */
public class HashUtil
{
    /**
     * Genera un hash SHA-256 a partir de un arreglo de bytes
     * @param datos Bloque de datos(imagen, texto. binario, etc)
     * @return Cadena hexadecimal que representa la firma del bloque
     */
    public static String sha256(byte[] datos)
    {
        try
        {
            //Se obtiene el algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //Se calcula el hash del bloque de datos
            byte[] hash = md.digest(datos);

            //Convertimos el hash a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for(byte b : hash)
            {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (Exception e)
        {
            //Si ocurre un error critico se detiene la ejecución
            throw new RuntimeException(e);
        }
    }
}
