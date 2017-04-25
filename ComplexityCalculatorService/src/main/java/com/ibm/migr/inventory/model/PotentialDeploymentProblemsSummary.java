
package com.ibm.migr.inventory.model;


public class PotentialDeploymentProblemsSummary {

    private int archivesContainingDuplicateClasses;
    private int archivesContainingJavaEEorSEClasses;
    private int archivesContainingConflictingOpenSourceSoftwareClasses;
    private int archivesContainingWebSphereClasses;
    private int archivesNotReferencedInTheApplication;
    private int archivesWithMissingDependenciesInTheApplication;

    public int getArchivesContainingDuplicateClasses() {
        return archivesContainingDuplicateClasses;
    }

    public void setArchivesContainingDuplicateClasses(int archivesContainingDuplicateClasses) {
        this.archivesContainingDuplicateClasses = archivesContainingDuplicateClasses;
    }

    public int getArchivesContainingJavaEEorSEClasses() {
        return archivesContainingJavaEEorSEClasses;
    }

    public void setArchivesContainingJavaEEorSEClasses(int archivesContainingJavaEEorSEClasses) {
        this.archivesContainingJavaEEorSEClasses = archivesContainingJavaEEorSEClasses;
    }

    public int getArchivesContainingConflictingOpenSourceSoftwareClasses() {
        return archivesContainingConflictingOpenSourceSoftwareClasses;
    }

    public void setArchivesContainingConflictingOpenSourceSoftwareClasses(int archivesContainingConflictingOpenSourceSoftwareClasses) {
        this.archivesContainingConflictingOpenSourceSoftwareClasses = archivesContainingConflictingOpenSourceSoftwareClasses;
    }

    public int getArchivesContainingWebSphereClasses() {
        return archivesContainingWebSphereClasses;
    }

    public void setArchivesContainingWebSphereClasses(int archivesContainingWebSphereClasses) {
        this.archivesContainingWebSphereClasses = archivesContainingWebSphereClasses;
    }

    public int getArchivesNotReferencedInTheApplication() {
        return archivesNotReferencedInTheApplication;
    }

    public void setArchivesNotReferencedInTheApplication(int archivesNotReferencedInTheApplication) {
        this.archivesNotReferencedInTheApplication = archivesNotReferencedInTheApplication;
    }

    public int getArchivesWithMissingDependenciesInTheApplication() {
        return archivesWithMissingDependenciesInTheApplication;
    }

    public void setArchivesWithMissingDependenciesInTheApplication(int archivesWithMissingDependenciesInTheApplication) {
        this.archivesWithMissingDependenciesInTheApplication = archivesWithMissingDependenciesInTheApplication;
    }

}
