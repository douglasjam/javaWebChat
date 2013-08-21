package chat;

import java.util.ArrayList;

/**
 *
 * @author Douglas J.A.M
 */
public class Historico {

    public ArrayList<Mensagem> historico;
    public ArrayList<Usuario> usuarios;

    public Historico() {
        historico = new ArrayList<Mensagem>();
        usuarios = new ArrayList<Usuario>();
    }

    public boolean usuarioLogado(String apelido) {
        for (Usuario usuario : usuarios) {
            if (usuario.getApelido().equals(apelido)) {
                return true;
            }
        }
        return false;
    }

    public void addMensagem(Mensagem mensagem) {
        historico.add(mensagem);
        System.out.println("Mensagem adicionada com sucesso: s" + mensagem.toString());
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario " + usuario.getApelido() + " saiu do chat!");
    }

    public void remUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuario " + usuario.getApelido() + " saiu do chat!");
    }

    public ArrayList<Mensagem> getHistorico(String apelido) {
        ArrayList<Mensagem> mensagemUsuario = new ArrayList<Mensagem>();
        for (Mensagem x : historico) {
            if (((x.getApelidoDestino().equals(apelido) || x.getApelidoOrigem().equals(apelido)) && (x.getReservado() == 1))
                    || (x.getReservado() == 0)) {
                mensagemUsuario.add(x);
            }
        }
        return mensagemUsuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
