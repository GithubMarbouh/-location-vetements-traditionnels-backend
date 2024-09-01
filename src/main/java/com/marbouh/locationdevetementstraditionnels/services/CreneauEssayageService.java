package com.marbouh.locationdevetementstraditionnels.services;
import com.marbouh.locationdevetementstraditionnels.model.CreneauEssayage;
import java.util.List;

public interface CreneauEssayageService {

        void save(CreneauEssayage CreneauEssayage);

        void update(CreneauEssayage CreneauEssayage);

        void deleteById(Integer id);

        CreneauEssayage findById(Integer id);

        List<CreneauEssayage> findAll();

}
