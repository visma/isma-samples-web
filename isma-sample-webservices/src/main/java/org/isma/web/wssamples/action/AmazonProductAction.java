package org.isma.web.wssamples.action;

import com.opensymphony.xwork2.ActionSupport;
import org.isma.web.wssamples.amazon.Product;
import org.isma.web.wssamples.amazon.SampleAmazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonProductAction extends ActionSupport {
    private String searchKeyWords = "";
    private String searchIndex = "";
    private final SampleAmazon sampleAmazon = new SampleAmazon();

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public void setSearchKeyWords(String searchKeyWords) {
        this.searchKeyWords = searchKeyWords;
    }

    public void setSearchIndex(String[] label){
        searchIndex = label[0];
    }

    public List<Product> getProductList() throws Exception {
        if (searchKeyWords.trim().length() == 0) {
            return new ArrayList<Product>();
        }
        return sampleAmazon.requestProductList(searchIndex, searchKeyWords);
    }

    public List<ProductType> getSearchIndexList(){
        List<ProductType> productTypeList = new ArrayList<ProductType>();
        productTypeList.add(new ProductType("All"));
        productTypeList.add(new ProductType("Books"));
        productTypeList.add(new ProductType("DVD"));
        productTypeList.add(new ProductType("Electronics"));
        productTypeList.add(new ProductType("Music"));
        productTypeList.add(new ProductType("Toys"));
        productTypeList.add(new ProductType("VideoGames"));
        return productTypeList;
    }

    private class ProductType {
        private final String id;
        private final String label;

        private ProductType(String label) {
            this.label = label;
            this.id = label;
        }

        public String getId() {
            return id;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
