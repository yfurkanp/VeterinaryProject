package com.yasir.VeterinaryProject.repository;

import com.yasir.VeterinaryProject.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Long> {


    List<Animal> findAllByOwnerId(Long ownerId);




}
