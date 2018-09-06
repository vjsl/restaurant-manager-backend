package br.ufpe.cin.vjsl.restaurantbackend.repository;

import br.ufpe.cin.vjsl.restaurantbackend.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {


}
