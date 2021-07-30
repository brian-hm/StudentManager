package com.delta.studentManager.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.delta.studentManager.model.Aluno;
import com.delta.studentManager.service.AlunoService;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> create (@RequestBody Aluno obj){
		Aluno aluno = service.create(obj);
		return ResponseEntity.ok().body(aluno);		
	}
	
	@GetMapping("alunos/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping("alunos/{id}")
	public ResponseEntity<Aluno> update(@RequestBody Aluno obj, @PathVariable Integer id){
		obj.setId(id);
		Aluno aluno = service.edit(obj);
		return ResponseEntity.ok().body(aluno);
	}
	
	@DeleteMapping("alunos/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
