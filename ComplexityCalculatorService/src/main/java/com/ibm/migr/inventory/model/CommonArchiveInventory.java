package com.ibm.migr.inventory.model;

import java.util.List;

public interface CommonArchiveInventory {

	List<ContainedArchiveInventory> getContainedArchiveInventory();

	void setContainedArchiveInventory(List<ContainedArchiveInventory> containedArchiveInventory);

	String getArchiveName();

	void setArchiveName(String archiveName);

	String getModuleType();

	void setModuleType(String moduleType);

	Summary getSummary();

	void setSummary(Summary summary);

}
