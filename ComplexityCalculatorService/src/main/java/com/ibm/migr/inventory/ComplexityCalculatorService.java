package com.ibm.migr.inventory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.migr.inventory.model.Archives;
import com.ibm.migr.inventory.model.CommonArchiveInventory;
import com.ibm.migr.inventory.model.ContainedArchiveInventory;
import com.ibm.migr.inventory.model.InventoryReport;
import com.ibm.migr.inventory.model.Summary;
import com.ibm.websphere.jaxrs20.multipart.IAttachment;
import com.ibm.websphere.jaxrs20.multipart.IMultipartBody;

@Path("/calculate")
public class ComplexityCalculatorService {
	
	public static final String EAR_MODULE = "Enterprise archive";
	public static final String WEB_MODULE = "Web module";
	public static final String EJB_MODULE = "EJB module";
	public static final String APP_CLIENT_MODULE = "Application client module";
	public static final String RAR_MODULE = "Resource adapter module";
	public static final String UTIL_MODULE = "Utility JAR";
	
	public static final int MAX_BMP_ENTITY = 0;
	public static final int MAX_CMP_ENTITY = 0;
	public static final int MAX_MDB = 0;
	public static final int MAX_STATEFUL = 1;
	public static final int MAX_STATELESS = 1;
	public static final int MAX_JAXRPC_CONSUMERS = 0;
	public static final int MAX_JAXRPC_PROVIDERS = 0;
	
	
	
	
	
	@GET
	@Produces("text/plain")
	public String getHello(@QueryParam("name") String name) {
		System.out.println(name);
		return "Heloo " + name;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CalculationResult calculate(InventoryReport inventoryReport) {
		return calculateReportCompelxity(inventoryReport);
	}


	private CalculationResult calculateReportCompelxity(InventoryReport inventoryReport) {
		CalculationResult calculationResult = new CalculationResult();
		
		System.out.println("printApplications:");
		for (String application : inventoryReport.getApplications()) {
			System.out.println("Name: " + application);
		}
		
		System.out.println("Top Archives");
		Archives topArchives = inventoryReport.getArchives();
		System.out.println("getEars: " + topArchives.getEars());
		System.out.println("getEjbs" + topArchives.getEjbs());
		System.out.println("getWars" + topArchives.getWars());
		System.out.println("getRars: " + topArchives.getRars());
		System.out.println("getUtilityJars: " + topArchives.getUtilityJars());
		System.out.println("getAppClients: " + topArchives.getAppClients());
		
		System.out.println("Top Summary");
		Summary topSummary = inventoryReport.getSummary();
		System.out.println("getServlets: " + topSummary.getServlets());
		System.out.println("getJsps: " + topSummary.getJsps());
		System.out.println("getStatelessSessionBeans: " + topSummary.getStatelessSessionBeans());
		
		for( CommonArchiveInventory archiveInventory : inventoryReport.getArchiveInventory() ) {
			String moduleType = archiveInventory.getModuleType();
			if(EAR_MODULE.equals(moduleType)) {
					System.out.println("EAR - scan contained archives");
					List<ContainedArchiveInventory> appArchives = archiveInventory.getContainedArchiveInventory();
					for (ContainedArchiveInventory containedArchiveInventory : appArchives) {
						calculateModuleComplexity(containedArchiveInventory, calculationResult);
					}
			}
			else {
				calculateModuleComplexity(archiveInventory, calculationResult);
			
			}
			 
			
			
//			System.out.println("getEjbs" + appArchives.getEjbs());
//			System.out.println("getWars" + appArchives.getWars());
//			System.out.println("getRars: " + appArchives.getRars());
//			System.out.println("getUtilityJars: " + appArchives.getUtilityJars());
//			System.out.println("getAppClients: " + appArchives.getAppClients());
//			
//			System.out.println("Top Summary");
//			Summary appSummary = archiveInventory.getSummary();
//			System.out.println("getServlets: " + appSummary.getServlets());
//			System.out.println("getJsps" + appSummary.getJsps());
//			System.out.println("getStatelessSessionBeans" + appSummary.getStatelessSessionBeans());
			
			
			
			
			
		}
		
		return calculationResult;
	}
	
	private void calculateModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		String moduleType = archiveInventory.getModuleType();
		
//		switch (moduleType) {
//		case WEB_MODULE:
//			System.out.println("WEB_MODULE");
//			calculateWebModuleComplexity(archiveInventory, calculationResult);
//		break;
//		case EJB_MODULE:
//			System.out.println("EJB_MODULE");
//			calculateEJBModuleComplexity(archiveInventory, calculationResult);
//		break;
//		case APP_CLIENT_MODULE:
//			System.out.println("APP_CLIENT_MODULE");
//			calculateAppClientModuleComplexity(archiveInventory, calculationResult);
//		break;
//		case RAR_MODULE:
//			System.out.println("RAR_MODULE");
//			calculateRarModuleComplexity(archiveInventory, calculationResult);
//		break;
//		case UTIL_MODULE:
//			System.out.println("UTIL_MODULE");
//			calculateUtilModuleComplexity(archiveInventory, calculationResult);
//		break;
//
//		default:
//			System.out.println("Uknown module type: " + moduleType);
//		break;
		
		
		if (moduleType.equals(WEB_MODULE)) {
			calculateWebModuleComplexity(archiveInventory, calculationResult);
		} else if (moduleType.equals(EJB_MODULE)) {
				calculateEJBModuleComplexity(archiveInventory, calculationResult);
		} else if (moduleType.equals(APP_CLIENT_MODULE)) {
			calculateAppClientModuleComplexity(archiveInventory, calculationResult);
		} else if (moduleType.equals(RAR_MODULE)) {
			calculateRarModuleComplexity(archiveInventory, calculationResult);
		} else if (moduleType.equals(UTIL_MODULE)) {
			calculateUtilModuleComplexity(archiveInventory, calculationResult);
		} else {
			System.out.println("Uknown module type: " + moduleType);
		}
	}

	
	private void calculateWebModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		// TODO Auto-generated method stub
		Summary summary = archiveInventory.getSummary();

