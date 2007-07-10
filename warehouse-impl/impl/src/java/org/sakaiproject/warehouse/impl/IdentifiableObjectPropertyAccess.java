/**********************************************************************************
* $URL$
* $Id$
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

import org.sakaiproject.metaobj.shared.model.IdentifiableObject;

/**
 * Created by IntelliJ IDEA.
 * User: John Ellis
 * Date: Dec 18, 2005
 * Time: 9:33:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdentifiableObjectPropertyAccess extends BeanPropertyAccess {

   public Object getPropertyValue(Object source) throws Exception {
      Object obj = super.getPropertyValue(source);
      IdentifiableObject object = null;
      try {
         object = (IdentifiableObject)obj;
      } catch(ClassCastException cce) {
         throw new Exception("Class " + obj.getClass().getName() + 
               " is not derived from IdentifiableObject", cce);
      }
      if (object != null) {
         if(object.getId() != null)
            return object.getId().getValue();
      }
      return null;
   }
}
