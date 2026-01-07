package com.artemisa.Rana.Rana2_0;

/**
 * Fragmento representa una unidad minima de datos
 * dentro del algoritmo rana
 *
 * Cada fragmento contiene:
 * - Los datos originales(bytes)
 * - Una firma unica que lo identifica
 */
public class Fragmentos
{
    //DAtos binarios del fragmento(parte del archivo original)
    private byte[] datos;

    //Firma hash que identifica al fragmento
    private String firma;

    /**
     * Constructor del fragmento.
     *
     * @param datos Bloque de datos del archivo
     * @param firma Hash que representa la identidad del bloque
     */
    public Fragmentos(byte[] datos, String firma)
    {
        this.datos = datos;
        this.firma = firma;
    }


    public byte[] getDatos()
    {
        return datos;
    }

    public String getFirma()
    {
        return firma;
    }
}
