
package com.ibm.migr.inventory.model;

import java.util.List;

public class InventoryReport {

    private String report;
    private String version;
    private List<String> applications = null;
    private Archives archives;
    private Summary summary;
    private List<ArchiveInventory> archiveInventory = null;

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getApplications() {
        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }

    public Archives getArchives() {
        return archives;
    }

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<ArchiveInventory> getArchiveInventory() {
        return archiveInventory;
    }

    public void setArchiveInventory(List<ArchiveInventory> archiveInventory) {
        this.archiveInventory = archiveInventory;
    }

}
