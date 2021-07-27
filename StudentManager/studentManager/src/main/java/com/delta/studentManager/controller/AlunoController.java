package com.delta.studentManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.studentManager.model.Aluno;
import com.delta.studentManager.service.AlunoService;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Aluno> create (@RequestBody Aluno obj){
		Aluno aluno = service.create(obj);
		return ResponseEntity.ok().body(aluno);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Aluno> update(@RequestBody Aluno obj, @PathVariable Integer id){
		obj.setId(id);
		Aluno aluno = service.edit(obj);
		return ResponseEntity.ok().body(aluno);
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
	
	
	

}
