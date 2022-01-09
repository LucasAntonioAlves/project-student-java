<%-- 
    Document   : index
    Created on : 19/02/2020, 10:21:16
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Aluno</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1,
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
    </head>
         <div id="interface">
    <body>
        <%@include file="menu.jsp" %>
        <h3>Cadastrar Aluno</h3>
        
        <form action="gerenciar_aluno.do" method="POST">
            <input type="hidden" name="matricula" id="matricula" value="${aluno.matricula}"/>
            <div class="row">
                <div class="form-group col-sm-5">
                     <label for="nome" class="control-label">Nome Aluno</label>
                     <input type="text" name="nome" id="nome" required=""
                            maxlength="45" value="${aluno.nome}" class="form-control"/>
                </div>
                
                <div class="form-group col-sm-5">
                     <label for="endereco" class="control-label">Endereço</label>
                     <input type="text" name="endereco" id="endereco" required=""
                            maxlength="45" value="${aluno.endereco}" class="form-control"/>
                </div>
                
                <div class="form-group col-sm-5">
                     <label for="telefone" class="control-label">Telefone</label>
                     <input type="text" name="telefone" id="telefone" required=""
                            maxlength="45" value="${aluno.telefone}" class="form-control"/>
                </div>
                
                <div class="form-group col-sm-5">
                     <label for="idade" class="control-label">Idade</label>
                     <input type="text" name="idade" id="idade" required=""
                            maxlength="45" value="${aluno.idade}" class="form-control"/>
                </div>
               
                
            </div>
            
            <div class="">
                <button class="btn btn-success">Gravar</button>
                 
                <a href="listar_aluno.jsp" class="btn btn-warning">
                    Voltar
                </a>
            </div>
          
        </form>
        
    </body>
         </div>
</html>
