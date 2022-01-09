<%-- 
    Document   : index
    Created on : 19/02/2020, 10:21:16
    Author     : Administrador
--%>

<%@page import="model.AlunoDAO"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alunos</title>
            <script type="text/javascript">
                function confirmarExclusao(id,nome){
                    if(confirm('Deseja realmente excluir o aluno ' +nome+ '?'))
                        location.href="gerenciar_aluno.do?acao=deletar&matricula="+id;
                }
            </script>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1,
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
    </head>
         
        
            <body>
          <div id="interface">
         
          <%@include file="menu.jsp" %>
      
        <h1>Lista de Alunos</h1>
         
        <a href="form_aluno.jsp" class="btn btn-primary">
            Novo Cadastro de Aluno</a>
        
        
        <table class="table table-hover table-striped table-bordered"
               id="listarAluno"><br/><br/>
            
           
            
            <thead>
                <tr>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Idade</th>
                    <th>Opções</th>
                </tr>
            </thead>
            
            
            <tfoot>
                <tr>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Idade</th>
                    <th>Opções</th>
                </tr>
            </tfoot>

            
                <jsp:useBean class="model.AlunoDAO" id="aDAO"/>
            <tbody>
                 <c:forEach var="a" items="${aDAO.lista}">
            
            <tr>
                    <td>${a.matricula}</td>
                    <td>${a.nome}</td>
                    <td>${a.endereco}</td>
                    <td>${a.telefone}</td>
                    <td>${a.idade} anos</td>
                    
                <td>
                    <a href="gerenciar_aluno.do?acao=alterar&matricula=${a.matricula}" class="btn btn-primary">
                        <i class="glyphicon glyphicon-pencil"></i>
                    </a>
                    <button class="btn btn-danger" onclick="confirmarExclusao(${a.matricula}, '${a.nome}')">
                        <i class="glyphicon glyphicon-trash"></i>
                    </button>
                </td>
            </tr>
                
                </c:forEach>
             </tbody>
             
             
        </table>
                <script type="text/javascript" src="datatables/jquery.js"></script>
                <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
                <script type="text/javascript">
                    $(document).ready(function(){
                        $("#listarAluno").dataTable({
                            "bJQueryUI": true,
                            "oLanguage": {
                                "sProcessing":"Processando...",
                                "sLenghtMenu":"Mostrar _MENU_registros",
                                "sZeroRecords": "Não foram encontrados resultados",
                                "sInfo": "Mostrar de _START_ ate _END_ de _TOTAL_ registros",
                                "sInfoEmpty": "Mostrando de 0 ate 0 de 0 registros",
                                "sInfoFiltered": "",
                                "sInfoPostFix": "",
                                "sSearch": "Pesquisar",
                                "sUrl": "",
                                "oPaginate": {
                                    "sFirst": "Primeiro",
                                    "sPrevious": "Anterior",
                                    "sNext": "Próximo",
                                    "sLast": "Último"
                                 
                                    
                                }
                            }
                        });
                    });
                </script>
                
    </body>
        </div>
</html>
