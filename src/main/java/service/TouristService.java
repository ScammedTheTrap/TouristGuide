package service;

import model.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TouristRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TouristService {

   TouristRepository touristRepository = new TouristRepository();

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.findAllTourists();
    }

    public TouristAttraction createAttraction(TouristAttraction touristAttraction) {
        return touristRepository.save(touristAttraction);
    }

    public void deleteAttraction(String name) {
        touristRepository.delete(name);
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        TouristAttraction updated = touristRepository.update(name, updatedAttraction);
        if (updated == null) {
            throw new NoSuchElementException("TouristAttraction with name " + name + " not found");
        }
        return updated;
    }
}
