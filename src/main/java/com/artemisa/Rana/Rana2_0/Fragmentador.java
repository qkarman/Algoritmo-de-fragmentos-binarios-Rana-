package com.artemisa.Rana.Rana2_0;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * La clase Fragmentador se encarga de leer un archivo
 * y dividirlo en bloques de tamaño fijo.
 *
 * Cada bloque representa una parte del archivo original
 * y se convierte en un fragmento con su fima
 *
 * Esta clase NO decide que datos son importantes,
 * solo se encarga de preparar los datos para rana.
 */
public class Fragmentador
{
    /**
     * Divide un archivo en fragmentos de tamaño definido
     *
     * @param ruta Ruta del archivo(imagen,txt,pdf,etc)
     * @param tamBloque Tamaño de cada bloque en bytes
     * @return Lista de fragmentos generados a partir del archivo
     * @throws Exception analysis del error
     */
    public static List<Fragmentos> fragmentarArchivo(String ruta, int tamBloque) throws Exception
    {
        //Lee el conjunto del archivo como un arreglo de bytes
        byte[] archivo = Files.readAllBytes(Path.of(ruta));

        //Lista donde se almacenaran los fragmentos
        List<Fragmentos> fragmentoss = new ArrayList<>();

        //Recorre el archivo por bloques del tamaño indicado
        for(int i = 0; i < archivo.length; i += tamBloque)
        {
            //Extrae una parte del archivo(bloque)
            //Si es el ultimo bloque, puede ser más pequeño
            byte[] bloque = Arrays.copyOfRange(archivo, i, Math.min(i + tamBloque, archivo.length));

            //Se genera una firma unica para el bloque
            String firma = HashUtil.sha256(bloque);

            //Se crea el fragmento y se agrega a la lista
            fragmentoss.add(new Fragmentos(bloque, firma));
        }
        //Devuelve todos los fragmentos generados
        return fragmentoss;
    }
}
