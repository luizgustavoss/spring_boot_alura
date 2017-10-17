package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;
import br.com.alura.mail.EmailService;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository;
	
	
	public Iterable<Convidado> obterTodos(){
		return repository.findAll();
	}

	public void salvar(String nome, String email, String telefone){
		
		Convidado novoConvidado = new Convidado(nome, email, telefone);
	    repository.save(novoConvidado);
	    
	    new EmailService().enviar(nome, email);
	}
}
