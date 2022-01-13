package com.temaintermediara.main.repositories;

import com.temaintermediara.main.model.Player;
import com.temaintermediara.main.model.Tichete;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
