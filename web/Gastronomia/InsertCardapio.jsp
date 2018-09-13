<%@page import="java.sql.*, java.io.*, java.util.*, javax.servlet.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class='container'>
            <h1>Cadastro</h1>
            <form class='form-horizontal' action='InsertCategoria' method='POST'>
                <div class='form-group'>
                    <label for='nome' class='col-sm-2 control-label'>Nome</label>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' id='nome' name='nome'/>
                    </div>
                </div>
                <div class="form-group">
                    <label for='descricao' class='col-sm-2 control-label'>Descrição</label>
                    <div class='col-sm-10'>
                        <input type='text' class='form-control' id='descricao' name='descricao'/>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
