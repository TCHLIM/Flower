/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promotion;

import ADT.List;
import ADT.ListInterface;
import domain.Promotion;

public interface PromotionMaintenanceInterface {
    public ListInterface<Promotion> update (ListInterface<Promotion> promotionList,Promotion promotion);
    public ListInterface<Promotion> delete(ListInterface<Promotion> promotionList, Promotion promotion);
    public ListInterface<Promotion> delete(ListInterface<Promotion> promotionList, int selectiondelete);
    public ListInterface<Promotion> updateQuan(ListInterface<Promotion> promotionList, Promotion promotion,int disc);
    
}
