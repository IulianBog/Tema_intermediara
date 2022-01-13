package com.temaintermediara.main.bootstrap;

import com.temaintermediara.main.model.Joc;
import com.temaintermediara.main.repositories.JocuriRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class JocDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final JocuriRepository repository;

    public JocDataLoader(JocuriRepository jocuriRepository) {
        this.repository = jocuriRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Joc joc1 = new Joc();
        joc1.setNume("COD");
        joc1.setCategorie("FPS");
        joc1.setScor("10/3/2");

        Joc joc2 = new Joc();
        joc2.setNume("LOL");
        joc2.setCategorie("MMORPG");
        joc2.setScor("10/3/2");

        Joc joc3 = new Joc();
        joc3.setNume("DOTA");
        joc3.setCategorie("MMORPG");
        joc3.setScor("10/3/2");

        repository.save(joc1);
        repository.save(joc2);
        repository.save(joc3);
    }

}
