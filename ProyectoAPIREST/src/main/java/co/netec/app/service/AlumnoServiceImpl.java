package co.netec.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.netec.app.dao.IAlumnoDAO;
import co.netec.app.entities.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoDAO dao;
	
	@Override
	@Transactional
	public Alumno save(Alumno alum) {
		Alumno alumno = dao.save(alum);
		return alumno;
				
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findALL() {
		List<Alumno> listarAlumno = (List<Alumno>)dao.findAll();
		return listarAlumno;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		//aqui hay que poner un try catch
		dao.deleteById(id);
		
		//aberracion que se corregira en el proximo ejercicio
		return true;
	}

	@Override
	@Transactional
	public Alumno update(Alumno alumno) {
		
		Optional<Alumno> alumnoBD = dao.findById(alumno.getId());
		
		if (alumnoBD.isPresent()) {
			Alumno alumnoActualizado  = alumnoBD.get();
			alumnoActualizado.setNombre(alumno.getNombre());
			alumnoActualizado.setEdad(alumno.getEdad());
			alumnoActualizado.setCorreo(alumno.getCorreo());
			return save(alumnoActualizado);
		}
		return null;
		
	
	}

	

}
