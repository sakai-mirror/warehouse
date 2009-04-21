/**********************************************************************************
 * $URL$
 * $Id$
 ***********************************************************************************
 *
 * Copyright (c) 2007, 2008 The Sakai Foundation
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

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: bbiltimier
 * Date: Mar 15, 2007
 * Time: 9:59:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class SessionBean {
    String id;

    String server;

    String user;

    String ip;

    String userAgent;

    Timestamp start;

    Timestamp end;

    long duration;

    public SessionBean(String id, String server, String user, String address, String agent, Timestamp start, Timestamp end)
            {
                setId(id);
                setServer(server);
                setUser(user);
                setIp(address);
                setUserAgent(agent);
                setStart(start);
                setEnd(end);
            }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public long getDuration() {
        return getEnd().getTime() - getStart().getTime();
    }


}
