/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadosprograma;

/**
 *
 * @author aluno.saolucas
 */
public class Venda {

    private int id;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Venda(int id, Cliente cliente, Produto produto, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = calcularTotal();
    }

    public double calcularTotal() {
        return produto.calcularPrecoFinal() * quantidade;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = calcularTotal();
    }

    public void exibirVenda() {
        System.out.println("ID da venda: " + id);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor total: " + valorTotal);
    }
}

