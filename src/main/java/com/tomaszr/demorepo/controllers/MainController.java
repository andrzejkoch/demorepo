package com.tomaszr.demorepo.controllers;

import com.tomaszr.demorepo.model.ReservationModel;
import com.tomaszr.demorepo.model.forms.ReservationForm;
import com.tomaszr.demorepo.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
//    @ResponseBody zwroci to co jest w return, a nie będzie szukało pliku html o takiej nazwie
//    @ResponseBody
    public String index(Model model) {
//        ReservationModel model = new ReservationModel();
//        model.setAdres("Warszawa");
//        model.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
//        model.setFirstname("Lukasz");
//        model.setLastname("Kowalski");
//        model.setId(1);

//        reservationRepository.save(model);
        //delete musi być/zawierać po primary key
//        reservationRepository.delete(model);
        model.addAttribute("reservationForm", new ReservationForm());
        model.addAttribute("reservations", reservationRepository.findAll());

        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form,
                        BindingResult bindingResult,
                        Model model,
                        ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            return "index";
        }


        reservationRepository.save(new ReservationModel(form));

        List<ReservationModel> reservations = reservationRepository.findAll();

        modelMap.put("reservations", reservations);

        return "index";
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return reservationRepository.findByLastname("Kowalski").toString();
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2() {
        return reservationRepository.findById(6).toString();
    }

    @GetMapping("/test3")
    @ResponseBody
    public List<ReservationModel> test3() {
        return reservationRepository.findByIdGreaterThan(2);
    }

    @GetMapping("/test4")
    @ResponseBody
    public List<ReservationModel> test4() {
        return reservationRepository.findByDateBetween(LocalDate.now(), LocalDate.now().plusYears(1));
    }

    @GetMapping("/test5")
    @ResponseBody
    public List<ReservationModel> test5() {
        return reservationRepository.findByLastnameContaining("Ko");
    }

    @GetMapping("/delete/{name}")
    @Transactional
    @ResponseBody
    public String delete(@PathVariable String name) {

        reservationRepository.deleteByLastname(name);
        return ("usunięto " + name);
    }

}

