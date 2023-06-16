package br.com.produtosloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtosloja.model.Produtos;
import br.com.produtosloja.repository.ProdutosRepository;

@RestController
public class ProdutosController {

	//Importar o repository com uma auto instanciação
	@Autowired
	private ProdutosRepository pr;
	
	//Listar os produtos
	@GetMapping("/produtos/listar")
	@ResponseStatus (code = HttpStatus.OK)
	public List<Produtos>Listar(){
		return pr.findAll();	
		}


//Cadastrar produtos

	@PostMapping ("/products/insert")
	@ResponseStatus (code = HttpStatus.CREATED)
	public String insert(@RequestBody Produtos produtos) {
		pr.save(produtos);
		return "Produto salvo com sucesso";
	
	}
	
}