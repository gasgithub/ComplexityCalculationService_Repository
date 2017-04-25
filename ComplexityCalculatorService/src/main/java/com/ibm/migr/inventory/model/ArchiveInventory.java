
package com.ibm.migr.inventory.model;

import java.util.List;

public class ArchiveInventory implements CommonArchiveInventory {

	private String archiveName;
	private String moduleType;    
	private String moduleVersion;
	private Summary summary;
	private Archives archives;   //archives_
    private PotentialDeploymentProblemsSummary potentialDeploymentProblemsSummary;
    private List<PotentialDeploymentProblemsDetail> potentialDeploymentProblemsDetails = null;
    private List<ContainedArchiveInventory> containedArchiveInventory = null;


    public Archives getArchives() {
        return archives;
    }

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    public PotentialDeploymentProblemsSummary getPotentialDeploymentProblemsSummary() {
        return potentialDeploymentProblemsSummary;
    }

    public void setPotentialDeploymentProblemsSummary(PotentialDeploymentProblemsSummary potentialDeploymentProblemsSummary) {
        this.potentialDeploymentProblemsSummary = potentialDeploymentProblemsSummary;
    }

    public List<PotentialDeploymentProblemsDetail> getPotentialDeploymentProblemsDetails() {
        return potentialDeploymentProblemsDetails;
    }

    public void setPotentialDeploymentProblemsDetails(List<PotentialDeploymentProblemsDetail> potentialDeploymentProblemsDetails) {
        this.potentialDeploymentProblemsDetails = potentialDeploymentProblemsDetails;
    }

    @Override
	public List<ContainedArchiveInventory> getContainedArchiveInventory() {
        return containedArchiveInventory;
    }

    @Override
	public void setContainedArchiveInventory(List<ContainedArchiveInventory> containedArchiveInventory) {
        this.containedArchiveInventory = containedArchiveInventory;
    }
	@Override
	public String getArchiveName() {
	    return archiveName;
	}

	@Override
	public void setArchiveName(String archiveName) {
	    this.archiveName = archiveName;
	}

	@Override
	public String getModuleType() {
	    return moduleType;
	}

	@Override
	public void setModuleType(String moduleType) {
	    this.moduleType = moduleType;
	}

    public String getModuleVersion() {
	    return moduleVersion;
	}

	public void setModuleVersion(String moduleVersion) {
	    this.moduleVersion = moduleVersion;
	}

	@Override
	public Summary getSummary() {
	    return summary;
	}

	@Override
	public void setSummary(Summary summary) {
	    this.summary = summary;
	}

}
