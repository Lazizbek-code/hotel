package uz.lazizbek.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.lazizbek.hotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
