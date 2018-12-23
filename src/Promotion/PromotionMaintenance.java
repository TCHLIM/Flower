/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promotion;

import ADT.List;
import ADT.ListInterface;
import domain.Promotion;

public class PromotionMaintenance implements PromotionMaintenanceInterface{
    public ListInterface<Promotion> update(ListInterface<Promotion> promotionList, Promotion promotion) {
        promotionList.replace(promotionList.containsposition(promotion), promotion);
        return promotionList;
    }
    public ListInterface<Promotion> updatePrice(ListInterface<Promotion> promotionList, Promotion promotion,double disc) {
        promotion.setDiscount(promotion.getDiscount()+disc);
        promotionList.replace(promotionList.containsposition(promotion), promotion);
        return promotionList;
    }

    public ListInterface<Promotion> delete(ListInterface<Promotion> promotionList, Promotion promotion) {
        promotionList.getEntry(promotionList.containsposition(promotion)).setStatus(false);
        return promotionList;
    }

    public ListInterface<Promotion> delete(ListInterface<Promotion> promotionList, int selectiondelete) {
        ListInterface<Promotion> tmp = new List<>();
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                tmp.add(promotionList.getEntry(i));
            }
        }
        Promotion promotion = tmp.getEntry(selectiondelete - 1);
        promotionList = delete(promotionList, promotion);
        return promotionList;
    }
}