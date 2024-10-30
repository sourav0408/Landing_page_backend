package com.example.landing_page.service;

import com.example.landing_page.entity.AboutDescription;
import com.example.landing_page.repository.AboutDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutDescriptionService {

    @Autowired
    private AboutDescriptionRepository aboutDescriptionRepository;

    public List<AboutDescription> getAllAboutDescriptions() {
        return aboutDescriptionRepository.findAll();
    }

  /*  public List<AboutDescription> getAboutDescriptionsByAboutId(int aboutId) {
        return aboutDescriptionRepository.findByAbout_Id(aboutId);
    }*/
  public List<AboutDescription> getAboutDescriptionsByAboutId(int aboutId) {
      return aboutDescriptionRepository.findByAbout_Id(aboutId);
  }


    public AboutDescription saveAboutDescription(AboutDescription aboutDescription) {
        return aboutDescriptionRepository.save(aboutDescription);
    }

    public AboutDescription getAboutDescriptionById(Long id) {
        return aboutDescriptionRepository.findById(id).orElse(null);
    }
}

/*@Service
public class AboutDescriptionService {

    @Autowired
    private AboutDescriptionRepository aboutDescriptionRepository;

    public List<AboutDescription> getAllAboutDescriptions() {
        return aboutDescriptionRepository.findAll();
    }

    *//*public AboutDescription saveAboutDescription(AboutDescription aboutDescription) {
        return aboutDescriptionRepository.save(aboutDescription);
    }*//*

    public AboutDescription saveAboutDescription(AboutDescription aboutDescription) {
        return aboutDescriptionRepository.save(aboutDescription);
    }
    public AboutDescription getAboutDescriptionById(Long id) {
        return aboutDescriptionRepository.findById(id).orElse(null);
    }


}*/
