package studio.thinkground.testproject.data.dao;

import studio.thinkground.testproject.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity getProduct(String productID);

}
