/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadosprograma;

import java.util.Scanner;

/**
 *
 * @author aluno.saolucas
 */
public class ProjetoLoja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Digite a opção no menu: ");
            System.out.println("1-Cadastrar produto");
            System.out.println("2-Cadastrar cliente");
            System.out.println("3-Realizar venda");
            System.out.println("4-Listar produtos");
            System.out.println("5-Exibir vendas");
            System.out.println("6- Sair");

            opcao = sc.nextInt();
           
            switch (opcao){
                case 1:
                    System.out.println("Você quer cadastrar qual produto:");
                    System.out.println("1- Roupa");
                    System.out.println("2- Eletronico");
                    System.out.println("3- Alimento");
                   
                    int tipo = sc.nextInt();
                   
                    if (tipo == 1){
                       
                        System.out.println("Nome");
                    }
                   
                   
            }
        } while (opcao != 6);
    }
}