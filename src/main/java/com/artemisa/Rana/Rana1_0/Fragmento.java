package com.artemisa.Rana.Rana1_0;

/**
 * La clase fragmentó representa una unidad minima de información
 * dentro del sistema Rana.
 * Conceptualmente, un Fragmento puede verse como
 * -Un bloque de Datos
 * -Un fragmento de conocimiento
 * -Una pieza de información evaluable por el algoritmo
 *
 * Esta clase es inmutable: Una vez creado el fragmento,
 * su contenido y firma no puede cambiar
 */
public class Fragmento
{
    /**
     * Contenido principal del fragmento
     * Representa la información Pura que será procesada
     * Evaluada, ordenada o mostrada por el sistema
     */
    private final String contenido;

    /**
     * Firma asociada al fragmento
     * puede representar:
     * - Un identificador logico
     * - Una huella de origen
     * - Una validation o marca del fragmento
     */
    private final String firma;

    /**
     * Constructor del fragmento
     * Se encarga de inicializar completamente el objeto
     * - Un contenido
     * - Firma
     * @param contenido información que porta el fragmento
     * @param firma Identificador o firma del fragmento
     */
    public Fragmento(String contenido, String firma)
    {
        this.contenido = contenido;
        this.firma = firma;
    }

    /**
     * Devuelve el contenido del fragmento
     *
     * Este método permite acceder de forma controlada
     * a la information interna sin romper la inmutabilidad
     * @return Contenido del fragmento
     */
    public String getContenido()
    {
        return contenido;
    }

    /**
     * Devuelve la firma del fragmento
     * Es util para validaciones, comparaciones o trazabilidad
     * dentro del algoritmo Rana
     * @return firma del fragmento
     */
    public String getFirma()
    {
        return firma;
    }

    /**
     * Se muestra la information del usuario
     * Se listan fragmento sin mostrar metadatos
     */
    @Override
    public String toString()
    {
        return contenido;
    }
}
