package comparadorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comparadorweb.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
