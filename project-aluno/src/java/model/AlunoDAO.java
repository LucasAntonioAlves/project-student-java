
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class AlunoDAO extends DataBaseDAO{
    
    public AlunoDAO() throws Exception {
    }
    
    public ArrayList<Aluno> getLista() throws Exception{
        
        ArrayList<Aluno>  lista = new ArrayList<Aluno>();
        String sql = "SELECT * FROM aluno";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Aluno a = new Aluno();
            a.setMatricula(rs.getInt("matricula"));
            a.setNome(rs.getString("nome"));
            a.setEndereco(rs.getString("endereco"));
            a.setTelefone(rs.getString("telefone"));
            a.setIdade(rs.getInt("idade")); 
            lista.add(a);
        }
        this.desconectar();
        return lista;
        
        
    }
    
    public boolean gravar(Aluno a){
        
        try{
            String sql;
            this.conectar();
            if(a.getMatricula()==0){
                sql = "INSERT INTO aluno (nome, endereco, telefone, idade) VALUES(?,?,?,?)";
            }else{ 
                sql = "UPDATE aluno SET nome=?, endereco=?, telefone=?, idade=? WHERE matricula=?";
            }
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,a.getNome());
            pstm.setString(2, a.getEndereco());
            pstm.setString(3, a.getTelefone());
            pstm.setInt(4, a.getIdade());
            if(a.getMatricula()>0){
                pstm.setInt(5,a.getMatricula());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
            
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }  
    }
    
    public Aluno getCarregaPorMatricula(int matricula) throws Exception {
        Aluno a = new Aluno();
        String sql = "SELECT * FROM aluno WHERE matricula=?";
        this.conectar();
        PreparedStatement pstm =  conn.prepareStatement(sql);
        pstm.setInt(1, matricula);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            a.setMatricula(rs.getInt("matricula"));
            a.setNome(rs.getString("nome"));
            a.setEndereco(rs.getString("endereco"));
            a.setTelefone(rs.getString("telefone"));
            a.setIdade(rs.getInt("idade"));
            
            
        }
        
        this.desconectar();
        return a;
        
    }
    
    public boolean deletar (Aluno a){
        try{
            this.conectar();
            String sql=" DELETE FROM aluno WHERE matricula=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, a.getMatricula());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
}
