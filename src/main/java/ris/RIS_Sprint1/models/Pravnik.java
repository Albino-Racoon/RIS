package ris.RIS_Sprint1.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Pravnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ime;
    private String email;
    private LocalDate datumrojstva;
    @Transient
    private Integer starost;
    private boolean navoljo;

    public Pravnik() {
    }

    public Pravnik(Long id, String ime, String email, LocalDate datumrojstva, boolean navoljo) {
        this.id = id;
        this.ime = ime;
        this.email = email;
        this.datumrojstva = datumrojstva;
        this.navoljo = navoljo;

    }

    public Pravnik(String ime, String email, LocalDate datumrojstva) {
        this.ime = ime;
        this.email = email;
        this.datumrojstva = datumrojstva;
        this.navoljo = navoljo;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNavoljo() {
        return navoljo;
    }

    public void setNavoljo(boolean navoljo) {
        this.navoljo = navoljo;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDatumrojstva(LocalDate datumrojstva) {
        this.datumrojstva = datumrojstva;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }


    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDatumrojstva() {
        return datumrojstva;
    }

    public Integer getStarost() {
        return Period.between(this.datumrojstva,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Pravnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", email='" + email + '\'' +
                ", datumrojstva=" + datumrojstva +
                ", starost=" + starost +
                ", navoljo=" + navoljo +
                '}';
    }
}
