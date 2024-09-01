package com.marbouh.locationdevetementstraditionnels.services.impl;
import com.marbouh.locationdevetementstraditionnels.model.CreneauEssayage;
import com.marbouh.locationdevetementstraditionnels.repository.CreneauEssayageRepository;
import com.marbouh.locationdevetementstraditionnels.services.CreneauEssayageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public  class CreneauEssayageServiceImp implements CreneauEssayageService {
    // creneauessayage
    private final CreneauEssayageRepository creneauEssayageRepository;

    public CreneauEssayageServiceImp(CreneauEssayageRepository creneauEssayageRepository) {
        this.creneauEssayageRepository = creneauEssayageRepository;
    }

    @Override
    public void save(CreneauEssayage CreneauEssayage) {
       creneauEssayageRepository.save(CreneauEssayage);
    }

    @Override
    public void update(CreneauEssayage CreneauEssayage) {
        creneauEssayageRepository.save(CreneauEssayage);
    }


    @Override
    public void deleteById(Integer id) {
        creneauEssayageRepository.deleteById(id);

    }

    @Override
    public CreneauEssayage findById(Integer id) {
        return creneauEssayageRepository.findById(id).orElse(null);
    }

    @Override
    public List<CreneauEssayage> findAll() {
        return creneauEssayageRepository.findAll();
    }
}

