/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.joda.time.DateTime;

/**
 *
 * @author Bruno
 */
public class ProdutoRemovido {
    private DateTime dataHora;
    private Produto item;
    private Venda venda;
    private Funcionario superior;

    public ProdutoRemovido() {
    }

    public ProdutoRemovido(DateTime dataHora, Produto item, Venda venda, Funcionario superior) {
        this.dataHora = dataHora;
        this.item = item;
        this.venda = venda;
        this.superior = superior;
    }

    public DateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(DateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Produto getItem() {
        return item;
    }

    public void setItem(Produto item) {
        this.item = item;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Funcionario getSuperior() {
        return superior;
    }

    public void setSuperior(Funcionario superior) {
        this.superior = superior;
    }
}
