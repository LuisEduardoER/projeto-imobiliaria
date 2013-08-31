/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Compra;

/**
 *
 * @author Bruno
 */
public class TableModelCompra extends AbstractTableModel {

    // Lista de Sócios a serem exibidos na tabela
    private List<Compra> linhas;

    // Cria um SocioTableModel sem nenhuma linha
    public TableModelCompra() {
        linhas = new ArrayList<Compra>();
    }

    // Cria um SocioTableModel contendo a lista recebida por parâmetro
    public TableModelCompra(List<Compra> listaDeProdutos) {
        linhas = new ArrayList<Compra>(listaDeProdutos);
    }
    private String[] colunas = new String[]{"Codigo", "Produto", "Fornecedor", "Valor"};
    private static final int CODIGO = 0;
    private static final int PRODUTO = 1;
    private static final int FORNECEDOR = 3;
    private static final int VALOR = 4;

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
            case PRODUTO:
                return String.class;
            case FORNECEDOR:
                return String.class;
            case VALOR:
                return Float.class;
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
        Compra compra = linhas.get(rowIndex);

        switch (columnIndex) {
            case CODIGO:
                return compra.getCompraId();
            case PRODUTO:
                return compra.getProdutoId().getProdutoNome();
            case VALOR:
                return compra.getValorCompra();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        // Pega o sócio referente a linha especificada.
//        Compra compra = linhas.get(rowIndex);
//
//        switch (columnIndex) {
//
//            case PRODUTO:
//                produto.setProdutoNome((String) aValue);
//            case VALOR:
//                produto.setValor((Float) aValue);
//                break;
//            default:
//                throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//        fireTableCellUpdated(rowIndex, columnIndex);
//    }

    public Compra getCompra(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addComrpa(Compra compra) {
        linhas.add(compra);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeCompra(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeCompras(List<Compra> compra) {
        int indice = getRowCount();
        linhas.addAll(compra);
        fireTableRowsInserted(indice, indice + compra.size());
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
