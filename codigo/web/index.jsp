<%@page import="chat.Usuario"%>
<%@page import="chat.Historico"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Hidenove Chat</title>
        <link type="text/css" href="css/estilo.css" rel="stylesheet" />
        <link type="text/css" href="css/smoothness/jquery-ui-1.8.16.custom.css" rel="stylesheet" />	
        <script tyApe="text/javascript" src="js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>

        <style type="text/css">
            /*demo page css*/
            body{ font: 12px "Trebuchet MS", sans-serif; margin: 50px;}
        </style>
        <%            
            if (request.getParameter("acao") != null) {
                Usuario usuarioAtual = (Usuario) request.getSession().getAttribute("usuario");                
                Historico historico = (Historico) request.getSession().getServletContext().getAttribute("historico");
                historico.remUsuario(usuarioAtual);
                request.getSession().invalidate();                
            }
        %>
    </head>
    <body>
        <div id="login">
            <h1>Hidenove Chat</h1>
            Digite um apelido para entrar
            <form method="POST" action="SalaChat">
                Apelido: <input  type="text" name="apelido" value=""/><br />
                <input type="hidden" name="acao" value="entrar" />
                <input type="submit" value="Entrar" />
                <br /><b style="color: #FF0000">
                    <%= request.getParameter("mensagem") == null ? "" : request.getParameter("mensagem")%>
                    <%= request.getParameter("acao") == null ? "" : "Você saiu do chat com sucesso! "%></b>
            </form>
        </div>
    </body>
</html>


