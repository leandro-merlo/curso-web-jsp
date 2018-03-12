package br.com.manzatech.agenda.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.manzatech.agenda.database.dao.ContatoDAO;
import br.com.manzatech.agenda.models.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Contato> contatos = new ContatoDAO().getLista();
		request.setAttribute("contatos", contatos);
		return "lista-contatos.jsp";
	}

}
