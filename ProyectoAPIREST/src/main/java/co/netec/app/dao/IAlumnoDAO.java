package co.netec.app.dao;

import org.springframework.data.repository.CrudRepository;

import co.netec.app.entities.Alumno;

public interface IAlumnoDAO extends CrudRepository<Alumno, Integer>{

}
