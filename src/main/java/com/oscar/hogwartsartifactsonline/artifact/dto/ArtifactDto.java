package com.oscar.hogwartsartifactsonline.artifact.dto;

import com.oscar.hogwartsartifactsonline.wizard.dto.WizardDto;

public record ArtifactDto(String id,
                          String name,
                          String description,
                          String imgUrl,
                          WizardDto owner) {
}
