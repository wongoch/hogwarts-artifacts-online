package com.oscar.hogwartsartifactsonline.artifact;

public class ArtifactNotFoundException extends RuntimeException{

    public ArtifactNotFoundException(String id) {
        super("Could not find artifact with Id " + id + " :(");
    }
}
