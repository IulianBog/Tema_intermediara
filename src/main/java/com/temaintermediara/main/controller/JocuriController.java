package com.temaintermediara.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.temaintermediara.main.model.Jocuri;
import com.temaintermediara.main.repositories.JocuriRepository;

@RestController
public class JocuriController {

    private Logger logger = LoggerFactory.getLogger(JocuriController.class);

    @Autowired
    private JocuriRepository JocuriRepository;

    @GetMapping(value = "/")
    public List<Jocuri> getAllJocuris() {
        logger.info("Preia toate jocurile.");
        return JocuriRepository.findAll();
    }

    @GetMapping(value = "/{JocuriId}")
    public Jocuri getJocuriById(@PathVariable String JocuriId) {
        logger.info("Preia jocurile prin intermediul ID-ului: {}", JocuriId);
        return JocuriRepository.findJocuriById(JocuriId);
    }

    @PostMapping(value = "/create")
    public Jocuri addJocuri(@RequestBody Jocuri Jocuri) {
        logger.info("Salveaza jocurile.");
        return JocuriRepository.save(Jocuri);
    }

    @PutMapping(value = "/update/{JocuriId}")
    public Jocuri updateJocuri(@PathVariable String JocuriId, @RequestBody Jocuri Jocuri) {
        logger.info("Updatateaza jocurile prin intermediul ID-ului: {}", JocuriId);
        Jocuri.setId(JocuriId);
        return JocuriRepository.save(Jocuri);
    }

    @DeleteMapping(value = "/delete/{JocuriId}")
    public void deleteJocuri(@PathVariable String JocuriId) {
        logger.info("Sterge jocurile prin intermediul ID-ului: {}", JocuriId);
        JocuriRepository.deleteById(JocuriId);
    }
}
