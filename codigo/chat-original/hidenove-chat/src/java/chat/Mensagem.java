package chat;

import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Douglas J.A.M
 */
public class Mensagem {

    String apelidoOrigem;
    String apelidoDestino;
    Date datahora;
    String mensagem;
    int reservado;
    

    public Mensagem(String apelidoOrigem, String apelidoDestino, Date datahora, String mensagem, int reservado) {
        this.apelidoOrigem = apelidoOrigem;
        this.apelidoDestino = apelidoDestino;
        this.datahora = datahora;
        this.mensagem = mensagem;
        this.reservado = reservado;
    }

    public String getApelidoDestino() {
        return apelidoDestino;
    }

    public void setApelidoDestino(String apelidoDestino) {
        this.apelidoDestino = apelidoDestino;
    }

    public String getApelidoOrigem() {
        return apelidoOrigem;
    }
    
    public int getReservado() {
        return reservado;
    }

    public void setApelidoOrigem(String apelidoOrigem) {
        this.apelidoOrigem = apelidoOrigem;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void setReservador(int reservado){
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        String mensagem = (this.getReservado() == 1 ? "(Reservado) " : "") + "De " + this.getApelidoOrigem() + ", para "
                + apelidoDestino + " (" + DateUtil.fullDateToString(this.getDatahora()) + "): "
                + this.getMensagem();

        return mensagem;
    }
}
