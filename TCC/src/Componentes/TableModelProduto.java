/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cadastro.Adminsitrativo.Produto;

/**
 *
 * @author Bruno
 */
public class TableModelProduto extends AbstractTableModel {

    // Lista de Sócios a serem exibidos na tabela
    private List<Produto> linhas;

    
    
    // Cria um SocioTableModel sem nenhuma linha
    public TableModelProduto() {
        linhas = new ArrayList<Produto>();
    }

    // Cria um SocioTableModel contendo a lista recebida por parâmetro
    public TableModelProduto(List<Produto> listaDeProdutos) {
        linhas = new ArrayList<Produto>(listaDeProdutos);
    }
    private String[] colunas = new String[]{"Codigo", "Codigo de Barras", "Produto", "Valor", "Fabricante", "Fornecedor"};
    private static final int CODIGO = 0;
    private static final int CODIGO_BARRAS = 1;
    private static final int PRODUTO = 2;
    private static final int VALOR = 3;
    private static final int FABRICANTE = 4;
    private static final int FORNECEDOR = 5;

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case CODIGO:
                return Integer.class;
            case CODIGO_BARRAS:
                return Integer.class;
            case PRODUTO:
                return String.class;
            case VALOR:
                return Float.class;
            case FABRICANTE:
                return String.class;
            case FORNECEDOR:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Produto produto = linhas.get(rowIndex);

        switch (columnIndex) {
            case CODIGO:
                return produto.getProduto_id();
            case CODIGO_BARRAS:
                return produto.getProdutoCodigoBarras();
            case PRODUTO:
                return produto.getProdutoNome();
            case VALOR:
                return produto.getValor();
            case FABRICANTE:
                if (produto.getFabricanteId().getFabricanteNome() != null) {
                    return produto.getFabricanteId().getFabricanteNome();
                } else {
                    return "";
                }

            case FORNECEDOR:
                if (produto.getFornecedorId().getFornecedorNome() != null) {
                    return produto.getFornecedorId().getFornecedorNome();
                } else {
                    return "";
                }
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Produto produto = linhas.get(rowIndex);

        switch (columnIndex) {

            case CODIGO_BARRAS:
                produto.setProdutoCodigoBarras((String) aValue);
                break;
            case PRODUTO:
                produto.setProdutoNome((String) aValue);
            case VALOR:
                produto.setValor((Float) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Produto getProduto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addProduto(Produto produto) {
        linhas.add(produto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeProduto(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeProdutos(List<Produto> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
