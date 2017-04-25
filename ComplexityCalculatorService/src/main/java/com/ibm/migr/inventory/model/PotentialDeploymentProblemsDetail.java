
package com.ibm.migr.inventory.model;

import java.util.List;

public class PotentialDeploymentProblemsDetail {

    private List<Object> duplicateClassesWithinClassLoader = null;
    private List<Object> duplicateClassesAcrossApplication = null;
    private List<JavaEEandSEClass> javaEEandSEClasses = null;
    private List<DuplicateWebSphereClass> duplicateWebSphereClasses = null;
    private List<OpenSourceSoftwareClass> openSourceSoftwareClasses = null;
    private List<ArchivesNotReferenced> archivesNotReferenced = null;
    private List<MissingDependency> missingDependencies = null;

    public List<Object> getDuplicateClassesWithinClassLoader() {
        return duplicateClassesWithinClassLoader;
    }

    public void setDuplicateClassesWithinClassLoader(List<Object> duplicateClassesWithinClassLoader) {
        this.duplicateClassesWithinClassLoader = duplicateClassesWithinClassLoader;
    }

    public List<Object> getDuplicateClassesAcrossApplication() {
        return duplicateClassesAcrossApplication;
    }

    public void setDuplicateClassesAcrossApplication(List<Object> duplicateClassesAcrossApplication) {
        this.duplicateClassesAcrossApplication = duplicateClassesAcrossApplication;
    }

    public List<JavaEEandSEClass> getJavaEEandSEClasses() {
        return javaEEandSEClasses;
    }

    public void setJavaEEandSEClasses(List<JavaEEandSEClass> javaEEandSEClasses) {
        this.javaEEandSEClasses = javaEEandSEClasses;
    }

    public List<DuplicateWebSphereClass> getDuplicateWebSphereClasses() {
        return duplicateWebSphereClasses;
    }

    public void setDuplicateWebSphereClasses(List<DuplicateWebSphereClass> duplicateWebSphereClasses) {
        this.duplicateWebSphereClasses = duplicateWebSphereClasses;
    }

    public List<OpenSourceSoftwareClass> getOpenSourceSoftwareClasses() {
        return openSourceSoftwareClasses;
    }

    public void setOpenSourceSoftwareClasses(List<OpenSourceSoftwareClass> openSourceSoftwareClasses) {
        this.openSourceSoftwareClasses = openSourceSoftwareClasses;
    }

    public List<ArchivesNotReferenced> getArchivesNotReferenced() {
        return archivesNotReferenced;
    }

    public void setArchivesNotReferenced(List<ArchivesNotReferenced> archivesNotReferenced) {
        this.archivesNotReferenced = archivesNotReferenced;
    }

    public List<MissingDependency> getMissingDependencies() {
        return missingDependencies;
    }

    public void setMissingDependencies(List<MissingDependency> missingDependencies) {
        this.missingDependencies = missingDependencies;
    }

}
