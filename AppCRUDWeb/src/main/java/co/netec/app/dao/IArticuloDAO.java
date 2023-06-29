package co.netec.app.dao;

import org.springframework.data.repository.CrudRepository;

import co.netec.app.entities.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Integer> {

}
