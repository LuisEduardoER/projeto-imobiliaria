/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.joda.time.DateTime;
import java.util.List;
/**
 *
 * @author Bruno
 */

public class Venda {
    
    private int idVenda;
    private float valor;
    private List<Produto> itens;
    private Funcionario vendedor;
    private Funcionario superior;
    private List<ProdutoRemovido> itensRemovidos;
    private DateTime horaVenda;

    public Venda() {
    }

    public Venda(float valor, List<Produto> itens, Funcionario vendedor, Funcionario superior, List<ProdutoRemovido> itensRemovidos, DateTime horaVenda) {
        this.valor = valor;
        this.itens = itens;
        this.vendedor = vendedor;
        this.superior = superior;
        this.itensRemovidos = itensRemovidos;
        this.horaVenda = horaVenda;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Funcionario getSuperior() {
        return superior;
    }

    public void setSuperior(Funcionario superior) {
        this.superior = superior;
    }

    public List<ProdutoRemovido> getItensRemovidos() {
        return itensRemovidos;
    }

    public void setItensRemovidos(List<ProdutoRemovido> itensRemovidos) {
        this.itensRemovidos = itensRemovidos;
    }

    public DateTime getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(DateTime horaVenda) {
        this.horaVenda = horaVenda;
    }

}
