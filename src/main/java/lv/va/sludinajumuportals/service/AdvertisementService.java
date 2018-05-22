package lv.va.sludinajumuportals.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lv.va.sludinajumuportals.domain.Advertisement;

import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    String name = "Marks";
    public List<Advertisement> hardcodedAdvertisementList;
    public List<Advertisement> reverseAdvertisementList;

    public AdvertisementService() {
        hardcodedAdvertisementList = hardcodedAdvertisementInitialization();
        reverseAdvertisementList = hardcodedAdvertisementList;
        Collections.reverse(reverseAdvertisementList);
    }

    public Advertisement getAdvertisement() {
        Advertisement advertisement = new Advertisement(1L, "Title1", "Message1", "Author1");
        return advertisement;
    }

    public List<Advertisement> getAdvertisementListByAuthor(String author) {
        List<Advertisement> filteredByName = new ArrayList<>();
        for (Advertisement advertisement : hardcodedAdvertisementList) {
            if (advertisement.getAuthor().equals(author)) {
                filteredByName.add(advertisement);
            }
        }
        return filteredByName;
    }

    public List<Advertisement> getAdvertisementListReverse() {
        return reverseAdvertisementList;
    }

    public ArrayList<Advertisement> getAdvertisementList() {
        ArrayList<Advertisement> advertisements = new ArrayList<>();
        Advertisement advertisement = new Advertisement(1L, "Title2", "Message2", "Author2");

        advertisements.add(advertisement);
        return advertisements;
    }

    private List<Advertisement> hardcodedAdvertisementInitialization() {
        List<Advertisement> advertisements = new ArrayList();
        for (int i = 1; i < name.length(); i++) {
            Advertisement advertisement = new Advertisement(Long.valueOf(i), "Title", "Message" + i, getAuthorName(i));
            advertisements.add(advertisement);
        }
        return advertisements;
    }

    private String getAuthorName(int i) {
        if (i % 2 == 0) {
            return "Peteris";
        }
        return "Marks";
    }

}
