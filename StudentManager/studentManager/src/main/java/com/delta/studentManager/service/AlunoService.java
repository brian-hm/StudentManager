package com.delta.studentManager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.studentManager.exceptions.DataIntegrityException;
import com.delta.studentManager.exceptions.ObjectNotFoundException;
import com.delta.studentManager.model.Aluno;
import com.delta.studentManager.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	
	@Transactional
	public Aluno create(Aluno obj) {
		Aluno aluno = repository.save(obj);
		return aluno;
	}
	
	public List<Aluno> findAll(){
		List<Aluno> list = repository.findAll();
		return list;
	}
	
	public Aluno findById(Integer id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", tipo: " + Aluno.class.getName()));
	}
	
	public Aluno edit(Aluno obj) {
		Aluno aluno = findById(obj.getId());
		updateData(aluno, obj);	
		return repository.save(obj);
	}
	
	private void updateData (Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityException e) {
			throw new DataIntegrityException("Aluno não pode ser deletado");
		}
	}
	
	
}
