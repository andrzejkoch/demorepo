package com.tomaszr.demorepo.model.repositories;

import com.tomaszr.demorepo.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
//C - Create
//R - Read
//U - Update
//D - Delete

//
@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    ReservationModel findByLastname(String name);

    ReservationModel findById(int Id);

    List<ReservationModel> findByIdGreaterThan(int ID);
    List<ReservationModel> findByDateBetween(LocalDate date, LocalDate date2);
    List<ReservationModel> findByLastnameContaining(String letter);
    List<ReservationModel> deleteByLastname(String lastname);
    List<ReservationModel> findAll();


}
