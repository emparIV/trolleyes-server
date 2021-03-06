/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;
import Bean.publicinterface.GenericBeanInterface;
import Dao.specificimplementation.UsuarioSpecificDaoImplementation;
import Helper.EncodingUtilHelper;
import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Empar
 */
public class PedidoSpecificBeanImplementation extends TableGenericBeanImplementation {
    
    @Expose
    private Date fecha;
    @Expose
    private Integer iva;
    @Expose
    private Boolean tiene_iva;
    @Expose(serialize = false)
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    private UsuarioSpecificBeanImplementation obj_usuario = null;
    
    public PedidoSpecificBeanImplementation() {
        
    }
    
    public PedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }
    
    public PedidoSpecificBeanImplementation(Integer id_usuario, Date dateFecha) {
        this.id_usuario = id_usuario;
        this.fecha = dateFecha;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Integer getIva() {
        return iva;
    }
    
    public void setIva(Integer iva) {
        this.iva = iva;
    }
    
    public Boolean getTiene_iva() {
        return tiene_iva;
    }
    
    public void setTiene_iva(Boolean tiene_iva) {
        this.tiene_iva = tiene_iva;
    }
    
    public Integer getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public UsuarioSpecificBeanImplementation getObj_usuario() {
        return obj_usuario;
    }
    
    public void setObj_usuario(UsuarioSpecificBeanImplementation obj_usuario) {
        this.obj_usuario = obj_usuario;
    }
    
    @Override
    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, UsuarioSpecificBeanImplementation oPuserBean_security, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setFecha(oResultSet.getDate("fecha"));
        this.setIva(oResultSet.getInt("iva"));
        this.setTiene_iva(oResultSet.getBoolean("tiene_iva"));
        this.setId_usuario(oResultSet.getInt("id_usuario"));
        if (expand > 0) {
            UsuarioSpecificBeanImplementation oUsuarioBean = new UsuarioSpecificBeanImplementation();
            UsuarioSpecificDaoImplementation oUsuarioDao = new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, null);
            oUsuarioBean = (UsuarioSpecificBeanImplementation) oUsuarioDao.get(oResultSet.getInt("id_usuario"), expand - 1);
            this.setObj_usuario(oUsuarioBean);
        } else {
            this.setId_usuario(oResultSet.getInt("id_usuario"));
        }
        
        return this;
    }
}
