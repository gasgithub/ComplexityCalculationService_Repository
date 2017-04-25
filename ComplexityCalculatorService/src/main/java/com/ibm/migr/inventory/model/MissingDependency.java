package com.ibm.migr.inventory.model;

import java.util.List;

public class MissingDependency {

    private List<String> missingDependencies = null;
    private List<String> archive = null;

    public List<String> getMissingDependencies() {
        return missingDependencies;
    }

    public void setMissingDependencies(List<String> missingDependencies) {
        this.missingDependencies = missingDependencies;
    }

    public List<String> getArchive() {
        return archive;
    }

    public void setArchive(List<String> archive) {
        this.archive = archive;
    }

}
