package repository;


import model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {


    private List<TouristAttraction> touristAttractions = new ArrayList<>(
            List.of(
                    new TouristAttraction("The Little Mermaid", "The little mermaid attraction."),
                    new TouristAttraction("Møns Klint", "A beautiful view from the Danish coast."),
                    new TouristAttraction("Tivoli", "A historic attraction for kids and adults.")
            ));

    //CRUD metoder
    public List<TouristAttraction> findAllTourists(){
                return new ArrayList<>(touristAttractions);
    }


    public TouristAttraction save(TouristAttraction touristAttraction){
                touristAttractions.add(touristAttraction);
                return touristAttraction;
    }

    public void delete(String name) {
        touristAttractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }

    public TouristAttraction update(String name, TouristAttraction updatedAttraction) {
        for (int i = 0; i < touristAttractions.size(); i++) {
            TouristAttraction existingAttraction = touristAttractions.get(i);
            if (existingAttraction.getName().equalsIgnoreCase(name)) {
                touristAttractions.set(i, updatedAttraction);
                return updatedAttraction;
            }
        }
        return null;
        // return throw new NoSuchElementException("TouristAttraction with name " + name + " not found");
    }

}
