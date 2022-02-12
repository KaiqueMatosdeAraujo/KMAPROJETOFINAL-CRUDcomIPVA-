package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Conexao;

public class DAOipva {

public DAOipva() {
		
	}
	

                                 /// ADICIONAR REGISTROS DE IPVA

public void newIpva(Ipva ipva) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("insert into ipva (ano) values (?)");
		p.setInt(1, ipva.getAno());
		System.out.println(p);
		p.executeUpdate();
		System.out.println("IPVA Adicionado no Banco");
		p.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

                      //PERCORRENDO POR TODOS OS REGISTROS                                    


public ArrayList<Ipva> ipvaList(){
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	ArrayList<Ipva> l = new ArrayList<Ipva>();
	try {
		PreparedStatement p = con.prepareStatement("select * from ipva");
		ResultSet r = p.executeQuery();			
		
		while (r.next()) {
			Integer id = r.getInt("id");
			Integer anoIpva = r.getInt("ano");
			
			Ipva nI = new Ipva(anoIpva);
			nI.setId(id);
			l.add(nI);
		}
		r.close();
		p.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
}


                //// REMOÇÃO DE REGISTROS 


public void excluirIpva(Integer id) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("delete from ipva where id = ?");
		p.setInt(1, id);
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


public void atualizaIpva(Ipva ipva) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	
	try {
		PreparedStatement p = con.prepareStatement("update ipva set ano = ? in where id= ?");
		p.setInt(1, ipva.getAno());
		p.setInt(2, ipva.getId());
		p.executeUpdate();
		System.out.println(p);
		
		System.out.println("Ano do IPVA alterado");
		p.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public Ipva buscarIpva(Integer id) {
	Conexao c = Conexao.getInstance();
	Connection con = c.getConnection();
	Ipva nI = null;
	try {
		PreparedStatement p = con.prepareStatement("select * from ipva where id = ?");
		p.setInt(1, id);
		ResultSet r = p.executeQuery();			
		
		
		while (r.next()) {
			
			Integer anoBuscar = r.getInt("ano");
			
			nI = new Ipva(anoBuscar);
			nI.setId(id);
		}
		r.close();
		p.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nI;
}
	
}
