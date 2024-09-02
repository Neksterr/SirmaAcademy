package com.sirma.toDoApp.service;


import com.sirma.toDoApp.model.Todo;
import com.sirma.toDoApp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll(){
        return repository.findAll();
    }

    public Todo findById(Long id) throws IllegalAccessException {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("Invalid id: " + id));
    }
    public Todo save(Todo todo){
        return repository.save(todo);
    }
    public void delete(long id){
        boolean exists = repository.existsById(id);
        if(exists){
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid Id provided");
        }
    }
    public List<Todo> findByCompleted(boolean completed){
        return repository.findByCompleted(completed);
    }
}
