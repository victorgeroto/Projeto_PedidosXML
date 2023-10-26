package com.ProjetoGerenciamentoPedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoGerenciamentoPedidos.entites.Pedido;
import com.ProjetoGerenciamentoPedidos.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Pedido", description = "API REST DE GERENCIAMENTO  DE PEDIDOS")
@RestController
@RequestMapping("/pedido")
public class PedidoController {
		private final PedidoService pedidoService;

		@Autowired
		public PedidoController(PedidoService pedidoService) {
			this.pedidoService = pedidoService;
		}
		@GetMapping("/{id}")
		@Operation(summary = "Localiza usuario por ID")
		public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable Long id){
			Pedido pedido = pedidoService.buscaPedidoId(id);
			if(pedido !=null) {
				return ResponseEntity.ok(pedido);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping("/")
		@Operation(summary = "Apresenta todos os Pedidos")
		public ResponseEntity<List<Pedido>> buscaTodosPedidoControl(){
			List<Pedido> Pedido = pedidoService.buscaTodosPedido();
			return ResponseEntity.ok(Pedido);
		}
		@PostMapping("/")
		@Operation(summary = "Cadastra um Pedido")
		public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody @Valid Pedido pedido){
			Pedido salvaPedido = pedidoService.salvaPedido(pedido);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
	}
		@PutMapping("/{id}")
		@Operation(summary= "Altera Pedido")
		public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody @Valid Pedido pedido){
			Pedido alteraPedido = pedidoService.alterarPedido(id, pedido);
			if(alteraPedido !=null) {
				return ResponseEntity.ok(pedido);
			}
			else {
				return ResponseEntity.notFound().build();
			}
			
		}
		@DeleteMapping("/{id}")
		@Operation (summary = "Deleta Pedido")
		public ResponseEntity<Pedido> apagaPedidoControl(@PathVariable Long id){
			boolean apagar = pedidoService.apagarPedido(id);
			if(apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}

