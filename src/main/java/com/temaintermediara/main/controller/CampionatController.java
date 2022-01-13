package com.temaintermediara.main.controller;

import com.temaintermediara.main.exceptions.CampionatNotFoundException;
import com.temaintermediara.main.exceptions.JocNotFoundException;
import com.temaintermediara.main.model.Campionat;
import com.temaintermediara.main.model.Joc;
import com.temaintermediara.main.model.Player;
import com.temaintermediara.main.model.Tichete;
import com.temaintermediara.main.repositories.CampionatRepository;
import com.temaintermediara.main.repositories.PlayerRepository;
import com.temaintermediara.main.repositories.TicheteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Campionat")
public class CampionatController {
    private final CampionatRepository repository;
    private final TicheteRepository ticheteRepository;
    private final PlayerRepository playerRepository;

    public CampionatController(CampionatRepository repository, TicheteRepository ticheteRepository, PlayerRepository playerRepository) {
        this.repository = repository;
        this.ticheteRepository = ticheteRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public Iterable<Campionat> getCampionat() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Campionat getCampionat(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(JocNotFoundException::new);
    }

    @PostMapping
    public Campionat addCampionat(@RequestBody Campionat Campionat) {
        return repository.save(Campionat);
    }

    @PutMapping("{id}")
    public Campionat updateCampionat(@PathVariable Long id, @RequestBody Campionat Campionat) {
        Campionat CampionatToUpdate = repository.findById(id).orElseThrow(CampionatNotFoundException::new);
        CampionatToUpdate.setNume(Campionat.getNume());
        CampionatToUpdate.setCategorie(Campionat.getCategorie());
        CampionatToUpdate.setMap(Campionat.getMap());
        return repository.save(CampionatToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteCampionat(@PathVariable Long id) {
        repository.findById(id).orElseThrow(CampionatNotFoundException::new);
        repository.deleteById(id);
    }

    @PostMapping("{pret}")
    public Campionat addCampionat_Tichete(@RequestBody Campionat Campionat,@PathVariable String pret) {
        Tichete tichete = new Tichete();
        tichete.setPret(pret);
        tichete.setNume(Campionat.getNume());
        ticheteRepository.save(tichete);
        return repository.save(Campionat);
    }
    @PostMapping("/player/{nume}")
    public Campionat addCampionat_Player(@RequestBody Campionat Campionat,@PathVariable String nume) {
        Player player = new Player();
        player.setNume(nume);
        player.setCampionat(Campionat.getNume());
        playerRepository.save(player);
        return repository.save(Campionat);
    }

}

