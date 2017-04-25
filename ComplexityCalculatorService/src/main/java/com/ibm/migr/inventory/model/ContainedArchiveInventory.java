
package com.ibm.migr.inventory.model;

import java.util.List;

public class ContainedArchiveInventory implements CommonArchiveInventory {

	private String archiveName;
	private String moduleType;    
	private String moduleVersion;
	private Summary summary;
	private Archives archives;  //archives__
    private List<ContainedArchiveInventory> containedArchiveInventory = null;
    private List<String> containedPackages = null;

	public Archives getArchives() {
        return archives;
    }

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    public List<ContainedArchiveInventory> getContainedArchiveInventory() {
        return containedArchiveInventory;
    }

    public void setContainedArchiveInventory(List<ContainedArchiveInventory> containedArchiveInventory) {
        this.containedArchiveInventory = containedArchiveInventory;
    }
    public List<String> getContainedPackages() {
        return containedPackages;
    }

    public void setContainedPackages(List<String> containedPackages) {
        this.containedPackages = containedPackages;
    }
    
    public String getModuleVersion() {
	    return moduleVersion;
	}

	public void setModuleVersion(String moduleVersion) {
	    this.moduleVersion = moduleVersion;
	}

	public Summary getSummary() {
	    return summary;
	}

	public void setSummary(Summary summary) {
	    this.summary = summary;
	}

	public String getArchiveName() {
	    return archiveName;
	}

	public void setArchiveName(String archiveName) {
	    this.archiveName = archiveName;
	}

	public String getModuleType() {
	    return moduleType;
	}

	public void setModuleType(String moduleType) {
	    this.moduleType = moduleType;
	}


}
