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
public class Eletronico extends Produto {

    private String marca;
    private String voltagem;
    private int garantiaMeses;

    public Eletronico(String nome, double preco, String categoria, String marca, String voltagem, int garantiaMeses) {
        super(nome, categoria, preco);
        this.marca = marca;
        this.voltagem = voltagem;
        this.garantiaMeses = garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() * 1.10;
    }
}
