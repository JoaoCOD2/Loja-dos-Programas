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
public class Alimento extends Produto {

    private String validade;
    private double peso;
    private String marca;

    public Alimento(String nome, double preco, String categoria, String validade, double peso, String marca) {
        super(nome, categoria, preco);
        this.validade = validade;
        this.peso = peso;
        this.marca = marca;
    }

    public String getValidade() {
        return validade;
    }

    public double getPeso() {
        return peso;
    }

    public String getMarca() {
        return marca;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco();
    }
}
