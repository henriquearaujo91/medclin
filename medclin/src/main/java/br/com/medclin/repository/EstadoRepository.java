package br.com.medclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medclin.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Byte> {

}