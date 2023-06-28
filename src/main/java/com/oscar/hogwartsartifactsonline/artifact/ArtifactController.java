package com.oscar.hogwartsartifactsonline.artifact;

import com.oscar.hogwartsartifactsonline.artifact.convertor.ArtifactDtoToArtifactConverter;
import com.oscar.hogwartsartifactsonline.artifact.convertor.ArtifactToArtifactDtoConverter;
import com.oscar.hogwartsartifactsonline.artifact.dto.ArtifactDto;
import com.oscar.hogwartsartifactsonline.system.Result;
import com.oscar.hogwartsartifactsonline.system.StatusCode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArtifactController {

    private final ArtifactService artifactService;

    private final ArtifactToArtifactDtoConverter artifactToArtifactDtoConverter;

    private final ArtifactDtoToArtifactConverter artifactDtoToArtifactConverter;

    public ArtifactController(ArtifactService artifactService, ArtifactToArtifactDtoConverter artifactToArtifactDtoConverter, ArtifactDtoToArtifactConverter artifactDtoToArtifactConverter) {
        this.artifactService = artifactService;
        this.artifactToArtifactDtoConverter = artifactToArtifactDtoConverter;
        this.artifactDtoToArtifactConverter = artifactDtoToArtifactConverter;
    }

    // Handler method for REST api endpoint
    @GetMapping("/api/v1/artifacts/{artifactId}")
    public Result findArtifactById(@PathVariable String artifactId) {
        Artifact foundArtifact = this.artifactService.findById(artifactId);
        ArtifactDto artifactDto = this.artifactToArtifactDtoConverter.convert(foundArtifact);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", artifactDto );
    }

    @GetMapping("/api/v1/artifacts")
    public Result findAllArtifacts() {
        List<Artifact> foundArtifacts = this.artifactService.findAll();
        // Convert foundArtifacts to a list of artifactDtos
        List<ArtifactDto> artifactDtos = foundArtifacts.stream()
                .map(foundArtifact -> this.artifactToArtifactDtoConverter.convert(foundArtifact))
                .collect(Collectors.toList());
        return new Result(true, StatusCode.SUCCESS, "Find All Success", artifactDtos );
    }

    @PostMapping("/api/v1/artifacts")
    public Result addArtifact(@Valid @RequestBody ArtifactDto artifactDto) {
        // convert dto -> do
        Artifact newArtifact = this.artifactDtoToArtifactConverter.convert(artifactDto);
        // call save method
        Artifact savedArtifact = this.artifactService.save(newArtifact);
        // convert do -> dto
        ArtifactDto savedArtifactDto = this.artifactToArtifactDtoConverter.convert(savedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Add Success", savedArtifactDto );
    }

    @PutMapping("/api/v1/artifacts/{artifactId}")
    public Result updateArtifact(@PathVariable String artifactId, @Valid @RequestBody ArtifactDto artifactDto) {
        // convert dto -> do
        Artifact newArtifact = this.artifactDtoToArtifactConverter.convert(artifactDto);
        // call update method
        Artifact savedArtifact = this.artifactService.update(artifactId, newArtifact);
        // convert do -> dto
        ArtifactDto savedArtifactDto = this.artifactToArtifactDtoConverter.convert(savedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Update Success", savedArtifactDto );
    }

    @DeleteMapping("/api/v1/artifacts/{artifactId}")
    public Result deleteArtifact(@PathVariable String artifactId) {
        this.artifactService.deleteArtifact(artifactId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success", null );
    }

}
