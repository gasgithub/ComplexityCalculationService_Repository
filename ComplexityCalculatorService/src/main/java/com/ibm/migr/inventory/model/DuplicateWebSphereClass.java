
package com.ibm.migr.inventory.model;

import java.util.List;

public class DuplicateWebSphereClass {

    private List<String> conflictingPackages = null;
    private List<String> packageLocation = null;

    public List<String> getConflictingPackages() {
        return conflictingPackages;
    }

    public void setConflictingPackages(List<String> conflictingPackages) {
        this.conflictingPackages = conflictingPackages;
    }

    public List<String> getPackageLocation() {
        return packageLocation;
    }

    public void setPackageLocation(List<String> packageLocation) {
        this.packageLocation = packageLocation;
    }

}
