package com.alex.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("todoRepository")
public interface TodoListRepository extends JpaRepository<ToDoList, Integer> {
}
