package br.edu.ifpb.dac.exerciciojpa.mainsdepartamento;

import java.math.BigDecimal;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.DepartamentoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Departamento;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Empregado;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainBiSaveDepartamentos {
	
	public static void main(String[] args) {
		
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		
		try {

			Departamento departamento = new Departamento();
			departamento.setNome("Produção");
			departamento.setSigla("P");
			
			Departamento departamento2 = new Departamento();
			departamento2.setNome("Administrativo");
			departamento2.setSigla("AD");
			

			Empregado empregado = new Empregado();
			Empregado empregado2 = new Empregado();

			empregado.setNome("Jorge");
			empregado.setSobreNome("Da Silva");
			empregado.setDataNascimento(Util.getDate(1993, 2, 12));
			empregado.setSalario(new BigDecimal(1503.093039));

			empregado2.setNome("Fernando");
			empregado2.setSobreNome("De Souza");
			empregado2.setDataNascimento(Util.getDate(1999, 5, 4));
			empregado2.setSalario(new BigDecimal(1503.093039));


			departamento.setGerente(empregado);
			empregado.setGerencia(departamento);
			
			System.out.println("Antes de Salvar: "+departamento);

			departamentoDAO.save(departamento);
			
			System.out.println("Depois de Salvar: "+departamento);

			departamento2.setGerente(empregado2);
			empregado2.setGerencia(departamento2);
			
			
			System.out.println("Antes de Salvar: "+departamento2);
			departamentoDAO.save(departamento2);
			
			System.out.println("Depois de Salvar: "+departamento2);
			
			
			

			
		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			departamentoDAO.close();
		}

	}

}
