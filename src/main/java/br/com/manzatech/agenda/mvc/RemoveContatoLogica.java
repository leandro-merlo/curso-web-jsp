package br.com.manzatech.agenda.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.manzatech.agenda.database.dao.ContatoDAO;
import br.com.manzatech.agenda.models.Contato;

public class RemoveContatoLogica implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		System.out.println("Excluindo contato... ");
		return "mvc?logica=ListaContatosLogica";
	}

}
