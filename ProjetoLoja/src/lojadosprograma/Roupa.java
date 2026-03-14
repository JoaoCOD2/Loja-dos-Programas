/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadosprograma;

    public class Roupa extends Produto {

        private String tamanho;
        private String modelagem;
        private String marca;

        public Roupa(String nome, double preco, String categoria, String tamanho, String modelagem, String marca) {
            super(nome, categoria, preco);

            this.tamanho = tamanho;
            this.modelagem = modelagem;
            this.marca = marca;
        }

        public String getTamanho() {
            return tamanho;
        }

        public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
        }

        public String getModelagem() {
            return modelagem;
        }

        public void setModelagem(String modelagem) {
            this.modelagem = modelagem;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        @Override
        public double calcularPrecoFinal() {
            return getPreco() * 0.95;
        }
    }
