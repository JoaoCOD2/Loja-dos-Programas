package lojadosprograma;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoLoja {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        LocalTime horaBrasilia = LocalTime.now(ZoneId.of("America/Sao_Paulo"));
        int hora = horaBrasilia.getHour();

        if (hora >= 5 && hora < 12) {
            System.out.println("Bom dia! Seja Bem-vindo a loja dos programas!");
        } else if (hora >= 12 && hora < 18) {
            System.out.println("Boa tarde! Seja Bem-vindo a loja dos programas!");
        } else {
            System.out.println("Boa noite! Seja Bem-vindo a loja dos programas!");
        }

        int opcao;

        do {

            Thread.sleep(1500);

            System.out.println("\nDigite a opção que deseja no menu:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Cadastrar cliente");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Exibir vendas");
            System.out.println("6 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    Thread.sleep(1500);

                    System.out.println("Qual produto deseja cadastrar?");
                    System.out.println("1 - Eletrônico");
                    System.out.println("2 - Roupa");
                    System.out.println("3 - Alimento");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Thread.sleep(1500);

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    if (tipo == 1) {

                        System.out.print("Marca: ");
                        String marca = sc.nextLine();

                        System.out.print("Voltagem: ");
                        String voltagem = sc.nextLine();

                        System.out.print("Garantia (meses):");
                        int garantia = sc.nextInt();
                        sc.nextLine();

                        Eletronico eletronico = new Eletronico(nome, preco, categoria, marca, voltagem, garantia);

                        produtos.add(eletronico);

                        System.out.println("Eletrônico cadastrado!");

                    } else if (tipo == 2) {

                        System.out.print("Tamanho: ");
                        String tamanho = sc.nextLine();

                        System.out.print("Modelagem: ");
                        String modelagem = sc.nextLine();

                        System.out.print("Marca: ");
                        String marca = sc.nextLine();

                        Roupa roupa = new Roupa(nome, preco, categoria, tamanho, modelagem, marca);

                        produtos.add(roupa);

                        System.out.print("Roupa cadastrada!");

                    } else if (tipo == 3) {

                        System.out.print("Data de validade: ");
                        String validade = sc.nextLine();

                        System.out.print("Peso:");
                        double peso = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Marca: ");
                        String marca = sc.nextLine();

                        Alimento alimento = new Alimento(nome, preco, categoria, validade, peso, marca);

                        produtos.add(alimento);

                        System.out.println("Alimento cadastrado!");
                    }

                    break;

                case 2:
                    Thread.sleep(1500);
                    System.out.println("Para cadastrar o cliente, insira as seguintes informações");
                    Thread.sleep(1500);

                    System.out.print("Nome: ");
                    String nomeC = sc.nextLine();

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    Cliente cliente = new Cliente(nomeC, email, cpf);

                    clientes.add(cliente);

                    System.out.println("Seu e-mail está sendo cadastrado!");
                    Thread.sleep(1000);
                    System.out.println("Um e-mail confirmando seu cadastro chegará na sua saixa de entrada.");

                    EmailService.enviarEmail(email, nomeC);

                    Thread.sleep(1500);

                    System.out.println("Cliente Cadastrado!");

                    break;
                    

                case 3:

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado");
                        break;
                    }

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado");
                        break;
                    }

                    System.out.println("\nClientes cadastrados:");

                    for (int i = 1; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }

                    System.out.print("Escolha o cliente: ");
                    int clienteIndex = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteSelecionado = clientes.get(clienteIndex);

                    System.out.println("\nProdutos disponíveis:");

                    for (int i = 1; i < produtos.size(); i++) {
                        System.out.println(i + " - " + produtos.get(i).getNome()
                                + " | Preço: " + produtos.get(i).calcularPrecoFinal());
                    }

                    System.out.print("Escolha o produto: ");
                    int produtoIndex = sc.nextInt();
                    sc.nextLine();

                    Produto produtoSelecionado = produtos.get(produtoIndex);

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    int idVenda = vendas.size() + 1;

                    Venda venda = new Venda(idVenda, clienteSelecionado, produtoSelecionado, quantidade);

                    vendas.add(venda);
                    
                    Thread.sleep(1500);
                    
                    System.out.println("Venda realizada com sucesso!");
                    venda.exibirVenda();

                    break;

                    
                case 4:

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {

                        System.out.println("\nLista de produtos:");

                        for (Produto p : produtos) {

                            System.out.println("----------------------");
                            System.out.println("Nome: " + p.getNome());
                            System.out.println("Categoria: " + p.getCategoria());
                            System.out.println("Preço base: " + p.getPreco());
                            System.out.println("Preço final: " + p.calcularPrecoFinal());
                        }
                    }

                    break;

                case 5:
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda realizada!");
                    } else {
                        System.out.println("\nLista de vendas: ");

                        for (Venda v : vendas) {
                            System.out.println("-----------------------");
                            v.exibirVenda();
                        }
                    }

                    break;

                case 6:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

    }
}
