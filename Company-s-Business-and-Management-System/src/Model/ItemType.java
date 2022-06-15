/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class ItemType {
    private String ItemTypeName;

    public ItemType() {
    }

    public ItemType(String ItemTypeName) {
        this.ItemTypeName = ItemTypeName;
    }

    public String getItemTypeName() {
        return ItemTypeName;
    }

    public void setItemTypeName(String ItemTypeName) {
        this.ItemTypeName = ItemTypeName;
    }
    
}
