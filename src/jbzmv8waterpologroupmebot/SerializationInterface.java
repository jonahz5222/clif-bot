/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import javafx.event.ActionEvent;

/**
 *
 * @author jonahzukosky
 */
public interface SerializationInterface {
    void handleSaveBot(ActionEvent event);
    void handleLogoutButton(ActionEvent event);
    void deserializer();
}
