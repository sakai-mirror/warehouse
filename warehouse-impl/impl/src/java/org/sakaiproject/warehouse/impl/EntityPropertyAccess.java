/**********************************************************************************
* $URL:https://source.sakaiproject.org/svn/osp/trunk/warehouse/api-impl/src/java/org/theospi/portfolio/warehouse/impl/EntityPropertyAccess.java $
* $Id:EntityPropertyAccess.java 9134 2006-05-08 20:28:42Z chmaurer@iupui.edu $
***********************************************************************************
*
* Copyright (c) 2005, 2006 The Sakai Foundation.
*
* Licensed under the Educational Community License, Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.opensource.org/licenses/ecl1.php
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
**********************************************************************************/
package org.sakaiproject.warehouse.impl;

import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.warehouse.service.PropertyAccess;

/**
 * Created by IntelliJ IDEA.
 * User: John Ellis
 * Date: Nov 30, 2005
 * Time: 5:48:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityPropertyAccess implements PropertyAccess {

   private String propertyName;

   public Object getPropertyValue(Object source)
      throws Exception {
      Entity entity = null;

      try {
         entity = (Entity)source;
      } catch(ClassCastException e) {
         throw new Exception("The source could not be cast into an Entity for property \"" + propertyName +  "\"", e);
      }

      return entity.getProperties().getProperty(getPropertyName());
   }

   public String getPropertyName() {
      return propertyName;
   }

   public void setPropertyName(String propertyName) {
      this.propertyName = propertyName;
   }

}
