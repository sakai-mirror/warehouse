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
package org.sakaiproject.warehouse.sakai.resource;

import org.sakaiproject.content.api.ContentCollection;
import org.sakaiproject.content.api.ContentResource;

/**
 * Created by IntelliJ IDEA.
 * User: John Ellis
 * Date: Dec 19, 2005
 * Time: 11:11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringResourcePropertyAccess extends ResourcePropertyPropertyAccess {

    public Object getPropertyValue(Object source) throws Exception {
        String propName = (String) super.getPropertyValue(source);
        if (source instanceof ContentResource) {
            return ((ContentResource) source).getProperties().getProperty(propName);
        } else if (source instanceof ContentCollection) {
            return ((ContentCollection) source).getProperties().getProperty(propName);
        }
        return null;

    }
}