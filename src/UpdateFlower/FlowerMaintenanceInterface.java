
package UpdateFlower;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;

public interface FlowerMaintenanceInterface {
    public ListInterface<Flower> update (ListInterface<Flower> flowerList,Flower flower);
    public ListInterface<Flower> delete(ListInterface<Flower> flowerList, Flower flower);
    public ListInterface<Flower> delete(ListInterface<Flower> flowerList, int selectiondelete);
    public ListInterface<Flower> updateQuan(ListInterface<Flower> flowerList, Flower flower,int quan);
  
    
}
