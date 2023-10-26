package com.ProjetoGerenciamentoPedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoGerenciamentoPedidos.entites.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{

}

