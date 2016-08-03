package br.edu.ifpb.dac.exerciciojpa.mainscelular;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.CelularDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Celular;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Chamada;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteCelular {

	public static void main(String[] args) {

		CelularDAO celularDAO = new CelularDAO();

		try {

			Celular celular = new Celular();
			celular.setCodPais(55);
			celular.setDdd(83);
			celular.setNumero(989823928);

			List<Chamada> list = new ArrayList<>();

			Chamada cha1 = new Chamada();
			cha1.setDuracao(145);
			cha1.setHoraInicio(new Date());

			Chamada cha2 = new Chamada();
			cha2.setDuracao(400);
			cha2.setHoraInicio(new Date());

			list.add(cha1);
			list.add(cha2);

			celular.setChamadas(list);

			celularDAO.save(celular);

			System.out.println(celularDAO.findAll().size());
			
			celularDAO.remove(celular);
			
			System.out.println(celularDAO.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			celularDAO.close();
		}

	}

}
