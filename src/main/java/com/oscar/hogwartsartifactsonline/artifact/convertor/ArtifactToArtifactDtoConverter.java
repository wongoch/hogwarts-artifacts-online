package com.oscar.hogwartsartifactsonline.artifact.convertor;

import com.oscar.hogwartsartifactsonline.artifact.Artifact;
import com.oscar.hogwartsartifactsonline.artifact.dto.ArtifactDto;
import com.oscar.hogwartsartifactsonline.wizard.convertor.WizardToWizardDtoConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArtifactToArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {

    private final WizardToWizardDtoConverter wizardToWizardDtoConverter;

    public ArtifactToArtifactDtoConverter(WizardToWizardDtoConverter wizardToWizardDtoConverter) {
        this.wizardToWizardDtoConverter = wizardToWizardDtoConverter;
    }

    @Override
    public ArtifactDto convert(Artifact source) {
        ArtifactDto artifactDto = new ArtifactDto(
                source.getId(),
                source.getName(),
                source.getDescription(),
                source.getImageUrl(),
                source.getOwner() != null ? wizardToWizardDtoConverter.convert(source.getOwner()) : null);
        return artifactDto;
    }
}
