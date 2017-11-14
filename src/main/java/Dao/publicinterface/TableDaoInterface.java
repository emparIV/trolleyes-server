/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.publicinterface;

/**
 *
 * @author Empar
 */
public interface TableDaoInterface<GenericTableBean> {

    public GenericTableBean get(int id, int intExpand) throws Exception;

    public Integer set(GenericTableBean oBean) throws Exception;

    public int remove(Integer id) throws Exception;

}
