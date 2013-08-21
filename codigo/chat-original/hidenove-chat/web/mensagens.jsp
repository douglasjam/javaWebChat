<%-- 
    Document   : mensagens
    Created on : 26/10/2011, 15:31:40
    Author     : Leandro Cesar
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="1">
        <title>Mensagens</title>
        <link type="text/css" href="css/estilo.css" rel="stylesheet" />
        <script tyApe="text/javascript" src="js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
        <script>
            $(function() {
                 $('#mensagensTextArea').scrollTop($('#mensagensTextArea')[0].scrollHeight);
            });
            function carrega(){
                document.getElementById("mensagensTextArea").scrollTop = document.getElementById("mensagensTextArea").scrollHeight;
              
            };
            function trocaUsuario(){
                novoUsuario = document.getElementById("usuariosList").value;
                parent.frameFormulario.document.formEnvia.destino.value = novoUsuario;
  
            }
           
        </script>
    </head>
    <body onload="carrega();">
        <div id="chat">
            <div id="cabecalho">
                Chat Hidenove
            </div>
            <div id="mensagens">
<textarea id="mensagensTextArea" readonly cols="100" rows="20" a><%@page import="chat.Historico"%> 
<%@page import="chat.Usuario"%>
<%@page import="chat.Mensagem"%>      
<%
Historico historico = (Historico) request.getSession().getServletContext().getAttribute("historico");
Usuario usuarioAtual = (Usuario)request.getSession().getAttribute("usuario");
ArrayList<Mensagem> msg = historico.getHistorico(usuarioAtual.getApelido());
int j;
for (j = 0; j < msg.size(); j++) {
%>
<%=msg.get(j)%>
<%}%>
</textarea>
            </div>
            <div id="usuarios">
                <select id="usuariosList" size="10" onchange="trocaUsuario();"> 
                    <option>Todos</option>
                    <%ArrayList<Usuario> usuario = ((Historico) request.getSession().getServletContext().getAttribute("historico")).getUsuarios();
                        for (j = 0; j < usuario.size(); j++) {
                    %>  

                    <option><%=usuario.get(j)%></option>
                    <%}%>
                </select>
            </div>
        </div>
    </body>
</html>
