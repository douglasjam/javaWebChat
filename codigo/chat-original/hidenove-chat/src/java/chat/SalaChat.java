package chat;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leandro Cesar
 */
public class SalaChat extends HttpServlet {

    Historico historico;

    @Override
    public void init() {
        historico = new Historico();
        this.getServletContext().setAttribute("historico", historico);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Usuario usuarioSessao = (Usuario) request.getSession().getAttribute("usuario");
        String apelidoForm = request.getParameter("apelido");

        historico = (Historico) request.getSession().getServletContext().getAttribute("historico");
        synchronized (historico) {
        };

        if (usuarioSessao == null) {
            //out.write("usuario sem sessao<br />");
            if (apelidoForm.equals("")) {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("O apelido não pode ser nulo.", "UTF-8"));
            } else if (historico.usuarioLogado(apelidoForm)) {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Já existe um usuário com este apelido, por favor escolha outro.", "UTF-8"));
            } else {
                Usuario novoUsuario = new Usuario(apelidoForm, new Date());
                request.getSession().setAttribute("usuario", novoUsuario);
                request.getSession().setMaxInactiveInterval(500);

                historico.addUsuario(novoUsuario);
                out.write("Usuario \"" + novoUsuario.getApelido() + "\" entrou as " + novoUsuario.getDataHoraEntrada().toString());
                response.sendRedirect("salachat.jsp");
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Você já possui uma sessão válida, <a href=\"salachat.jsp\">clique aqui</a> para voltar para o chat", "UTF-8"));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
