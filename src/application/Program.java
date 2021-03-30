package application;

import entities.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);

        String path = "/home/bruno/Documentos/Projetos do Curso Java/Manipulando_arquivos/in.csv";
        String pathFolder = "/home/bruno/Documentos/Projetos do Curso Java/Manipulando_arquivos/Out/summary.csv";

        List<Produto> list = new ArrayList<>();
        String[] p = null;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null){
                p = line.split(",");
                String nomeProduto = p[0].toString();
                Double valor = Double.parseDouble(p[1]);
                Integer quant = Integer.parseInt(p[2]);
                list.add(new Produto(nomeProduto,valor,quant));
                line = br.readLine();
            }

            System.out.println("=============================================");

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathFolder,true))){

            for(Produto l : list){
                System.out.println(l);
                bw.write(l.getNome() + ", " + String.format("%.2f",l.total()));
                bw.newLine();
            }


        }
        catch (IOException e){
            System.out.println("Error " + e.getMessage());
        }




    }





}
