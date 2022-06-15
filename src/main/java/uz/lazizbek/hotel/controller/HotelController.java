package uz.lazizbek.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lazizbek.hotel.entity.Hotel;
import uz.lazizbek.hotel.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> get(){
        return  hotelRepository.findAll();
    }

    @PostMapping
    public String add(@RequestBody Hotel hotel){
        if (hotelRepository.existsByName(hotel.getName())){
            return "Bunday nomdagi mehmonxona mavjud";
        }else {
            hotelRepository.save(hotel);
            return "Hotel added";
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody Hotel hotel){
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()){
            Hotel editSubject = hotelOptional.get();
            editSubject.setName(hotel.getName());
            hotelRepository.save(editSubject);
            return "Hotel edited";
        }else {
            return "Hotel not found";
        }
    }
}
