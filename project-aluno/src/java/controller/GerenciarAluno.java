/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.AlunoDAO;

/**
 *
 * @author LucasPC
 */
public class GerenciarAluno extends HttpServlet {

/**
 *
 * @author LucasPC
 */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();
        String mensagem="";
        
        String acao = request.getParameter("acao");
        String matricula = request.getParameter("matricula");
        
        Aluno a = new Aluno();
        
        try {
            
            AlunoDAO aDAO = new AlunoDAO();
            if(acao.equals("alterar")){
                a = aDAO.getCarregaPorMatricula(Integer.parseInt(matricula));
                if(a.getMatricula()>0){
                    RequestDispatcher disp =  getServletContext().getRequestDispatcher("/form_aluno.jsp");
                    request.setAttribute("aluno", a);
                    disp.forward(request, response);
                    
                }else{
                    mensagem = "Aluno não Encontrado!";
                }
                
                
            }
            
            if(acao.equals("deletar")){
                a.setMatricula(Integer.parseInt(matricula));
                if(aDAO.deletar(a));
                    mensagem = "Aluno deletado com sucesso!";
                            
            }else{
                mensagem= "Erro ao excluir o Aluno!";
            }
            
        }catch(Exception e){
                out.print(e);
                mensagem = "Erro ao executar";
            } 
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_aluno.jsp';");
        out.println("</script>");
        
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        PrintWriter out = response.getWriter();
        
        String matricula = request.getParameter("matricula");
        String nome= request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String idade = request.getParameter("idade");
        
        String mensagem = "";
        
        Aluno a = new Aluno();
        
        try{
            AlunoDAO aDAO = new AlunoDAO();
            if(!matricula.isEmpty()){
                a.setMatricula(Integer.parseInt(matricula));          
            }

            if(nome.equals("") || endereco.equals("") || telefone.equals("") || idade.equals("")){
                mensagem = "Campos obrigatórios deverão ser preenchidos!";
            }else{
                a.setNome(nome);
                a.setEndereco(endereco);
                a.setTelefone(telefone);
                a.setIdade(Integer.parseInt(idade));
                if (aDAO.gravar(a)){
                    mensagem = "Aluno Gravado com sucesso!";
            }else{
                    mensagem = "Erro ao gravar o aluno no Banco!";
                    }
            }
            
        }catch(Exception e){
            out.print(e);
            mensagem = "Erro ao executar";
            
        }
        
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_aluno.jsp';");
        out.println("</script>");
    
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}


