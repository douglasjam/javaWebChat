<%-- 
    Document   : formulario
    Created on : 26/10/2011, 15:37:24
    Author     : Leandro Cesar
--%>

<%@page import="chat.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <link type="text/css" href="css/estilo.css" rel="stylesheet" />
    </head>
    <body>
        <div id="formularioMensagem">
            <form name="formEnvia" action="trataMsg" method="POST">
                <%  Usuario usuarioAtual = (Usuario) request.getSession().getAttribute("usuario");%>
                <%= usuarioAtual.getApelido()%>
                <input type="text" name="mensagem" value="" size="90" />
                <input type="text" id="destino" name="destino" value="<%= (request.getParameter("destino") == null ? "Todos" : request.getParameter("destino"))%>" readonly />
                <input type="checkbox" name="reservado" value="1" />Reservado
                <input type="submit" id="enviar" value="Enviar" />
                <input type="button" id="sair" value="Sair" onclick="parent.window.location = 'index.jsp?acao=sair'"/>
                <br />
            </form>
        </div>
    </body>
</html>
