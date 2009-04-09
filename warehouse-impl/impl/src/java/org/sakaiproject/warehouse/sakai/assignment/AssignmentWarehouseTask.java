/**********************************************************************************
 * $URL:$
 * $Id:$
 ***********************************************************************************
 *
 * Copyright (c) 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package org.sakaiproject.warehouse.sakai.assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sakaiproject.warehouse.impl.BaseWarehouseTask;

public class AssignmentWarehouseTask extends BaseWarehouseTask{

	private AssignmentWarehouseService assignmentDWService;

	protected Collection getItems() {
		// TODO Auto-generated method stub
		System.out.println("\n\nGOING TO get ASSINGMENTWAREHOUSEITEMS!\n\n");
		List items  = new ArrayList();


		items.addAll(assignmentDWService.getDWAssignmentStatusAll());

		//some service to get the fields needed for the
		//warehouse (get???????ForWarehouse()) return collection
		return items;
	}



	private AssignmentStatus getTestAssignment(){

		AssignmentStatus as = new AssignmentStatus();
		as.setAdvisor("advisor_12345");
		as.setAssignment_grade("A++");
		as.setAssignment_id("123456789");
		as.setAssignment_status("completed");
		as.setClass_year("1999");
		as.setCourse_code("CALC 422");
		as.setCourse_section("422");
		as.setCourse_term("FALL");
		as.setDistrict("Madison");
		as.setInstructor("Dr. Pheanis");
		as.setSchool("St. Mary's");
		as.setStudent_first_name("Lea");
		as.setStudent_last_name("Suft");
		as.setUser_id("lsuft");


		return as;


	}



	public AssignmentWarehouseService getAssignmentDWService() {
		return assignmentDWService;
	}



	public void setAssignmentDWService(
			AssignmentWarehouseService assignmentDWService) {
		this.assignmentDWService = assignmentDWService;
	}


}
