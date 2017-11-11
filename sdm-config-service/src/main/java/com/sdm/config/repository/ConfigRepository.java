package com.sdm.config.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sdm.config.model.Config;
import com.sdm.config.model.Group;

@Repository
public interface ConfigRepository extends MongoRepository<Config, Long> {

	Group save(Group build);

}
