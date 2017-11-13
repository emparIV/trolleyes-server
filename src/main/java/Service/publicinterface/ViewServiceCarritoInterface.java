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
public interface ViewServiceCarritoInterface {

    public ReplyBean list() throws Exception;

    public ReplyBean buy() throws Exception;

    public ReplyBean empty() throws Exception;
}
