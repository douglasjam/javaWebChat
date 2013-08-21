package chat;


import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leandro Cesar
 */
public class Usuario {

    String apelido;
    Date dataHoraEntrada;

    public Usuario(String apelido, Date dataHoraEntrada) {
        this.apelido = apelido;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }
    
    @Override
    public String toString() {
        return this.getApelido();
    }
}
