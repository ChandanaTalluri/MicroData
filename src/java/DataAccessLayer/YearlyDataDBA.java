/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import MicroDomain.TotalCovered;
import MicroDomain.YearlyData;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author 0809379
 */
public class YearlyDataDBA {
     public static String findTCJobsData() {
        YearlyData objData = new YearlyData();
         EntityManager objEntity = EstablishDataConnection.getEntityManager().createEntityManager();
        HashMap objHmp = new HashMap();
        String strData = "";
        String strDatalist = null;
        try{
           
            String sql = "Select c.yearly ,c.TC_Jobs " 
                    + " from YearlyData c ";
            
                 TypedQuery strQuery  = objEntity.createQuery(sql,YearlyData.class);
            
            
            List objList = strQuery.getResultList();
            for(int i=0;i<objList.size();i++){
                Object[] objArray = (Object[])objList.get(i);
                    //String strYears = (String) objArray[0];
                    //String strJobs = (String) objArray[1];
                    int years = (int) objArray[0];
                    float jobs = (float) objArray[1];
                   objHmp.put(years,jobs);
                strData = strData+ "{x: "+ years + ",y:"+  jobs +"},";
            }
             strDatalist = strData.substring(0, strData.length() - 1);      
        
        System.out.println("YearlyData for TC_Jobs"+strDatalist);
          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
         return strDatalist;
    }
     public static String find_MFG_JobsData() {
        
         EntityManager objEntity = EstablishDataConnection.getEntityManager().createEntityManager();
        HashMap objHmp = new HashMap();
        String strData = "";
        String strDatalist = null;
        try{
           
            String sql = "Select c.yearly ,c.MFG_Jobs " 
                    + " from YearlyData c ";
            
                 TypedQuery strQuery  = objEntity.createQuery(sql,YearlyData.class);
            
            
            List objList = strQuery.getResultList();
            for(int i=0;i<objList.size();i++){
                Object[] objArray = (Object[])objList.get(i);
                    int years = (int) objArray[0];
                    float jobs = (float) objArray[1];
                   objHmp.put(years,jobs);
                strData = strData+ "{x: "+ years + ",y:"+  jobs +"},";
            }
             strDatalist = strData.substring(0, strData.length() - 1);      
        
        System.out.println("YearlyData for MFG_Jobs"+strDatalist);
          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            objEntity.close();
        }
         return strDatalist;
    }
}