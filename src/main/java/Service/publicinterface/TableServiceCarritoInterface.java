/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.publicinterface;

import Bean.ReplyBean;

/**
 *
 * @author Empar
 */
public interface TableServiceCarritoInterface {

    public ReplyBean add() throws Exception;

    public ReplyBean remove() throws Exception;
}
