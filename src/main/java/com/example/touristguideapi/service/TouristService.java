package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.touristguideapi.repository.TouristRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TouristService {
    private final TouristRepository touristRepository;


    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.findAllAttractions();
    }

    public TouristAttraction createAttraction(TouristAttraction touristAttraction) {
        return touristRepository.save(touristAttraction);
    }

    public boolean deleteAttraction(String name) {
        touristRepository.delete(name);
        return false;
    }


    public TouristAttraction updateAttraction(String name, TouristAttraction updatedAttraction) {
        TouristAttraction updated = touristRepository.update(name, updatedAttraction);
        if (updated == null) {
            throw new NoSuchElementException("TouristAttraction with name " + name + " not found");
        }
        return updated;
    }

    public Optional<TouristAttraction> findAttractionByName(String name) {
        return touristRepository.findAllAttractions().stream()
                .filter(attraction -> attraction.getName().equalsIgnoreCase(name))
                .findFirst();
    }


    public List<TouristAttraction> findAllAttractions() {
        return touristRepository.findAllAttractions();
    }
}
