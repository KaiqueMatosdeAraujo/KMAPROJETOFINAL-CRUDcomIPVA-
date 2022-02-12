package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Conexao;


public class DAO {

	
	public DAO() {
		
	}
	
	
	
	//INSERÇÃO NA TABELA CARRO 
	
	public void novoCarro(Carro newCarro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carro (modelo, ano) values (?,?)");
			p.setString(1, newCarro.getModelo());
			p.setInt(2, newCarro.getAno());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Enviado para o Banco de Dados na tabela CARRO");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	//
	//
	//                     RETORNO DA LISTA DE CARROS CADASTRADOS
	//
	//
	
	
	
	public ArrayList<Carro> listaDeCarro(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carro> list = new ArrayList<Carro>();
		try {
			PreparedStatement p = con.prepareStatement("select * from carro");
			ResultSet resultado = p.executeQuery();			
			
			while (resultado.next()) {
				Integer id = resultado.getInt("idcarroSql");
				String modelo = resultado.getString("modelo");
				Integer ano = resultado.getInt("ano");
		        Carro carro1 = new Carro(modelo, ano);
				carro1.setIdcarro(id);
				list.add(carro1);
				
			}
			resultado.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	//
	//
	//                    REMOÇÃO DE CARROS 
	//
	//

	
	
	
	public void removerCarro(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carro where idcarroSql = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Registro de Carro Excluido");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	
	
	

	//
	//
	//                    ATUALIZAÇÃO DE CARROS 
	//
	//

	
	
	
	

	public void updateCarro(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update carro set modelo = ?, ano = ? where idcarroSql = ?");
			
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());
			p.setInt(3, carro.getIdcarro());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	

	
//	

	//
	//
	//                    BUSCAR CARROS
	//
	//


	
	
	
	
	public Carro buscarCarro(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Carro  veiculo = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from carro where idcarroSql = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				
				
				String modeloCarro = r.getString("modelo");
				Integer anoCarro = r.getInt("ano");
				veiculo = new Carro(modeloCarro, anoCarro);
				veiculo.setIdcarro(id);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return veiculo;
	}
 
	
	
}
