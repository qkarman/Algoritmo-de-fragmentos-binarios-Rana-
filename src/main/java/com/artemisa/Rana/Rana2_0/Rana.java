package com.artemisa.Rana.Rana2_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La clase Rana se encarga de analizar los fragmentos
 * y agruparlos según su firma.
 *
 * Si varios fragmentos tienen las mismas firmas,
 * significa que son iguales o muy similares.
 *
 * Rana no elimina datos, solo los organiza
 * para que otros modulos puedan decidir qué hacer.
 */
public class Rana
{
    /**
     * Procesa una lista de fragmentos y los agrupa por firma
     *
     * @param fragmentos Lista de fragmentos generados por el fragmentador
     * @return Mapa donde la clave es la firma y el valor es la lista de fragmentos con esa firma
     */
    public Map<String, List<Fragmentos>> procesar(List<Fragmentos> fragmentos)
    {
        //Mapa que almacenara los grupos de fragmentos
        //Clave: firma del fragmento
        //Valor: lista de fragmentos con esa misma firma
        Map<String, List<Fragmentos>> grupos = new HashMap<>();

        //Recorre cada fragmento recibido
        for(Fragmentos f : fragmentos)
        {
            //Si la firma no existe, se crea una nueva lista
            //Si ya existe, se agrega el fragmento al grupo
            grupos
                    .computeIfAbsent(f.getFirma(), k -> new ArrayList<>())
                    .add(f);
        }
        //Devuelve los fragmentos agrupados
        return grupos;
    }
}
