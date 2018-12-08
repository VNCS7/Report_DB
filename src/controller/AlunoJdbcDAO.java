package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoJdbcDAO {
    private Connection conn;

	public AlunoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Aluno> select() {
		String sql = "SELECT * FROM aluno";
        System.out.println(sql);		
        List<Aluno> aluno = new ArrayList<Aluno>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setNome(rs.getString("nome"));
				a.setCurso(rs.getString("curso"));
				aluno.add(a);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aluno;
	}	
	
}
