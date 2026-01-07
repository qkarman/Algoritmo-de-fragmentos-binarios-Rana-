package com.artemisa;

import com.artemisa.Rana.Rana2_0.Fragmentador;
import com.artemisa.Rana.Rana2_0.Fragmentos;
import com.artemisa.Rana.Rana2_0.Rana;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws Exception
    {
        /**
        RanaProcessor rana = new RanaProcessor();

        List<String> datos = List.of(
                "ERROR 404 en modulo A",
                "ERROR 404 en modulo B",
                "ERROR 500 en modulo C",
                "INFO usuario conectados",
                "INFO usuario conectado"
        );

        ResultadoR resultado = rana.procesar(datos);

        resultado.getGrupos().forEach((firma, frags) ->
        {
            System.out.println("Firma: " + firma);
            System.out.println("Fragmentos: " + frags);
            System.out.println();
        });
         **/
        File f = new File("Datas/prueba.txt");
        System.out.println("Existe txt? " + f.exists());

        //*************************************************************
        Rana rana = new Rana();
        int tamBloque = 1024; //1kb

        //Fragmentar ambas imagenes
        List<Fragmentos> img1 = Fragmentador.fragmentarArchivo("Datas/img1.png", tamBloque);

        List<Fragmentos> img2 = Fragmentador.fragmentarArchivo("Datas/img2.png", tamBloque);

        List<Fragmentos> img3 = Fragmentador.fragmentarArchivo("Datas/img3.png", tamBloque);

        List<Fragmentos> prueba = Fragmentador.fragmentarArchivo("Datas/prueba.txt", tamBloque);

        List<Fragmentos> prueba2 = Fragmentador.fragmentarArchivo("Datas/prueba2.txt", tamBloque);

        /// Probar diferentes tamaños y comentarle a la ia sobre porque cuando son menos
        //Imagenes aparece esto y cuando son mas esto
        //Unir fragmentos
        List<Fragmentos> todos = new ArrayList<>();
        //todos.addAll(img1);
        //todos.addAll(img2);
        //todos.addAll(img3);
        todos.addAll(prueba);
        todos.addAll(prueba2);
        //Procesar con rana
        Map<String, List<Fragmentos>> resultado  = rana.procesar(todos);

        //Mostrar firmas repetidas
        System.out.println("=== FRAGMENTOS COMPARTIDOS ===");
        resultado.forEach((firma, lista) ->
        {
            if(lista.size() > 1)
            {
                System.out.println("Firma: " + firma + " | Repeticiones: " + lista.size());
            }
        });
    }
}