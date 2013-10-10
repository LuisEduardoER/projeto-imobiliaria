/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Funcionario;

/**
 *
 * @author Bruno
 */
public class TableModelFuncionario extends AbstractTableModel {

    // Lista de Sócios a serem exibidos na tabela
    private List<Funcionario> linhas;

    
    
    // Cria um SocioTableModel sem nenhuma linha
    public TableModelFuncionario() {
        linhas = new ArrayList<Funcionario>();
    }

    // Cria um SocioTableModel contendo a lista recebida por parâmetro
    public TableModelFuncionario(List<Funcionario> listaDeFuncionario) {
        linhas = new ArrayList<Funcionario>(listaDeFuncionario);
    }
    private String[] colunas = new String[]{"Codigo", "Nome", "CPF", "Login"};
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int CPF = 2;
    private static final int LOGIN = 3;

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
            case NOME:
                return Integer.class;
            case CPF:
                return String.class;
            case LOGIN:
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
        Funcionario funcionario = linhas.get(rowIndex);

        switch (columnIndex) {
            case CODIGO:
                return funcionario.getIdFuncionario();
            case NOME:
                return funcionario.getNome();
            case CPF:
                return funcionario.getCpfCnpj();
            case LOGIN:
                return funcionario.getIdUsuario().getUsuarioName();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Funcionario funcionario = linhas.get(rowIndex);

        switch (columnIndex) {

            case NOME:
                funcionario.setNome((String) aValue);
                break;
            case CPF:
                funcionario.setCpfCnpj((Integer) aValue);
            case LOGIN:
                funcionario.getIdUsuario().setUsuarioName((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Funcionario getFuncionario(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addFuncionario(Funcionario funcionarios) {
        linhas.add(funcionarios);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeProduto(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeProdutos(List<Funcionario> funcionarios) {
        int indice = getRowCount();
        linhas.addAll(funcionarios);
        fireTableRowsInserted(indice, indice + funcionarios.size());
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
