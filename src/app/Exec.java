package app;

import java.sql.Connection;
import java.util.List;

import controller.JdbUtil;
import controller.AlunoJdbcDAO;

import model.Aluno;

import report.AlunoRelatorio;


public class Exec {
	public static void main(String[] args) {
		try {
			Connection con = JdbUtil.getConnection();
			AlunoJdbcDAO alunojdbcDAO = new AlunoJdbcDAO(con);
			
			
			List<Aluno> aluno = alunojdbcDAO.select();
			
			AlunoRelatorio alunorel = new AlunoRelatorio();
			alunorel.imprimir(aluno);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
