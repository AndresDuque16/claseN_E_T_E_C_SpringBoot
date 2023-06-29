package co.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.netec.app.dao.IArticuloDAO;
import co.netec.app.entities.Articulo;


@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	private IArticuloDAO dao;
	
	@Override
	@Transactional
	public List<Articulo> findAll() {
		return (List<Articulo>)dao.findAll();
		
		
	}

	@Override
	@Transactional
	public Articulo save(Articulo articulo) {
		
		return dao.save(articulo);
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.deleteById(id);	
		
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo findById(int id) {
		
		return dao.findById(id).orElse(null);
	}

	

}
