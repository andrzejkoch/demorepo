package com.tomaszr.demorepo.model;

import com.tomaszr.demorepo.model.forms.ReservationForm;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
//logiczny odpowiednik tabeli.
@Entity
//jeśłi nazwa klasy jest różna od nazwy tabeli, to trzeba uzyć poniższej adnotacji
@Table(name ="reservations")
//@NoArgsConstructor

public class ReservationModel {
//klucz główny
    @Id
//    automatycznie generuje klucz główny podczas tworzenia nowego wiersza w tabeli
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name="forstname")
    private String firstname;
    private String lastname;
    private LocalDate date;
    private String adres;

    public ReservationModel(ReservationForm form){
        firstname=form.getFirstname();
        lastname=form.getLastname();
        date=form.getFormatedDate();
        adres=form.getAdres();

    }

}