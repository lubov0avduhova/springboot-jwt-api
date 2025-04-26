package com.example.demo.service;

import com.example.demo.dto.PagedResponse;
import com.example.demo.dto.TaskDto;
import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;


    public List<TaskDto> getAll() {
        List<Task> list = repository.findAll();
        List<TaskDto> result = new ArrayList<>();

        for (Task task : list) {
            result.add(new TaskDto(task.getTitle(), task.getDueDate()));
        }
        return result;
    }

    public void add(TaskDto dto) {
        repository.save(new Task(dto.getTitle(), dto.getDueDate()));
    }

    public void updateTask(Integer id, TaskDto taskDto) {
        Task foundTask = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        foundTask.setTitle(taskDto.getTitle());
        foundTask.setDueDate(taskDto.getDueDate());

        repository.save(foundTask);
    }

    public List<TaskDto> findByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title).stream()
                .map(t -> new TaskDto(t.getTitle(), t.getDueDate()))
                .toList();
    }

    public List<TaskDto> getSorted(String sortBy, String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, sortBy);
        List<Task> sorted = repository.findAll(sort);
        List<TaskDto> result = new ArrayList<>();

        for (Task task : sorted) {
            result.add(new TaskDto(task.getTitle(), task.getDueDate()));
        }

        return result;
    }

    public PagedResponse<TaskDto> getPage(Pageable pageable) {
        Page<TaskDto> page = repository.findAll(pageable)
                .map(t -> new TaskDto(t.getTitle(), t.getDueDate()));

        return new PagedResponse<>(page.getTotalElements(), page.getTotalPages(),
                page.getSize(), page.getNumber(), page.getContent());
    }

}

