package dev.service;
import dev.domain.RoomType;
import dev.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class RoomTypeService {

    private RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public void create(RoomType roomType) {
        roomType.setRoomName(roomType.getRoomName().toUpperCase());
        roomTypeRepository.create(roomType);
    }

    public List<RoomType> getAll() {
        return roomTypeRepository.getAll();
    }

    public RoomType get(int roomTypesId) {
        return roomTypeRepository.get(roomTypesId);
    }


    public void edit(RoomType roomType) {
        roomTypeRepository.edit(roomType);
    }
//    public void edit (StoredFoodItem sf) {
//        inventoryTrackingRepo.edit(sf);
//    }

    public void delete(int roomTypesId) {
        roomTypeRepository.delete(roomTypesId);
    }


}
