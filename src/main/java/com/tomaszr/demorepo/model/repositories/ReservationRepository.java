package com.tomaszr.demorepo.model.repositories;

import com.tomaszr.demorepo.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//C - Create
//R - Read
//U - Update
//D - Delete

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel,Integer > {


}
