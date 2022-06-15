package uz.lazizbek.hotel.entity;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Integer size;

    @Column(nullable = false)
    private Boolean bron = false;

    @ManyToOne
    private Hotel hotel;


    public Room() {
    }

    public Room(Integer id, String number, Integer floor, Integer size, Hotel hotel, Boolean bron) {
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.size = size;
        this.hotel = hotel;
        this.bron = bron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Boolean getBron() {
        return bron;
    }

    public void setBron(Boolean bron) {
        this.bron = bron;
    }
}
