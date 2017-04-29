/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package test;

//JSON processing
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

//Java
import java.util.ArrayList;
import java.util.List;

//JUnit
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

//Data Model
import com.ibm.migr.inventory.CalculationResult;

public class TestApplication {
	
	private static String expectedJson = "{\"simpleWars\":1,\"appClients\":2,\"moderateWars\":3,\"moderateEJBs\":4,\"rars\":5,\"complexWars\":6,\"complexEJBs\":7}";

	private static com.ibm.migr.inventory.CalculationResult expectedObject = null;

	@BeforeClass
	public static void runBeforeClass() {
 	// run for one time before all test cases

    expectedObject = new CalculationResult();
 	expectedObject.setSimpleWars(1);
 	expectedObject.setAppClients(2);
 	expectedObject.setModerateWars(3);	
 	expectedObject.setModerateEJBs(4);
 	expectedObject.setRars(5);
 	expectedObject.setComplexWars(6);
 	expectedObject.setComplexEJBs(7);
	}

	@AfterClass
	public static void runAfterClass() {
	// run for one time after all test cases
		expectedObject = null;
	}
	
 @Test
 public void testJson2CalculationResult() {
		// read json test
		try {
 		JsonReader reader = Json.createReader(new StringReader(expectedJson));
 		JsonObject jsonObject = reader.readObject();
 		reader.close();
 		
 		CalculationResult actualObject = new CalculationResult();
        actualObject.setSimpleWars( jsonObject.getInt("simpleWars") );
     	actualObject.setAppClients( jsonObject.getInt("appClients") );
     	actualObject.setModerateWars( jsonObject.getInt("moderateWars") );
     	actualObject.setModerateEJBs( jsonObject.getInt("moderateEJBs") );
     	actualObject.setRars( jsonObject.getInt("rars") );
     	actualObject.setComplexWars( jsonObject.getInt("complexWars") );
     	actualObject.setComplexEJBs( jsonObject.getInt("complexEJBs") );
 
 		String actualJson = actualObject.toString();
 		System.out.println("expectedJson: " + expectedJson);
 		System.out.println("actualJson  : " + actualJson);
 		
        assertTrue("Incorrect value, value is " + actualJson, actualJson.equals(expectedJson));

 	} catch (Exception e) {
			e.printStackTrace();
	}
 }

 @Test
 public void testCalculationResult2Json() {
		// write json test
		try {
 		JsonObject actualJson = Json.createObjectBuilder()
 				.add( "simpleWars", expectedObject.getSimpleWars() )
 				.add( "appClients", expectedObject.getAppClients() )
				.add( "moderateWars", expectedObject.getModerateWars() )
				.add( "moderateEJBs", expectedObject.getModerateEJBs() ) 								
 				.add( "rars", expectedObject.getRars() )
				.add( "complexWars", expectedObject.getComplexWars() )
				.add( "complexEJBs", expectedObject.getComplexEJBs() )
 				.build();
 		
 		CalculationResult actualObject = new CalculationResult();
        actualObject.setSimpleWars( actualJson.getInt("simpleWars") );
        actualObject.setAppClients( actualJson.getInt("appClients") );
        actualObject.setModerateWars( actualJson.getInt("moderateWars") );
        actualObject.setModerateEJBs( actualJson.getInt("moderateEJBs") );
        actualObject.setRars( actualJson.getInt("rars") );
        actualObject.setComplexWars( actualJson.getInt("complexWars") );
        actualObject.setComplexEJBs( actualJson.getInt("complexEJBs") );
        
 		System.out.println("expectedObject.toString() : " + expectedObject.toString());
 		System.out.println("actualObject.toString()   : " + actualObject.toString());
 		
        assertFalse("Incorrect value, value is " + actualObject.toString(), actualObject.equals(expectedObject));

 	} catch (Exception e) {
			e.printStackTrace();
		}

	}

}