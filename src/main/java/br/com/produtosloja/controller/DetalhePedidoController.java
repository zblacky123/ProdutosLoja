package br.com.produtosloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtosloja.repository.DetalhePedidoRepository;

@RestController
@RequestMapping("/api/v1/oderdetail/")
public class DetalhePedidoController {
	
	@Autowired
	private DetalhePedidoRepository dpr;
	
	@GetMapping ("/list")
	public ResponseEntity<Object> list(){
		try {
			return ResponseEntity.status(200).body(dpr.findAll());
		}
		catch(Exception e){
			return ResponseEntity.status(500).body("Erro ao Carregar ->"+e.getMessage());
		}
	}
}
