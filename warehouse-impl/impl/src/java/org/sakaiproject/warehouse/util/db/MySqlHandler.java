/**********************************************************************************
* $URL:https://source.sakaiproject.org/svn/osp/trunk/warehouse/api-impl/src/java/org/theospi/portfolio/util/db/MySqlHandler.java $
* $Id:MySqlHandler.java 9134 2006-05-08 20:28:42Z chmaurer@iupui.edu $
***********************************************************************************
*
 * Copyright (c) 2005, 2006, 2007, 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*
**********************************************************************************/
package org.sakaiproject.warehouse.util.db;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.sakaiproject.warehouse.util.db.DbLoader;

/**
 * MySQL table handler
 *
 * @see org.sakaiproject.warehouse.util.db.GenericTableHandler
 * @author <a href="felipeen@udel.edu">Luis F.C. Mendes</a> - University of Delaware
 * @version $Revision 1.0 $
 */
public class MySqlHandler implements ContentHandler{

   private static final int UNSET = -1;
   private static final int DROP = 0;
   private static final int CREATE = 1;
   private static final int ALTER = 2;
   private static final int INDEX = 3;
   private static int mode = UNSET;
   private static StringBuilder stmtBuffer;
   private int treeLevel;
   private String tmpType;
   private String tmpParm;
   private DbLoader loader;

   protected final Log logger = LogFactory.getLog(getClass());

   public MySqlHandler(DbLoader loader){
      logger.debug("MySQL table handler...");
     this.loader = loader;
   }

   public void startDocument ()
   {
   }

   public void endDocument ()
   {
      //System.out.println();
   }

   public void startElement (String namespaceURI, String localName, String qName, Attributes atts)
   {
      if (qName.equals("statement"))
      {
       tmpType = "";
       tmpParm = "";
       treeLevel = 0;
       stmtBuffer = new StringBuilder(1024);
       String statementType = atts.getValue("type");

       if (mode == UNSET || mode != DROP && statementType != null && statementType.equals("drop"))
       {
         mode = DROP;

         logger.debug("Dropping tables...");

         if (!this.loader.isDropTables())
            logger.debug("disabled.");
       }
       else if (mode == UNSET || mode != CREATE && statementType != null && statementType.equals("create"))
       {
         mode = CREATE;

         logger.debug("Creating tables...");

         if (!this.loader.isCreateTables())
            logger.debug("disabled.");
       }
       else if (mode == UNSET || mode != ALTER && statementType != null && statementType.equals("alter"))
       {
         mode = ALTER;

         logger.debug("Altering tables...");

         if (!this.loader.isAlterTables())
            logger.debug("disabled.");
       }
       else if (mode == UNSET || mode != INDEX && statementType != null && statementType.equals("index"))
       {
         mode = INDEX;

         logger.debug("Indexing tables...");

         if (!this.loader.isIndexTables())
            logger.debug("disabled.");
       }

      }
     if (qName.equals("column-type")){
       ++treeLevel;
       tmpType = "";
     }
     if (qName.equals("type-param")){
       ++treeLevel;
       tmpParm = "";
     }

   }

   public void endElement (String namespaceURI, String localName, String qName)
   {
     if (qName.equals("statement"))
     {
       treeLevel = 0;
       String statement = stmtBuffer.toString();
       switch (mode)
       {
         case DROP:
            if (this.loader.isDropTables()){
              statement += " CASCADE";
              this.loader.dropTable(statement);
               }
            break;
         case CREATE:
            if (this.loader.isCreateTables()){
              //System.out.println("CREATE TABLES: " + statement);
              this.loader.createTable(statement);
            }
            break;
         case ALTER:
            if (this.loader.isAlterTables()){
              //System.out.println("ALTER TABLES: " + statement);
              this.loader.alterTable(statement);
            }
            break;
         case INDEX:
            if (this.loader.isIndexTables()){
              //System.out.println("INDEX TABLES: " + statement);
              this.loader.indexTable(statement);
            }
            break;
         default:
            break;
       }
      }

     if(qName.equals("column-type"))
       --treeLevel;
     if(qName.equals("type-param"))
       --treeLevel;
     if(treeLevel == 0)
       parseParamToDatabase();
   }

   public void characters (char ch[], int start, int length)
   {
     if(treeLevel == 0)
       stmtBuffer.append(ch, start, length);
     else
       if(treeLevel == 1)
         tmpType =  new String(ch, start, length);
       else
         if(treeLevel == 2)
            tmpParm =  new String(ch, start, length);
   }

   private void parseParamToDatabase(){
     int parm = 0;

     //check if this datatype is varchar, if > 255, if MySQL 
     if(tmpParm != null && tmpParm.length() > 0){

       parm = Integer.parseInt(tmpParm);

       if(tmpType.equals("VARCHAR")){
         if(parm >= 256){
            stmtBuffer.append("TEXT");
         }
         else{
            stmtBuffer.append(tmpType.trim());
            stmtBuffer.append("(" + tmpParm.trim() + ")");
         }
       }
       else{
         stmtBuffer.append(tmpType.trim());
         stmtBuffer.append("(" + tmpParm.trim() + ")");
       }
     }
     else{
       stmtBuffer.append(tmpType.trim());
     }

     tmpParm = "";
     tmpType = "";
   }

   public void setDocumentLocator (Locator locator)
   {
   }

   public void processingInstruction (String target, String data)
   {
   }

   public void ignorableWhitespace (char[] ch, int start, int length)
   {
   }

   public void startPrefixMapping (String prefix, String uri) throws SAXException {};
   public void endPrefixMapping (String prefix) throws SAXException  {};
   public void skippedEntity(String name) throws SAXException {};

}
