package lab02;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private int ordered;
    
    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (ordered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Can't add more disc");
            return 0;
        } else {
            itemsOrdered[ordered] = disc;
            ordered ++;
            System.out.println("The DVD " + '\"' +disc.getTitle() + '\"' + " have been added!");
            return 1;
        }
    }

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(itemsOrdered[0] ==  null) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for(int i =0; i < ordered;i++) {
            if(itemsOrdered[i].equals(disc)) {
                for(int j = i;j<ordered-1;j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[ordered-1] = null;
                ordered--;
                System.out.println("Remove DVD " + '\"'+ disc.getTitle() + '\"' + " successfully!");
                return 1;
            }
        }
        System.out.println("No DVD match!");
        return 0;
    }

    public float totalCost() {
        float sum = 0.00f;
        for(int i =0;i< ordered;i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
    
    public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int addedCount = 0;
        for (DigitalVideoDisc dvd : dvdList) {
            if (ordered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[ordered] = dvd;
                ordered++;
                addedCount++;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added!");
            } else {
                System.out.println("The cart is full. Can't add more DVDs.");
                break;
            }
        }
        return addedCount;
    }
    
    public int addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        int addedCount = 0;
        for (DigitalVideoDisc dvd : dvds) {
            if (ordered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[ordered] = dvd;
                ordered++;
                addedCount++;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added!");
            } else {
                System.out.println("The cart is full. Can't add more DVDs.");
                break;
            }
        }
        return addedCount;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int addedCount = 0;
        if (ordered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[ordered] = dvd1;
            ordered++;
            addedCount++;
            System.out.println("The DVD \"" + dvd1.getTitle() + "\" has been added!");
        }
        if (ordered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[ordered] = dvd2;
            ordered++;
            addedCount++;
            System.out.println("The DVD \"" + dvd2.getTitle() + "\" has been added!");
        }
        return addedCount;
    }
}