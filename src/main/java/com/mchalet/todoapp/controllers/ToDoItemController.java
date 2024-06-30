package com.mchalet.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mchalet.todoapp.dtos.ToDoItemRecordDTO;
import com.mchalet.todoapp.service.ToDoItemService;

import jakarta.validation.Valid;

import java.util.UUID;

@RestController
public class ToDoItemController {

	@Autowired
	ToDoItemService toDoItemService;

	@PostMapping("/lists/{id}/add")
	public ResponseEntity<Object> insertToDo(@PathVariable Integer id,
											 @RequestBody @Valid ToDoItemRecordDTO toDoItemRecordDTO) {
		return toDoItemService.insertToDo(id, toDoItemRecordDTO);
	}

	@PutMapping("/lists/todo/update/{id}")
	public ResponseEntity<Object> updateToDo(@PathVariable UUID id,
											 @RequestBody @Valid ToDoItemRecordDTO toDoItemRecordDTO) {
		return toDoItemService.updateToDo(id, toDoItemRecordDTO);
	}

	@DeleteMapping("/lists/todo/delete/{id}")
	public ResponseEntity<String> removeToDo(@PathVariable UUID id) {
		return toDoItemService.removeToDo(id);
	}
}
