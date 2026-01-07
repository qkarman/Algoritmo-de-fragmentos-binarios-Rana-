package com.artemisa.Rana.Rana1_0;

import java.util.List;
import java.util.Map;

/**
 * Representa el resultado final del analysis realizado por el algoritmo rana
 * Este objeto sirve como salida estructurada que será consumida por otros modulos como H y T
 */
public class ResultadoR
{
    //Grupos de fragmentos organizados por firma
    private final Map<String, List<Fragmento>> grupos;

    //Firmas que aparecen más de una vez(Datos repetidos)
    private final List<String> gruposRepetidos;

    //Firmas que aparecen solo una vez(Datos unicos)
    private final List<String> gruposUnicos;

    //Total de fragmentos analizados por Rana
    private final int totalFragmentos;

    //Constructor
    public ResultadoR(
            Map<String, List<Fragmento>> grupos,
            List<String> gruposRepetidos,
            List<String> gruposUnicos,
            int totalFragmentos)
    {
        this.grupos = grupos;
        this.gruposRepetidos = gruposRepetidos;
        this.gruposUnicos = gruposUnicos;
        this.totalFragmentos = totalFragmentos;
    }

    //Set y get
    public Map<String, List<Fragmento>> getGrupos()
    {
        return grupos;
    }

    public List<String> getGruposRepetidos()
    {
        return gruposRepetidos;
    }

    public List<String> getGruposUnicos()
    {
        return gruposUnicos;
    }

    public int getTotalFragmentos()
    {
        return totalFragmentos;
    }
}
