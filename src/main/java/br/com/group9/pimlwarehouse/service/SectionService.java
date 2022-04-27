package br.com.group9.pimlwarehouse.service;

import br.com.group9.pimlwarehouse.entity.Section;
import br.com.group9.pimlwarehouse.repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {
    private SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section associateProductToSectionByIds(Long sectionId, Long productId) {
        Section foundSection = this.sectionRepository.findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado!"));

        // TODO: 26/04/22 Include call with Product API to validate if the given Product exists by productID.

        foundSection.addSectionProduct(productId);

        return this.sectionRepository.save(foundSection);
    }

}
