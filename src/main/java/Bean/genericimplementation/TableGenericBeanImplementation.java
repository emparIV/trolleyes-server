/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.genericimplementation;

import Bean.publicinterface.GenericBeanInterface;
import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Helper.EncodingUtilHelper;
import Helper.Log4jConfigurationHelper;
import com.google.gson.annotations.Expose;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Empar
 */
public abstract class TableGenericBeanImplementation extends ViewGenericBeanImplementation implements GenericBeanInterface {

    @Expose
    protected Integer id;

    public TableGenericBeanImplementation() {

    }

    public TableGenericBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getColumns() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field oField : oFields) {
                if (!oField.getName().startsWith("obj_")) {
                    strColumns += oField.getName() + ",";
                }
            }
            if (!strColumns.equals("")) {
                strColumns = strColumns.substring(0, strColumns.length() - 1);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String getValues() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field oField : oFields) {
                oField.setAccessible(true);
                if (!oField.getName().startsWith("obj_")) {
                    if (oField.getName().equals("password")) {
                        strColumns += EncodingUtilHelper.quotate("da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04") + ",";
                    } else {
                        if (oField.getType() == String.class) {
                            strColumns += EncodingUtilHelper.quotate((String) oField.get(this)) + ",";
                        } else {
                            if (oField.getType() == Date.class) {
                                strColumns += EncodingUtilHelper.stringifyAndQuotate((Date) oField.get(this)) + ",";
                            } else {
                                if (oField.getType() == Integer.class) {
                                    strColumns += (Integer) oField.get(this) + ",";
                                } else {
                                    if (oField.getType() == Double.class) {
                                        strColumns += (Double) oField.get(this) + ",";
                                    }
                                }
                            }
                        }
                    }
                }
                oField.setAccessible(false);
            }
            if (!strColumns.equals("")) {
                strColumns = strColumns.substring(0, strColumns.length() - 1);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

    @Override
    public String toPairs() throws Exception {
        String strColumns = "";
        try {
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                x.setAccessible(true);
                if (!x.getName().startsWith("obj_")) {
                    if (x.getName().equals("password")) {
                        strColumns += x.getName() + "=" + EncodingUtilHelper.quotate("da8ab09ab4889c6208116a675cad0b13e335943bd7fc418782d054b32fdfba04") + ",";
                    } else {
                        if (x.getType() == String.class) {
                            strColumns += x.getName() + "=" + EncodingUtilHelper.quotate((String) x.get(this)) + ",";
                        }
                        if (x.getType() == Date.class) {
                            strColumns += x.getName() + "=" + EncodingUtilHelper.stringifyAndQuotate((Date) x.get(this)) + ",";
                        }
                        if (x.getType() == Integer.class) {
                            strColumns += x.getName() + "=" + x.get(this) + ",";
                        }
                        if (x.getType() == Double.class) {
                            strColumns += x.getName() + "=" + x.get(this) + ",";
                        }
                    }

                }
                x.setAccessible(false);
            }
            if (!strColumns.equals("")) {
                strColumns = strColumns.substring(0, strColumns.length() - 1);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return strColumns;
    }

}

