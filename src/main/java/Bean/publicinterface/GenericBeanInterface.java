/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.publicinterface;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Empar
 */
public interface GenericBeanInterface {

    public String getColumns() throws Exception;
 
    public String getValues() throws Exception;
 
    public String toPairs() throws Exception;
 
    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, UsuarioSpecificBeanImplementation oPuserBean_security, Integer expand) throws Exception;
 
}