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

package org.sakaiproject.warehouse.model;


/**
 * Created by IntelliJ IDEA.
 * User: bbiltimier
 * Date: Mar 15, 2007
 * Time: 9:59:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserBean {
    String userId;

    String userEid;

    String email;

    String emailLc;

    String type;

    String firstName;

    String LastName;

    public UserBean(String userId, String userEid, String email, String emailLc, String firstName, String lastName, String type)
            {
                setUserId(userId);
                setUserEid(userEid);
                setEmail(email);
                setEmailLc(emailLc);
                setType(type);
                setFirstName(firstName);
                setLastName(lastName);
            }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEid() {
        return userEid;
    }

    public void setUserEid(String userEid) {
        this.userEid = userEid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailLc() {
        return emailLc;
    }

    public void setEmailLc(String emailLc) {
        this.emailLc = emailLc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
