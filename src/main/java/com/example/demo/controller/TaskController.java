package com.example.demo.controller;

import com.example.demo.dto.PagedResponse;
import com.example.demo.dto.TaskDto;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllTasks(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<TaskDto> dtos = taskService.getAll();

        Map<String, Object> response = new HashMap<>();

        response.put("user", auth.getName());
        response.put("tasks", dtos);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto) {
        taskService.add(taskDto);
        return ResponseEntity.ok("Задача добавлена!");
    }

    @PutMapping ("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Integer id,@Valid @RequestBody TaskDto taskDto){
        taskService.updateTask(id, taskDto);
        return ResponseEntity.ok("Задача обновлена");
    }

    @GetMapping("/search")
    public List<TaskDto> findByTitle(@RequestParam @Size(min = 3) String title) {
        return taskService.findByTitle(title);
    }

    @GetMapping("/sorted")
    public List<TaskDto> getSortedTasks(@RequestParam String sortBy, @RequestParam(defaultValue = "asc") String order) {
        return taskService.getSorted(sortBy, order);
    }

    @GetMapping("/paged")
    public PagedResponse<TaskDto> getPage(Pageable pageable) {
        return taskService.getPage(pageable);
    }
}