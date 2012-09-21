package org.isma.web.wssamples.amazon;

import com.ECS.client.jax.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SampleAmazon {
    private static final Logger LOG = Logger.getLogger(SampleAmazon.class);
    private AWSECommerceService service;
    private final AWSECommerceServicePortType port;
    private final ItemSearchRequest itemRequest;
    private final ItemSearch itemSearch;

    public SampleAmazon() {
        LOG.debug("SampleAmazon constructor");

        LOG.debug("creating service...");
        service = new AWSECommerceService();
        service.setHandlerResolver(new AwsHandlerResolver(AmazonAcces.SECRET_KEY));

        LOG.debug("creating port...");
        port = service.getAWSECommerceServicePort();

        LOG.debug("creating itemRequest...");
        itemRequest = new ItemSearchRequest();
//        itemRequest.setSearchIndex("VideoGames");
        itemRequest.getResponseGroup().add("Large");//TODO a voir !! PAS DANS L EXEMPLE AMAZON

        LOG.debug("creating itemSearch...");
        itemSearch = new ItemSearch();
        itemSearch.setAWSAccessKeyId(AmazonAcces.ACCESS_ID);
        itemSearch.setAssociateTag("valeur bidon");//TODO a comprendre (lol si c'est null ça marche pas)

        itemSearch.getRequest().add(itemRequest);
    }

    public List<Product> requestProductList(String searchIndex, String keysWords) throws Exception {
        itemRequest.setSearchIndex(searchIndex);
        itemRequest.setKeywords(keysWords);

        LOG.debug("requesting a response...");
        ItemSearchResponse response = port.itemSearch(itemSearch);
        LOG.debug("response requested.");


        if (response.getOperationRequest().getErrors() != null) {
            throw new Exception(response.getOperationRequest().getErrors().getError().get(0).getMessage());
        }

        LOG.debug("requestProcessingTime  = " + response.getOperationRequest().getRequestProcessingTime());
        // Get the Title names of all the books for all the items returned in the response
        List<Product> productList = new ArrayList<Product>();
        for (Items itemList : response.getItems()) {
            System.out.println("ITEMLIST");
            for (Item item : itemList.getItem()) {
                System.out.println("\tName: " + item.getItemAttributes().getTitle());
                item.getItemAttributes().getBrand();
                item.getItemAttributes().getEdition();
                item.getItemAttributes().getGenre();
                item.getItemAttributes().getHardwarePlatform();
                item.getItemAttributes().getOperatingSystem();
                item.getItemAttributes().getTitle();
                productList.add(new Product(item));
            }
        }
        LOG.debug("requestProductList ending.");
        return productList;
    }


}
