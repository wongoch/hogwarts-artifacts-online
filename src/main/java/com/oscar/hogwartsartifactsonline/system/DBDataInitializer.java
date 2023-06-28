package com.oscar.hogwartsartifactsonline.system;

import com.oscar.hogwartsartifactsonline.artifact.Artifact;
import com.oscar.hogwartsartifactsonline.artifact.ArtifactRepository;
import com.oscar.hogwartsartifactsonline.wizard.Wizard;
import com.oscar.hogwartsartifactsonline.wizard.WizardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private final ArtifactRepository artifactRepository;

    private final WizardRepository wizardRepository;

    public DBDataInitializer(ArtifactRepository artifactRepository, WizardRepository wizardRepository) {
        this.artifactRepository = artifactRepository;
        this.wizardRepository = wizardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Artifact a1 = new Artifact();
        a1.setId("a1");
        a1.setName("Artifact a1");
        a1.setDescription("Artifact a1 description");
        a1.setImageUrl("Artifact a1 image url");

        Wizard w1 = new Wizard();
        w1.setId(1);
        w1.setName("Wizard 1");
        w1.addArtifact(a1);

        // no owner
        Artifact a4 = new Artifact();
        a4.setId("a4");
        a4.setName("Artifact a4");
        a4.setDescription("Artifact a4 description");
        a4.setImageUrl("Artifact a4 image url");

        wizardRepository.save(w1);
        artifactRepository.save(a4);

    }
}
