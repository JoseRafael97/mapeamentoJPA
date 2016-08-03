package br.edu.ifpb.dac.exerciciojpa;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.DepartamentoDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.EmpregadoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Departamento;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Empregado;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainUniSaveDepartamento {

	public static void main(String[] args) {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		EmpregadoDAO empregadoDAO = new EmpregadoDAO();

		try {

			Departamento departamento = new Departamento();
			departamento.setNome("Financeiro");
			departamento.setSigla("FN");
			
			Departamento departamento2 = new Departamento();
			departamento2.setNome("Relações Humanas");
			departamento2.setSigla("RH");

			Empregado empregado = new Empregado();
			Empregado empregado2 = new Empregado();

			empregado.setNome("Fulano");
			empregado.setSobreNome("Da Silva");
			empregado.setDataNascimento(Util.getDate(1993, 2, 12));

			empregado2.setNome("Sicrano");
			empregado2.setSobreNome("De Souza");
			empregado2.setDataNascimento(Util.getDate(1999, 5, 4));

			departamento.setGerente(empregado);
			empregado.setGerencia(departamento);
			
			System.out.println("Antes de Salvar: "+departamento);

			departamentoDAO.save(departamento);
			
			System.out.println("Depois de Salvar: "+departamento);

			
			departamento2.setGerente(empregado2);
			
			System.out.println("Antes de Salvar: "+departamento2);
			departamentoDAO.save(departamento2);
			
			System.out.println("Depois de Salvar: "+departamento2);

			
		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			departamentoDAO.close();
			empregadoDAO.close();
		}

	}
}
