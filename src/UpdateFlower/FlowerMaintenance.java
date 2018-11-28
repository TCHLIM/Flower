
package UpdateFlower;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;

public class FlowerMaintenance implements FlowerMaintenanceInterface{
    public ListInterface<Flower> update(ListInterface<Flower> flowerList, Flower flower) {
        flowerList.replace(flowerList.containsposition(flower), flower);
        return flowerList;
    }
    public ListInterface<Flower> updateQuan(ListInterface<Flower> flowerList, Flower flower,int quan) {
        flower.setQuantity(flower.getQuantity()+quan);
        flowerList.replace(flowerList.containsposition(flower), flower);
        return flowerList;
    }

    public ListInterface<Flower> delete(ListInterface<Flower> flowerList, Flower flower) {
        flowerList.getEntry(flowerList.containsposition(flower)).setStatus(false);
        return flowerList;
    }

    public ListInterface<Flower> delete(ListInterface<Flower> flowerList, int selectiondelete) {
        ListInterface<Flower> tmp = new List<>();
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                tmp.add(flowerList.getEntry(i));
            }
        }
        Flower staff = tmp.getEntry(selectiondelete - 1);
        flowerList = delete(flowerList, staff);
        return flowerList;
    }
}
