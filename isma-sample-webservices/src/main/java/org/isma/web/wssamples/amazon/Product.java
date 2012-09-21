package org.isma.web.wssamples.amazon;

import com.ECS.client.jax.Item;

public class Product {
    private Item item;

    public Product(Item item) {
        this.item = item;
    }

    public String getAsin() {
        return item.getASIN();
    }

    public String getMediumImageUrl() {
        return item.getMediumImage() != null ? item.getMediumImage().getURL() : "";
    }

    public String getBrand() {
        return item.getItemAttributes().getBrand();
    }

    public String getEdition() {
        return item.getItemAttributes().getEdition();
    }

    public String getGenre() {
        return item.getItemAttributes().getGenre();
    }

    public String getHardwarePlatform() {
        return item.getItemAttributes().getHardwarePlatform();
    }

    public String getOperatingSystem() {
        return item.getItemAttributes().getOperatingSystem();
    }

    public String getTitle() {
        return item.getItemAttributes().getTitle();
    }


}
