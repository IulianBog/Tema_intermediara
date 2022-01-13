package com.temaintermediara.main.controller;
import com.temaintermediara.main.exceptions.JocNotFoundException;
import com.temaintermediara.main.exceptions.TicheteNotFoundException;
import com.temaintermediara.main.model.Tichete;
import com.temaintermediara.main.repositories.TicheteRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Tichete")

public class TicheteController {
    private final TicheteRepository repository;

    public TicheteController(TicheteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Tichete> getTichete() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Tichete getTichete(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(JocNotFoundException::new);
    }

    @PostMapping
    public Tichete addTichete(@RequestBody Tichete Tichete) {
        return repository.save(Tichete);
    }

    @PutMapping("{id}")
    public Tichete updateCampionat(@PathVariable Long id, @RequestBody Tichete Tichete) {
        Tichete TicheteToUpdate = repository.findById(id).orElseThrow(TicheteNotFoundException::new);

        TicheteToUpdate.setNume(Tichete.getNume());
        TicheteToUpdate.setPret(Tichete.getPret());

        return repository.save(TicheteToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteTichete(@PathVariable Long id) {
        repository.findById(id).orElseThrow(TicheteNotFoundException::new);
        repository.deleteById(id);
    }
}
