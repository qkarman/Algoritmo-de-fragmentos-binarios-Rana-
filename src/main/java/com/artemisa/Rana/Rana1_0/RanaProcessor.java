package com.artemisa.Rana.Rana1_0;

import java.util.*;

public class RanaProcessor
{
    public ResultadoR procesar(List<String> datosEntrada)
    {
        List<Fragmento> fragmentos = new ArrayList<>();

        //1. Fragmentamos + calcular firma
        for(String dato : datosEntrada)
        {
            String firma = calcularFirma(dato);
            fragmentos.add(new Fragmento(dato, firma));
        }

        //2. Agrupamos por firma
        Map<String, List<Fragmento>> mapaGrupos = new HashMap<>();

        for(Fragmento f: fragmentos)
        {
            mapaGrupos.computeIfAbsent(f.getFirma(), k -> new ArrayList<>()).add(f);
        }

        //3. Clasificamos los grupos
        List<String> repetidos = new ArrayList<>();
        List<String> unicos = new ArrayList<>();

        for(Map.Entry<String, List<Fragmento>> entry : mapaGrupos.entrySet())
        {
            if(entry.getValue().size() > 1)
            {
                repetidos.add(entry.getKey());
            }
            else
            {
                unicos.add(entry.getKey());
            }
        }

        //4. Resultado final
        return new ResultadoR(
                mapaGrupos,
                repetidos,
                unicos,
                fragmentos.size()
        );
    }

    //Firma simplificada(Se puede mejorar aun más)
    private String calcularFirma(String dato)
    {
        return dato.replaceAll("\\d+", "") //quita numeros
                .trim()
                .toLowerCase();
    }
}
