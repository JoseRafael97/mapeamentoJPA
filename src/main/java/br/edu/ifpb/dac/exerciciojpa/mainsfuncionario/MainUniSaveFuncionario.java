package br.edu.ifpb.dac.exerciciojpa.mainsfuncionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.FuncionarioDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Funcionario;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainUniSaveFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		try {
			Funcionario fun = new Funcionario();
			fun.setNome("Rafael");
			fun.setSobreNome("Feitosa");
			fun.setDataNascimento(Util.getDate(1995, 4, 27));
			fun.setSalario(new BigDecimal(3000.45));

			List<Funcionario> funcionarios = new ArrayList<>();

			Funcionario func1 = new Funcionario();
			func1.setNome("Fulano ");
			func1.setSobreNome("SOUZA");
			func1.setDataNascimento(Util.getDate(1995, 7, 27));
			func1.setSalario(new BigDecimal(2000.45));

			Funcionario func2 = new Funcionario();
			func2.setNome("Sicrano");
			func2.setSobreNome("Pererira");
			func2.setDataNascimento(Util.getDate(1995, 7, 27));
			func2.setSalario(new BigDecimal(2000.45));

			funcionarios.add(func1);
			funcionarios.add(func2);

			fun.setGerencia(funcionarios);

			funcionarioDAO.save(fun);

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			funcionarioDAO.close();
		}

	}

}
