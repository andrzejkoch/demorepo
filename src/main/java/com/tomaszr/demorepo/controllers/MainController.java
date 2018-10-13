package com.tomaszr.demorepo.controllers;

import com.tomaszr.demorepo.model.ReservationModel;
import com.tomaszr.demorepo.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.Calendar;

@Controller
public class MainController {
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        ReservationModel model = new ReservationModel();
//        model.setAdres("Warszawa");
//        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
//        model.setFirstname("Lukasz");
//        model.setLastname("Kowalski");
        model.setId(1);

//        reservationRepository.save(model);
        //delete musi być po primary key
        reservationRepository.delete(model);

        return "Hej zapisalem dane";
    }
}

