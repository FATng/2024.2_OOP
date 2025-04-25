package hust.soict.hedspi.test;

import hust.soict.hedspi.aims.media.Media;
import java.util.Collections;
import java.util.List;

public class SortMedia {
    public void sortByTitleCost(List<Media> mediaList) {
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle(List<Media> mediaList) {
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
    }
}