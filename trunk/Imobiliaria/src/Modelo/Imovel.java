/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Mensagens;

/**
 *
 * @author Bruno
 */
public class Imovel {
    
    int idImovel;
    int quarto;
    int suite;
    int banheiros;
    int lavabo;
    int sacada;
    int churrasqueira;
    int closet;
    int cozinha;
    int andares;
    int proprietarioID;
                
    float tamanho; 
    
    boolean comercial;
    
    boolean sotao;
    boolean porao;
    
    boolean locacao;
    float valorLocacao;
    
    boolean venda;
    float valorVenda;
    
    
    
    boolean terrenoSobra;
    
    boolean piscina;
    float tamanhoPiscina;
    
    Telhado tipoTelhado;
    Forro tipoForro;
    Garagem garagem;
    Embutido embutidos;
    Mobilia moveis;
    Endereco endereco;
    Sala sala;
    Documento idDocumento;
    Construcao construcao;

    public int getProprietarioID() {
        return proprietarioID;
    }

    public void setProprietarioID(int proprietarioID) {
        try{
            Pessoa p = new Pessoa();
            this.proprietarioID = p.getProprietarioID;
        }catch (NumberFormatException e){
            Mensagens m = new Mensagens("Identificador de proprietário não válido!\n"+e.getMessage());
        }
    }
    
    public int getBanheiro() {
        return banheiros;
    }

    public void setBanheiro(int banheiro) {
        this.banheiros = banheiro;
    }

    public int getChurrasqueira() {
        return churrasqueira;
    }

    public void setChurrasqueira(int churrasqueira) {
        this.churrasqueira = churrasqueira;
    }

    public boolean isComercial() {
        return comercial;
    }

    public void setComercial(boolean comercial) {
        this.comercial = comercial;
    }

    public int getCozinha() {
        return cozinha;
    }

    public void setCozinha(int cozinha) {
        this.cozinha = cozinha;
    }

    public Embutido getEmbutidos() {
        return embutidos;
    }

    public void setEmbutidos(Embutido embutidos) {
        this.embutidos = embutidos;
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem;
    }

    public int getCloset() {
        return closet;
    }

    public void setIdCloset(int idCloset) {
        this.closet = idCloset;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public int getLavabo() {
        return lavabo;
    }

    public void setLavabo(int lavabo) {
        this.lavabo = lavabo;
    }

    public boolean isLocacao() {
        return locacao;
    }

    public void setLocacao(boolean locacao) {
        this.locacao = locacao;
    }

    public Mobilia getMoveis() {
        return moveis;
    }

    public void setMoveis(Mobilia moveis) {
        this.moveis = moveis;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getSacada() {
        return sacada;
    }

    public void setSacada(int sacada) {
        this.sacada = sacada;
    }

    public int getSuite() {
        return suite;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getTamanhoPiscina() {
        return tamanhoPiscina;
    }

    public void setTamanhoPiscina(float tamanhoPiscina) {
        this.tamanhoPiscina = tamanhoPiscina;
    }

    public boolean isTerrenoSobra() {
        return terrenoSobra;
    }

    public void setTerrenoSobra(boolean terrenoSobra) {
        this.terrenoSobra = terrenoSobra;
    }

    public Forro getTipoForro() {
        return tipoForro;
    }

    public void setTipoForro(Forro tipoForro) {
        this.tipoForro = tipoForro;
    }

    public Telhado getTipoTelhado() {
        return tipoTelhado;
    }

    public void setTipoTelhado(Telhado tipoTelhado) {
        this.tipoTelhado = tipoTelhado;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public boolean isVenda() {
        return venda;
    }

    public void setVenda(boolean venda) {
        this.venda = venda;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }
}
