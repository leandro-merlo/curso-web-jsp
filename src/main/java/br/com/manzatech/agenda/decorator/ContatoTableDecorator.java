package br.com.manzatech.agenda.decorator;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.displaytag.decorator.TableDecorator;

import br.com.manzatech.agenda.models.Contato;

public class ContatoTableDecorator extends TableDecorator {

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
	
	public String getDataNascimento() {
		Contato c = (Contato)getCurrentRowObject();
		return null != c.getDataNascimento() ? formatter.format(c.getDataNascimento().getTime()) : "Data inválida!";
	}
	
}