		DetectedTechnologies technologies = null;
		technologies = detectTechnologies(archiveInventory.getContainedArchiveInventory());
		
		if(summary.getJaxrpcConsumers() > MAX_JAXRPC_CONSUMERS || summary.getJaxrpcProviders() > MAX_JAXRPC_PROVIDERS || technologies.getHasSOAP() || technologies.getHasAXIS()) {
			calculationResult.setModerateWars(calculationResult.getModerateWars() + 1);
		}
		else {
			calculationResult.setSimpleWars(calculationResult.getSimpleWars() + 1);
		}
		
	}

	

	private void calculateEJBModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		// TODO Auto-generated method stub
		Summary summary = archiveInventory.getSummary();
		
		if(summary.getBmpEntityBeans() > MAX_BMP_ENTITY || summary.getCmpEntityBeans() > MAX_CMP_ENTITY ) {
			calculationResult.setComplexEJBs(calculationResult.getComplexEJBs() + 1);
		}
		else if(summary.getMessageDrivenBeans() > MAX_MDB || summary.getStatefulSessionBeans() > MAX_STATEFUL || summary.getStatelessSessionBeans() > MAX_STATELESS ) {
			calculationResult.setComplexEJBs(calculationResult.getComplexEJBs() + 1);
		}
		else {
			calculationResult.setModerateEJBs(calculationResult.getModerateEJBs() + 1);
		}
		
	}


	private void calculateAppClientModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		calculationResult.setAppClients(calculationResult.getAppClients() + 1);
		
	}

	private void calculateRarModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		calculationResult.setRars(calculationResult.getRars() + 1);
		
	}

	
	private void calculateUtilModuleComplexity(CommonArchiveInventory archiveInventory, CalculationResult calculationResult) {
		// TODO Auto-generated method stub
		// not used in calculating yet
		
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public CalculationResult calculateFromFile(IMultipartBody multipartBody) {
		CalculationResult CalculationResult = null;
		try {
		     List <IAttachment> attachments = multipartBody.getAllAttachments();
	         String formElementValue = null; 
	         InputStream stream = null;
	         for (Iterator<IAttachment> it = attachments.iterator(); it.hasNext();) {
	              IAttachment attachment = it.next();
	              if (attachment == null) {
	                  continue;
	              }
	              DataHandler dataHandler = attachment.getDataHandler();
	              stream = dataHandler.getInputStream();
	              
// DHV: Begin commented out unused code
//
//	              MultivaluedMap<String, String> map = attachment.getHeaders();
//	              String fileName = null;
//	              String formElementName = null;
//	              
//	              String[] contentDisposition = map.getFirst("Content-Disposition").split(";");
//	              for (String tempName : contentDisposition) {
////	            	  System.out.println("tempName: " + tempName);
//	                  String[] names = tempName.split("=");
//	                  if(names.length > 1) {
//		                  formElementName = names[1].trim().replaceAll("\"", "");
//		                  if ((tempName.trim().startsWith("filename"))) {
//		                      fileName = formElementName;
////		                      System.out.println("fileName:" + fileName);
//
// DHV: End commented out unused code 

							  ObjectMapper mapper = new ObjectMapper();
			                  InventoryReport inventoryReport = mapper.readValue(stream, InventoryReport.class);
			                  CalculationResult = calculateReportCompelxity(inventoryReport);
			                  
// DHV: Begin commented out unused code 
//
//		                  }
//	                  }
//	              }
//
// DHV: End commented out unused code 	
	              
	         }
	         if (stream != null) {
	             stream.close();
	         }
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return CalculationResult;
	}
	
	private DetectedTechnologies detectTechnologies(List<ContainedArchiveInventory> containedArchiveInventory) {
		// TODO Auto-generated method stub
		DetectedTechnologies technologies = new DetectedTechnologies();
		if(containedArchiveInventory != null) {
			for (ContainedArchiveInventory archive : containedArchiveInventory) {
				String archiveName = archive.getArchiveName();
				if(archiveName.contains("axis")) {
					System.out.println("## AXIS" + archiveName);
					technologies.setHasAXIS(true);
				}
				if(archiveName.contains("soap")) {
					System.out.println("## SOAP" + archiveName);
					technologies.setHasSOAP(true);
				}
			}
		}
		return technologies;
	}


	
}
