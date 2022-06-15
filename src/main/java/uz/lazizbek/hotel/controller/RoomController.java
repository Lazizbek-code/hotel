package uz.lazizbek.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.hotel.entity.Hotel;
import uz.lazizbek.hotel.entity.Room;
import uz.lazizbek.hotel.payload.RoomDto;
import uz.lazizbek.hotel.repository.HotelRepository;
import uz.lazizbek.hotel.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    @GetMapping
    public List<Room> get(){
        return  roomRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody RoomDto roomDto){
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomDto.getHotelId());
        if (!hotelOptional.isPresent()){
            return "Mehmonxona topilmadi";
        }
        Room room  = new Room();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setBron(false);
        room.setSize(roomDto.getSize());
        room.setHotel(hotelOptional.get());
        roomRepository.save(room);
        return "Room added";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody RoomDto roomDto){
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (!roomOptional.isPresent()){
            return "Xona topilmadi";
        }
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomDto.getHotelId());
        if (!hotelOptional.isPresent()){
            return "Mehmonxona topilmadi";
        }
        Room room  = roomOptional.get();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setBron(false);
        room.setSize(roomDto.getSize());
        room.setHotel(hotelOptional.get());
        roomRepository.save(room);
        return "Room added";
    }

}
