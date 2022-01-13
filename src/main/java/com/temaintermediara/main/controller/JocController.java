package com.temaintermediara.main.controller;

import com.temaintermediara.main.exceptions.JocNotFoundException;
import com.temaintermediara.main.model.Joc;
import com.temaintermediara.main.repositories.JocuriRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jocuri")
public class JocController {
    private final JocuriRepository repository;

    public JocController(JocuriRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Joc> getJocuri() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Joc getJoc(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(JocNotFoundException::new);
    }

    @PostMapping
    public Joc addJoc(@RequestBody Joc joc) {
        return repository.save(joc);
    }

    @PutMapping("{id}")
    public Joc updateJoc(@PathVariable Long id, @RequestBody Joc joc) {
        Joc jocToUpdate = repository.findById(id).orElseThrow(JocNotFoundException::new);

        jocToUpdate.setNume(joc.getNume());
        jocToUpdate.setCategorie(joc.getCategorie());
        jocToUpdate.setScor(joc.getScor());

        return repository.save(jocToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteJoc(@PathVariable Long id) {
        repository.findById(id).orElseThrow(JocNotFoundException::new);
        repository.deleteById(id);
    }
}
